package com.javi.uned.pfgcomposergenetic.domain.composer.piano;

import com.javi.uned.pfgcomposergenetic.domain.composer.MeasureEvaluator;
import io.jenetics.Chromosome;
import io.jenetics.Genotype;

public class PianoMeasureEvaluator implements MeasureEvaluator<PianoMeasureGene> {


    @Override
    public Double evaluate(Genotype<PianoMeasureGene> genotype) {
        double result = 0;
        for (Chromosome<PianoMeasureGene> chromosome : genotype) {
            for (PianoMeasureGene gene : chromosome) {
                result -= gene.intervalsRightHandMeanDeviation();
            }
        }
        return result;
    }
}
