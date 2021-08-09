package com.javi.uned.pfgcommons.composer;

import com.javi.uned.pfgcommons.composer.piano.PianoComposer;
import com.javi.uned.pfgcommons.model.Instrumento;
import com.javi.uned.pfgcommons.model.constants.Instrumentos;
import com.javi.uned.pfgcommons.model.parts.PartComposite;
import com.javi.uned.pfgcommons.model.specs.GeneticSpecs;


public interface Composer {

    PartComposite compose(GeneticSpecs geneticSpecs);

    static Composer getComposer(Instrumento instrumento){
        if(instrumento.equals(Instrumentos.PIANO)) return new PianoComposer();
        else if(instrumento.equals(Instrumentos.VIOLIN)) return new ViolinComposer();
        else if(instrumento.equals(Instrumentos.SAXOFON_TENOR)) return new SaxofonComposer();
        else return new DefaultComposer();
    }

}
