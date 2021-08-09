package com.javi.uned.pfgcommons.model;

import com.javi.uned.pfgcommons.model.specs.GeneticSpecs;

import java.util.HashMap;
import java.util.Map;

public class Estructura {

    private Map<Integer, Acorde> acordeMap;

    public Estructura(GeneticSpecs geneticSpecs){
        acordeMap = new HashMap<>(geneticSpecs.getMeasures());
    }

    public Acorde getAcorde(int index){
        return acordeMap.get(index);
    }
}
