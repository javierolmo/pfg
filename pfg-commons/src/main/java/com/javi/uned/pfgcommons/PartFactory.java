package com.javi.uned.pfgcommons;

import com.javi.uned.pfgcommons.composer.Composer;
import com.javi.uned.pfgcommons.model.Instrumento;
import com.javi.uned.pfgcommons.model.parts.PartComposite;
import com.javi.uned.pfgcommons.model.specs.GeneticSpecs;

public class PartFactory {

    public PartComposite createPianoPart(GeneticSpecs geneticSpecs, Instrumento instrumento){
        Composer composer = Composer.getComposer(instrumento);
        return composer.compose(geneticSpecs);
    }
}
