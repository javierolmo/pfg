package com.javi.uned.pfgcomposergenetic.domain;

import com.javi.uned.pfgcommons.model.Instrumento;
import com.javi.uned.pfgcommons.model.MelodiaScore;
import com.javi.uned.pfgcommons.model.parts.PartComposite;
import com.javi.uned.pfgcommons.model.specs.GeneticSpecs;

public class ScoreFactory {

    private static ScoreFactory scoreFactory;

    private PartFactory partFactory;

    private ScoreFactory(){
        this.partFactory = new PartFactory();
    }

    public static ScoreFactory getInstance(){
        if(scoreFactory == null){
            scoreFactory = new ScoreFactory();
        }
        return scoreFactory;
    }

    public MelodiaScore createScore(GeneticSpecs geneticSpecs){

        MelodiaScore melodiaScore = new MelodiaScore(geneticSpecs);
        for(Instrumento instrumento: geneticSpecs.getInstrumentos()){
            PartComposite partComposite = partFactory.createPianoPart(geneticSpecs, instrumento);
            melodiaScore.addPartComposite(partComposite);
        }

        return melodiaScore;
    }
}
