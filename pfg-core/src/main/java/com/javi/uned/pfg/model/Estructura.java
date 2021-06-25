package com.javi.uned.pfg.model;

import com.javi.uned.pfg.model.specs.UserSpecs;

import java.util.HashMap;
import java.util.Map;

public class Estructura {

    private Map<Integer, Acorde> acordeMap;

    public Estructura(UserSpecs userSpecs){
        acordeMap = new HashMap<>(userSpecs.getMeasures());
    }

    public Acorde getAcorde(int index){
        return acordeMap.get(index);
    }
}
