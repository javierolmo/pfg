package com.javi.uned.pfg.composer;

import com.javi.uned.pfg.model.specs.UserSpecs;
import com.javi.uned.pfg.model.parts.PartComposite;
import com.javi.uned.pfg.model.parts.SaxofonPart;

public class SaxofonComposer implements Composer{

    @Override
    public PartComposite compose(UserSpecs userSpecs) {
        PartComposite partComposite = new SaxofonPart(userSpecs.getMeasures());
        partComposite.getMeasures().forEach(measureComposite -> measureComposite.randomize(userSpecs));
        return partComposite;
    }

}
