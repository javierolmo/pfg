package com.javi.uned.pfgcommons.model.measures;

import com.javi.uned.pfgcommons.model.Instrumento;
import com.javi.uned.pfgcommons.model.Staff;

public class SimpleMeasure extends MelodiaMeasure{

    public SimpleMeasure(Instrumento instrumento) {
        super(instrumento);
    }

    public Staff staff() {
        return this.getStaves()[0];
    }

}
