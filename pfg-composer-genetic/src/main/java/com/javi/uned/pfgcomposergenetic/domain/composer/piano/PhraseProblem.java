package com.javi.uned.pfgcomposergenetic.domain.composer.piano;

import com.javi.uned.pfgcommons.model.constants.Instrumentos;
import io.jenetics.Genotype;
import io.jenetics.engine.Codec;
import io.jenetics.engine.Problem;
import io.jenetics.util.ISeq;

import java.util.Random;
import java.util.function.Function;

public class PhraseProblem implements Problem<ISeq<PianoMeasureGene>, PianoMeasureGene, Double> {

    @Override
    public Function<ISeq<PianoMeasureGene>, Double> fitness() {
        return measureGenes -> new Random().nextDouble();
    }

    @Override
    public Codec<ISeq<PianoMeasureGene>, PianoMeasureGene> codec() {
        return Codec.of(
                Genotype.of(PianoMeasureChromosome.of(8, Instrumentos.PIANO)),
                gt -> ISeq.of(gt.chromosome())
        );
    }
}
