package com.javi.uned.pfgcommons.domain.model.specs;

import com.javi.uned.pfgcommons.domain.model.Instrument;
import com.javi.uned.pfgcommons.domain.model.constants.Instruments;
import com.javi.uned.pfgcommons.domain.model.constants.Styles;

public class BoogieSpecs extends Specs {

    public BoogieSpecs() {
        super.setStyle(Styles.BOOGIE);
    }

    public static Instrument[] availableInstruments() {
        return new Instrument[]{Instruments.PIANO};
    }
}
