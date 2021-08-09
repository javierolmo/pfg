package com.javi.uned.pfgcommons.composer.piano;

import com.javi.uned.pfgcommons.composer.Composer;
import com.javi.uned.pfgcommons.model.parts.PartComposite;
import com.javi.uned.pfgcommons.model.parts.PianoPart;
import com.javi.uned.pfgcommons.model.specs.GeneticSpecs;

public class PianoComposer implements Composer {

    @Override
    public PartComposite compose(GeneticSpecs geneticSpecs) {
        PartComposite pianoPart = new PianoPart(geneticSpecs.getMeasures());
        pianoPart.getMeasures().clear();
        //TODO:
        return pianoPart;
    }
}
