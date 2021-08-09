package com.javi.uned.pfgcommons.composer;

import com.javi.uned.pfgcommons.model.parts.PartComposite;
import com.javi.uned.pfgcommons.model.parts.SaxofonPart;
import com.javi.uned.pfgcommons.model.specs.GeneticSpecs;

public class SaxofonComposer implements Composer{

    @Override
    public PartComposite compose(GeneticSpecs geneticSpecs) {
        PartComposite partComposite = new SaxofonPart(geneticSpecs.getMeasures());
        partComposite.getMeasures().forEach(measureComposite -> measureComposite.randomize(geneticSpecs));
        return partComposite;
    }

}
