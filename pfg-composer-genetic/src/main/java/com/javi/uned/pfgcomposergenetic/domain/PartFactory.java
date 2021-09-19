package com.javi.uned.pfgcomposergenetic.domain;

import com.javi.uned.pfgcommons.model.Instrumento;
import com.javi.uned.pfgcommons.model.parts.PartComposite;
import com.javi.uned.pfgcommons.model.specs.GeneticSpecs;
import com.javi.uned.pfgcomposergenetic.domain.composer.Composer;

public class PartFactory {

    public PartComposite createPianoPart(GeneticSpecs geneticSpecs, Instrumento instrumento){
        Composer composer = Composer.getComposer(instrumento);
        return composer.compose(geneticSpecs);
    }
}
