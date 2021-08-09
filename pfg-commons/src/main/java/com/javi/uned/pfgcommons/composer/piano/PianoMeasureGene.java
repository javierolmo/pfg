package com.javi.uned.pfgcommons.composer.piano;

import com.javi.uned.pfgcommons.model.constants.Instrumentos;
import com.javi.uned.pfgcommons.model.measures.MeasureFactory;
import com.javi.uned.pfgcommons.model.measures.PianoMeasure;
import io.jenetics.Gene;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

public class PianoMeasureGene implements Gene<PianoMeasure, PianoMeasureGene>{

    private PianoMeasure pianoMeasure;

    public PianoMeasureGene(PianoMeasure pianoMeasure) {
        this.pianoMeasure = pianoMeasure;
    }


    @Override
    public PianoMeasure getAllele() {
        return this.pianoMeasure;
    }

    @Override
    public PianoMeasureGene newInstance() {
        PianoMeasure newMeasure = (PianoMeasure) MeasureFactory.createRandomMeasure(Instrumentos.PIANO);
        return new PianoMeasureGene(newMeasure);
    }

    @Override
    public PianoMeasureGene newInstance(PianoMeasure value) {
        return new PianoMeasureGene(value);
    }

    @Override
    public boolean isValid() {
        return true;
    }

    public static PianoMeasureGene of() {
        PianoMeasure newMeasure = (PianoMeasure) MeasureFactory.createRandomMeasure(Instrumentos.PIANO);
        return new PianoMeasureGene(newMeasure);
    }

    public double intervalsRightHandMeanDeviation() {
        StandardDeviation standardDeviation = new StandardDeviation();
        double[] notesSemitones = this.pianoMeasure.rightHand().getNotes().stream()
                .mapToDouble(value -> value.getPitch().calculateSemitones())
                .toArray();
        return standardDeviation.evaluate(notesSemitones);
    }

    public double intervalsLeftHandMeanDeviation() {
        StandardDeviation standardDeviation = new StandardDeviation();
        double[] notesSemitones = this.pianoMeasure.leftHand().getNotes().stream()
                .mapToDouble(value -> value.getPitch().calculateSemitones())
                .toArray();
        return standardDeviation.evaluate(notesSemitones);
    }

}
