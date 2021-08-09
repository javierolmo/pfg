package com.javi.uned.pfgcommons.composer;

import com.javi.uned.pfgcommons.composer.analyzers.SimpleMeasureAnalyzer;
import com.javi.uned.pfgcommons.composer.analyzers.configs.SimpleMeasureAnalyzerConfig;
import com.javi.uned.pfgcommons.jenetics.MeasureChromosome;
import com.javi.uned.pfgcommons.jenetics.MeasureGene;
import com.javi.uned.pfgcommons.model.constants.Instrumentos;
import com.javi.uned.pfgcommons.model.parts.PartComposite;
import com.javi.uned.pfgcommons.model.parts.ViolinPart;
import com.javi.uned.pfgcommons.model.specs.GeneticSpecs;
import io.jenetics.Genotype;
import io.jenetics.engine.Engine;
import io.jenetics.engine.EvolutionResult;
import io.jenetics.util.Factory;

import java.util.concurrent.atomic.AtomicReference;

public class ViolinComposer implements Composer{

    private SimpleMeasureAnalyzer measureAnalyzer;

    public ViolinComposer () {
        this.measureAnalyzer = new SimpleMeasureAnalyzer(new SimpleMeasureAnalyzerConfig());
    }

    @Override
    public PartComposite compose(GeneticSpecs geneticSpecs) {

        // Gene factory
        Factory<Genotype<MeasureGene>> measureGeneFactory = Genotype.of(MeasureChromosome.of(geneticSpecs.getMeasures(), Instrumentos.VIOLIN));

        // Engine
        Engine<MeasureGene, Double> engine = Engine.builder(genotype -> eval(genotype), measureGeneFactory).build();


        PartComposite violinPart = new ViolinPart(geneticSpecs.getMeasures());
        Genotype<MeasureGene> result = engine.stream().limit(5000).collect(EvolutionResult.toBestGenotype());
        violinPart.getMeasures().clear();
        for (MeasureGene measureGene : result.chromosome()) {
            violinPart.getMeasures().add(measureGene.getAllele());
        }
        return violinPart;
    }

    private Double eval(Genotype<MeasureGene> genotype) {
        AtomicReference<Double> mark = new AtomicReference<>((double) 0);
        genotype.forEach(measureGenes -> {
            measureGenes.forEach(measureGene -> {
                mark.updateAndGet(v -> new Double((double) (v + this.measureAnalyzer.analyze(measureGene.getAllele()))));
            });
        });
        return mark.get();
    }
}
