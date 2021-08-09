package com.javi.uned.pfgcommons.model;

public class Distancia {

    private final int stepDistance;
    private final int semitoneDistance;

    public Distancia(int stepDistance, int semitoneDistance) {
        this.stepDistance = stepDistance;
        this.semitoneDistance = semitoneDistance;
    }

    public int getStepDistance() {
        return stepDistance;
    }

    public int getSemitoneDistance() {
        return semitoneDistance;
    }
}
