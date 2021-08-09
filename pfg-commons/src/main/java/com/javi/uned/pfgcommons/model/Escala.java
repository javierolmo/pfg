package com.javi.uned.pfgcommons.model;

public class Escala {

    private final Distancia[] distances;

    public Escala (Distancia...distances) {
        this.distances = distances;
    }

    public MelodiaRelativePitch[] of(MelodiaRelativePitch pitch) {
        MelodiaRelativePitch[] result = new MelodiaRelativePitch[distances.length];
        result[0] = pitch;
        for(int i=1; i<distances.length; i++) {
            result[i] = result[i-1].intervalo(distances[i-1], true);
        }
        return result;
    }

    public Distancia[] getDistances() {
        return distances;
    }
}
