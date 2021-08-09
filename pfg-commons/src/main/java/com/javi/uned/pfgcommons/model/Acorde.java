package com.javi.uned.pfgcommons.model;

public class Acorde {

    private Distancia[] distances;

    public Acorde (Distancia...distances) {
        this.distances = distances;
    }

    public MelodiaRelativePitch[] of(MelodiaRelativePitch pitch) {
        MelodiaRelativePitch[] result = new MelodiaRelativePitch[distances.length + 1];
        for(int i=0; i< distances.length; i++) {
            result[i] = pitch.intervalo(distances[i], true);
        }
        return result;
    }
}
