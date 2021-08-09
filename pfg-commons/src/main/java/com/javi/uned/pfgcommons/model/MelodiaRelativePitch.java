package com.javi.uned.pfgcommons.model;

import java.util.Objects;

public class MelodiaRelativePitch implements MelodiaPitch{

    private final MelodiaStep step;
    private final int alter;

    public MelodiaRelativePitch(MelodiaStep step, int alter) {
        this.step = step;
        this.alter = alter;
    }

    @Override
    public MelodiaStep getStep() {
        return step;
    }

    @Override
    public int getAlter() {
        return alter;
    }

    public MelodiaRelativePitch intervalo(Distancia distancia, boolean ascendente) {
        MelodiaStep resultStep = step.interval(distancia.getStepDistance(), ascendente);
        MelodiaRelativePitch candidate = new MelodiaRelativePitch(resultStep, 0);
        int currentSemitoneDistance = this.semitoneDistance(candidate, ascendente);
        if(currentSemitoneDistance == distancia.getSemitoneDistance()){
            return candidate;
        } else {
            return new MelodiaRelativePitch(resultStep, distancia.getSemitoneDistance() - currentSemitoneDistance);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MelodiaRelativePitch that = (MelodiaRelativePitch) o;
        return alter == that.alter && Objects.equals(step, that.step);
    }

    @Override
    public int hashCode() {
        return Objects.hash(step, alter);
    }

    public int calculateSemitones() {
        return step.getSemitones() + alter;
    }

    public int semitoneDistance(MelodiaRelativePitch pitch, boolean ascendent) {

        int semitones1 = this.calculateSemitones();
        int semitones2 = pitch.calculateSemitones();

        if(ascendent) {
            while (semitones2 < semitones1) semitones2 += 12;
            return semitones2 - semitones1;
        } else {
            while (semitones1 < semitones2) semitones1 += 12;
            return semitones1 - semitones2;
        }
    }

    @Override
    public String toString() {
        return step.getName() + getAlterSymbol();
    }
}
