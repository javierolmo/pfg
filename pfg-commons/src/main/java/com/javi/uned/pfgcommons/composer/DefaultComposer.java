package com.javi.uned.pfgcommons.composer;

import com.javi.uned.pfgcommons.model.parts.PartComposite;
import com.javi.uned.pfgcommons.model.parts.PianoPart;
import com.javi.uned.pfgcommons.model.specs.GeneticSpecs;

public class DefaultComposer implements Composer{

    @Override
    public PartComposite compose(GeneticSpecs geneticSpecs) {
        PartComposite pianoPart = new PianoPart(geneticSpecs.getMeasures());
        pianoPart.getMeasures().forEach(measureComposite -> measureComposite.randomize(geneticSpecs));
        return pianoPart;
    }
}
