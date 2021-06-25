package com.javi.uned.pfg.model.measures;

import com.javi.uned.pfg.model.Instrumento;
import com.javi.uned.pfg.model.Staff;

public class SimpleMeasure extends MelodiaMeasure{

    public SimpleMeasure(Instrumento instrumento) {
        super(instrumento);
    }

    public Staff staff() {
        return this.getStaves()[0];
    }

}
