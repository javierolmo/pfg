package com.javi.uned.pfg;

import com.javi.uned.pfg.composer.Composer;
import com.javi.uned.pfg.model.Instrumento;
import com.javi.uned.pfg.model.specs.UserSpecs;
import com.javi.uned.pfg.model.parts.PartComposite;

public class PartFactory {

    public PartComposite createPianoPart(UserSpecs userSpecs, Instrumento instrumento){
        Composer composer = Composer.getComposer(instrumento);
        return composer.compose(userSpecs);
    }
}
