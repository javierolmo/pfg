package com.javi.uned.pfg.composer.piano;

import com.javi.uned.pfg.model.Instrumento;
import io.jenetics.Chromosome;
import io.jenetics.util.ISeq;

public class PianoMeasureChromosome implements Chromosome<PianoMeasureGene> {

    private PianoMeasureGene[] measures;
    private Instrumento instrumento;

    public PianoMeasureGene[] getMeasures() {
        return measures;
    }

    private PianoMeasureChromosome(int length, Instrumento instrumento) {
        measures = new PianoMeasureGene[length];
        this.instrumento = instrumento;
    }

    @Override
    public PianoMeasureGene getGene(int index) {
        return measures[index];
    }

    @Override
    public Chromosome<PianoMeasureGene> newInstance(ISeq<PianoMeasureGene> genes) {
        PianoMeasureChromosome pianoMeasureChromosome = new PianoMeasureChromosome(genes.length(), instrumento);
        pianoMeasureChromosome.measures = genes.toArray(PianoMeasureGene[]::new);
        return pianoMeasureChromosome;
    }

    @Override
    public ISeq<PianoMeasureGene> toSeq() {
        return ISeq.of(measures);
    }

    @Override
    public int length() {
        return this.measures.length;
    }

    @Override
    public Chromosome<PianoMeasureGene> newInstance() {
        return of(measures.length, instrumento);
    }

    @Override
    public boolean isValid() {
        return true;
    }

    public static PianoMeasureChromosome of(int length, Instrumento instrumento) {
        PianoMeasureChromosome pianoMeasureChromosome = new PianoMeasureChromosome(length, instrumento);
        for (int i = 0; i < pianoMeasureChromosome.measures.length; i++) {
            pianoMeasureChromosome.measures[i] = PianoMeasureGene.of();
        }
        return pianoMeasureChromosome;
    }
}
