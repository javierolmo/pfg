package com.javi.uned.pfgcommons.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class Tesitura {

    private final MelodiaAbsolutePitch pitch1;
    private final MelodiaAbsolutePitch pitch2;

    public Tesitura(MelodiaAbsolutePitch pitch1, MelodiaAbsolutePitch pitch2) {
        this.pitch1 = pitch1;
        this.pitch2 = pitch2;
    }

    public MelodiaAbsolutePitch getPitch1() {
        return pitch1;
    }

    public MelodiaAbsolutePitch getPitch2() {
        return pitch2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tesitura tesitura = (Tesitura) o;
        return Objects.equals(pitch1, tesitura.pitch1) &&
                Objects.equals(pitch2, tesitura.pitch2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pitch1, pitch2);
    }

    @JsonIgnore
    public Intervalo getIntervalo(){
        return new Intervalo(pitch1, pitch2);
    }

    @JsonIgnore
    public int getSemitonesDistance() {
        return Math.abs(pitch1.calculateSemitones() - pitch2.calculateSemitones());
    }
}
