package com.javi.uned.pfgcommons.model;

import java.util.Objects;

public class MelodiaAbsolutePitch implements MelodiaPitch, Comparable<MelodiaAbsolutePitch>{

    private final int octave;
    private final MelodiaStep step;
    private final int alter;

    public MelodiaAbsolutePitch(int octave, MelodiaStep step, int alter) {
        this.octave = octave;
        this.step = step;
        this.alter = alter;
    }

    public int getOctave() {
        return octave;
    }

    @Override
    public MelodiaStep getStep() {
        return step;
    }

    @Override
    public int getAlter() {
        return alter;
    }

    public int calculateSemitones() {
        return this.octave * 12 + step.getSemitones() + alter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MelodiaAbsolutePitch that = (MelodiaAbsolutePitch) o;
        return octave == that.octave && alter == that.alter && Objects.equals(step, that.step);
    }

    @Override
    public int hashCode() {
        return Objects.hash(octave, step, alter);
    }

    @Override
    public int compareTo(MelodiaAbsolutePitch o) {
        return Integer.compare(calculateSemitones(), o.calculateSemitones());
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("MelodiaPitch{ ")
                .append(step.getName())
                .append(octave)
                .append(alter == 1? " #" : alter == -1? " b" : "")
                .append(" }")
                .toString();
    }
}
