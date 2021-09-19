package com.javi.uned.pfgcomposergenetic.domain.composer;

import com.javi.uned.pfgcommons.model.Instrumento;
import com.javi.uned.pfgcommons.model.constants.Instrumentos;
import com.javi.uned.pfgcommons.model.parts.PartComposite;
import com.javi.uned.pfgcommons.model.specs.GeneticSpecs;
import com.javi.uned.pfgcomposergenetic.domain.composer.piano.PianoComposer;


public interface Composer {

    PartComposite compose(GeneticSpecs geneticSpecs);

    static Composer getComposer(Instrumento instrumento){
        if(instrumento.equals(Instrumentos.PIANO)) return new PianoComposer();
        else if(instrumento.equals(Instrumentos.VIOLIN)) return new ViolinComposer();
        else if(instrumento.equals(Instrumentos.SAXOFON_TENOR)) return new SaxofonComposer();
        else return new DefaultComposer();
    }

}
