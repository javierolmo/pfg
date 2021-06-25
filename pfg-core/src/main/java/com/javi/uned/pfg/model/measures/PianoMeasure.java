package com.javi.uned.pfg.model.measures;

import com.javi.uned.pfg.model.Staff;
import com.javi.uned.pfg.model.constants.Instrumentos;

public class PianoMeasure extends MelodiaMeasure{

    public PianoMeasure() {
        super(Instrumentos.PIANO);
    }

    public Staff rightHand() {
        return this.getStaves()[0];
    }

    public Staff leftHand() {
        return this.getStaves()[1];
    }
}
