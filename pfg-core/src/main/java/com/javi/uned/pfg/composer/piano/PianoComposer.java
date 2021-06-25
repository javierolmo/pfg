package com.javi.uned.pfg.composer.piano;

import com.javi.uned.pfg.composer.Composer;
import com.javi.uned.pfg.model.specs.UserSpecs;
import com.javi.uned.pfg.model.parts.PartComposite;
import com.javi.uned.pfg.model.parts.PianoPart;

public class PianoComposer implements Composer {

    @Override
    public PartComposite compose(UserSpecs userSpecs) {
        PartComposite pianoPart = new PianoPart(userSpecs.getMeasures());
        pianoPart.getMeasures().clear();
        //TODO:
        return pianoPart;
    }
}
