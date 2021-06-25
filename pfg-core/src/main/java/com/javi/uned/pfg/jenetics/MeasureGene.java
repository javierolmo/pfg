package com.javi.uned.pfg.jenetics;

import com.javi.uned.pfg.model.Instrumento;
import com.javi.uned.pfg.model.measures.MeasureFactory;
import com.javi.uned.pfg.model.measures.MelodiaMeasure;
import com.javi.uned.pfg.model.Staff;
import io.jenetics.Gene;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

public class MeasureGene implements Gene<MelodiaMeasure, MeasureGene>{

    private MelodiaMeasure melodiaMeasure;
    private Instrumento instrumento;

    public MeasureGene(MelodiaMeasure melodiaMeasure, Instrumento instrumento) {
        this.melodiaMeasure = melodiaMeasure;
        this.instrumento = instrumento;
    }


    @Override
    public MelodiaMeasure getAllele() {
        return this.melodiaMeasure;
    }

    @Override
    public MeasureGene newInstance() {
        return new MeasureGene(MeasureFactory.createRandomMeasure(instrumento), instrumento);
    }

    @Override
    public MeasureGene newInstance(MelodiaMeasure value) {
        return new MeasureGene(value, instrumento);
    }

    @Override
    public boolean isValid() {
        return true;
    }

    public static MeasureGene of(Instrumento instrumento) {
        return new MeasureGene(MeasureFactory.createRandomMeasure(instrumento), instrumento);
    }

    public double intervalsMeanDeviation() {
        double result = 0;
        for (Staff staff : this.melodiaMeasure.getStaves()) {
            StandardDeviation standardDeviation = new StandardDeviation();
            result += standardDeviation.evaluate(
                    staff.getNotes().stream().mapToDouble(value -> value.getPitch().calculateSemitones()).toArray()
            );
        }
        return result / this.melodiaMeasure.getStaves().length;
    }

}
