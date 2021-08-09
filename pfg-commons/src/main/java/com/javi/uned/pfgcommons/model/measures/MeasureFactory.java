package com.javi.uned.pfgcommons.model.measures;

import com.javi.uned.pfgcommons.model.Instrumento;
import com.javi.uned.pfgcommons.model.constants.Instrumentos;
import com.javi.uned.pfgcommons.model.specs.GeneticSpecs;
import com.javi.uned.pfgcommons.model.specs.UserSpecsBuilder;

public class MeasureFactory {

    private static final GeneticSpecs defaultSpecs = UserSpecsBuilder.initDefault().build();

    public static MelodiaMeasure createEmptyMeasure(Instrumento instrumento) {
        if(instrumento.equals(Instrumentos.PIANO)){
            return new PianoMeasure();
        } else {
            return new SimpleMeasure(instrumento);
        }
    }

    public static MelodiaMeasure createRandomMeasure(Instrumento instrumento, GeneticSpecs geneticSpecs) {
        MelodiaMeasure melodiaMeasure = MeasureFactory.createEmptyMeasure(instrumento);
        melodiaMeasure.randomize(geneticSpecs);
        return melodiaMeasure;
    }

    public static MelodiaMeasure createRandomMeasure(Instrumento instrumento) {
        MelodiaMeasure melodiaMeasure = MeasureFactory.createEmptyMeasure(instrumento);
        melodiaMeasure.randomize(defaultSpecs);
        return melodiaMeasure;
    }
}
