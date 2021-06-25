package com.javi.uned.pfg;

import com.javi.uned.pfg.model.Instrumento;
import com.javi.uned.pfg.model.MelodiaScore;
import com.javi.uned.pfg.model.specs.UserSpecs;
import com.javi.uned.pfg.model.parts.PartComposite;

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

    public MelodiaScore createScore(UserSpecs userSpecs){

        MelodiaScore melodiaScore = new MelodiaScore(userSpecs);
        for(Instrumento instrumento: userSpecs.getInstrumentos()){
            PartComposite partComposite = partFactory.createPianoPart(userSpecs, instrumento);
            melodiaScore.addPartComposite(partComposite);
        }

        return melodiaScore;
    }
}
