package com.javi.uned.pfg.composer;

import com.javi.uned.pfg.composer.analyzers.SimpleMeasureAnalyzer;
import com.javi.uned.pfg.composer.analyzers.configs.SimpleMeasureAnalyzerConfig;
import com.javi.uned.pfg.jenetics.MeasureChromosome;
import com.javi.uned.pfg.jenetics.MeasureGene;
import com.javi.uned.pfg.model.specs.UserSpecs;
import com.javi.uned.pfg.model.constants.Instrumentos;
import com.javi.uned.pfg.model.parts.PartComposite;
import com.javi.uned.pfg.model.parts.ViolinPart;
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
    public PartComposite compose(UserSpecs userSpecs) {

        // Gene factory
        Factory<Genotype<MeasureGene>> measureGeneFactory = Genotype.of(MeasureChromosome.of(userSpecs.getMeasures(), Instrumentos.VIOLIN));

        // Engine
        Engine<MeasureGene, Double> engine = Engine.builder(genotype -> eval(genotype), measureGeneFactory).build();


        PartComposite violinPart = new ViolinPart(userSpecs.getMeasures());
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
