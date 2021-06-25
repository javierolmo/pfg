package com.javi.uned.pfg.jenetics;

import com.javi.uned.pfg.model.Instrumento;
import io.jenetics.Chromosome;
import io.jenetics.util.ISeq;

public class MeasureChromosome implements Chromosome<MeasureGene> {

    private MeasureGene[] measures;
    private Instrumento instrumento;

    public MeasureGene[] getMeasures() {
        return measures;
    }

    private MeasureChromosome(int length, Instrumento instrumento) {
        measures = new MeasureGene[length];
        this.instrumento = instrumento;
    }

    @Override
    public MeasureGene getGene(int index) {
        return measures[index];
    }

    @Override
    public Chromosome<MeasureGene> newInstance(ISeq<MeasureGene> genes) {
        MeasureChromosome measureChromosome = new MeasureChromosome(genes.length(), instrumento);
        measureChromosome.measures = genes.toArray(MeasureGene[]::new);
        return measureChromosome;
    }

    @Override
    public ISeq<MeasureGene> toSeq() {
        return ISeq.of(measures);
    }

    @Override
    public int length() {
        return this.measures.length;
    }

    @Override
    public Chromosome<MeasureGene> newInstance() {
        return of(measures.length, instrumento);
    }

    @Override
    public boolean isValid() {
        return true;
    }

    public static MeasureChromosome of(int length, Instrumento instrumento) {
        MeasureChromosome measureChromosome = new MeasureChromosome(length, instrumento);
        for (int i = 0; i < measureChromosome.measures.length; i++) {
            measureChromosome.measures[i] = MeasureGene.of(instrumento);
        }
        return measureChromosome;
    }
}
