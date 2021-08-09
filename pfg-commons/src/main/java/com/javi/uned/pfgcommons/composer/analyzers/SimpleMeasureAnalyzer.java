package com.javi.uned.pfgcommons.composer.analyzers;

import com.javi.uned.pfgcommons.composer.analyzers.configs.ConfigValue;
import com.javi.uned.pfgcommons.composer.analyzers.configs.SimpleMeasureAnalyzerConfig;
import com.javi.uned.pfgcommons.model.measures.MelodiaMeasure;
import com.javi.uned.pfgcommons.model.measures.SimpleMeasure;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;

public class SimpleMeasureAnalyzer implements MeasureAnalyzer{


    private final static Logger logger = LoggerFactory.getLogger(SimpleMeasureAnalyzer.class);
    private SimpleMeasureAnalyzerConfig config;

    public SimpleMeasureAnalyzer(SimpleMeasureAnalyzerConfig config) {
        this.config = config;
    }

    /** @inheritDoc **/
    @Override
    public double analyze(MelodiaMeasure measure) {
        Map<Double, Integer> markWeightMap = new HashMap<>();

        // Analyze invervals' deviation
        ConfigValue<Double> isdConfig = config.INTERVAL_STANDARD_DEVIATION;
        if(isdConfig != null && isdConfig.getWeight() != null && isdConfig.getWeight().intValue() > 0) {
            markWeightMap.put(analyzeIntervals((SimpleMeasure) measure, isdConfig.getValue()), isdConfig.getWeight());
        } else {
            logger.warn("Interval standard deviation config not found. Omitted analysis.");
        }

        return markWeightMap.entrySet().stream().collect(averagingWeighted(Map.Entry::getKey, Map.Entry::getValue));
    }

    /**
     * Analyzes each interval of the measure, returning a normalized mark according to expectations.
     * @param measure measure to be analyzed
     * @param idealDeviation target value of standard deviation
     * @return mark between [0-1]
     */
    protected double analyzeIntervals(SimpleMeasure measure, Double idealDeviation) {

        double[] bounds = {0, measure.getInstrumento().getScopes()[0].getTesitura().getSemitonesDistance()};
        if(idealDeviation > bounds[1]) idealDeviation = bounds[1];

        // Calculate deviation
        StandardDeviation standardDeviation = new StandardDeviation();
        double deviationResult = standardDeviation.evaluate(measure.staff().getNotes().stream().mapToDouble(value -> value.getPitch().calculateSemitones()).toArray());

        // Normalize to [0-1]
        double deviationDifference = Math.abs(idealDeviation - deviationResult);
        double mark = (deviationDifference - bounds[0]) / (bounds[1] - bounds[0]);  // https://en.wikipedia.org/wiki/Feature_scaling#Rescaling_(min-max_normalization)
        mark = Math.pow(1 - mark, 2); // Invierto y elevo al cuadrado para valores más pronunciados

        return mark;
    }

    protected double analyzeHarmony(SimpleMeasure measure) {
        //TODO:
        return 1D;
    }

    private static <T> Collector<T,?,Double> averagingWeighted(ToDoubleFunction<T> valueFunction, ToIntFunction<T> weightFunction) {
        class Box {
            double num = 0;
            long denom = 0;
        }
        return Collector.of(
                Box::new,
                (b, e) -> {
                    b.num += valueFunction.applyAsDouble(e) * weightFunction.applyAsInt(e);
                    b.denom += weightFunction.applyAsInt(e);
                },
                (b1, b2) -> { b1.num += b2.num; b1.denom += b2.denom; return b1; },
                b -> b.num / b.denom
        );
    }

}
