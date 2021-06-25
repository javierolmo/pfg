package com.javi.uned.pfg.composer;

import com.javi.uned.pfg.model.specs.UserSpecs;
import com.javi.uned.pfg.model.parts.PartComposite;
import com.javi.uned.pfg.model.parts.PianoPart;

public class DefaultComposer implements Composer{

    @Override
    public PartComposite compose(UserSpecs userSpecs) {
        PartComposite pianoPart = new PianoPart(userSpecs.getMeasures());
        pianoPart.getMeasures().forEach(measureComposite -> measureComposite.randomize(userSpecs));
        return pianoPart;
    }
}
