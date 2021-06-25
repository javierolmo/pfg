package com.javi.uned.pfg.model.measures;

import com.javi.uned.pfg.model.Instrumento;
import com.javi.uned.pfg.model.specs.UserSpecs;
import com.javi.uned.pfg.model.constants.Instrumentos;
import com.javi.uned.pfg.model.specs.UserSpecsBuilder;

public class MeasureFactory {

    private static final UserSpecs defaultSpecs = UserSpecsBuilder.initDefault().build();

    public static MelodiaMeasure createEmptyMeasure(Instrumento instrumento) {
        if(instrumento.equals(Instrumentos.PIANO)){
            return new PianoMeasure();
        } else {
            return new SimpleMeasure(instrumento);
        }
    }

    public static MelodiaMeasure createRandomMeasure(Instrumento instrumento, UserSpecs userSpecs) {
        MelodiaMeasure melodiaMeasure = MeasureFactory.createEmptyMeasure(instrumento);
        melodiaMeasure.randomize(userSpecs);
        return melodiaMeasure;
    }

    public static MelodiaMeasure createRandomMeasure(Instrumento instrumento) {
        MelodiaMeasure melodiaMeasure = MeasureFactory.createEmptyMeasure(instrumento);
        melodiaMeasure.randomize(defaultSpecs);
        return melodiaMeasure;
    }
}
