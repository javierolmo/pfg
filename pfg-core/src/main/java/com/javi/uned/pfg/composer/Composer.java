package com.javi.uned.pfg.composer;

import com.javi.uned.pfg.composer.piano.PianoComposer;
import com.javi.uned.pfg.model.Instrumento;
import com.javi.uned.pfg.model.specs.UserSpecs;
import com.javi.uned.pfg.model.constants.Instrumentos;
import com.javi.uned.pfg.model.parts.PartComposite;


public interface Composer {

    PartComposite compose(UserSpecs userSpecs);

    static Composer getComposer(Instrumento instrumento){
        if(instrumento.equals(Instrumentos.PIANO)) return new PianoComposer();
        else if(instrumento.equals(Instrumentos.VIOLIN)) return new ViolinComposer();
        else if(instrumento.equals(Instrumentos.SAXOFON_TENOR)) return new SaxofonComposer();
        else return new DefaultComposer();
    }

}
