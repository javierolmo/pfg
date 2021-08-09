package com.javi.uned.pfgcommons.composer.piano;

import io.jenetics.Chromosome;
import io.jenetics.Genotype;
import io.jenetics.engine.Engine;
import io.jenetics.engine.EvolutionResult;
import org.junit.jupiter.api.Test;

class PhraseProblemTest {

    PhraseProblem phraseProblem = new PhraseProblem();
    Engine<PianoMeasureGene, Double> engine = Engine.builder(phraseProblem).build();
    @Test
    void hola() {
        Genotype<PianoMeasureGene> result = engine.stream().limit(1000).collect(EvolutionResult.toBestGenotype());
        Chromosome<PianoMeasureGene> chromosome = result.chromosome();
        System.out.println(chromosome);
    }

}