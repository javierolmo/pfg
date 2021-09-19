package com.javi.uned.pfgcomposergenetic.domain.composer.piano;

import com.javi.uned.pfgcommons.model.parts.PartComposite;
import com.javi.uned.pfgcommons.model.parts.PianoPart;
import com.javi.uned.pfgcommons.model.specs.GeneticSpecs;
import com.javi.uned.pfgcomposergenetic.domain.composer.Composer;

public class PianoComposer implements Composer {

    @Override
    public PartComposite compose(GeneticSpecs geneticSpecs) {
        PartComposite pianoPart = new PianoPart(geneticSpecs.getMeasures());
        pianoPart.getMeasures().clear();
        //TODO:
        return pianoPart;
    }
}
