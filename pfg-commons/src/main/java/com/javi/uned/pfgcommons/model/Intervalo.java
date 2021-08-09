package com.javi.uned.pfgcommons.model;

public class Intervalo {

    private final MelodiaAbsolutePitch pitch1;
    private final MelodiaAbsolutePitch pitch2;

    public Intervalo(MelodiaAbsolutePitch pitch1, MelodiaAbsolutePitch pitch2) {
        this.pitch1 = pitch1;
        this.pitch2 = pitch2;
    }

    public static Intervalo of(MelodiaAbsolutePitch pitch1, MelodiaAbsolutePitch pitch2){
        return new Intervalo(pitch1, pitch2);
    }

    public MelodiaAbsolutePitch getPitch1() {
        return pitch1;
    }

    public MelodiaAbsolutePitch getPitch2() {
        return pitch2;
    }

    public MelodiaAbsolutePitch getLower() {
        switch (pitch1.compareTo(pitch2)){
            case -1:
            case 0:
                return pitch1;
            case 1:
                return pitch2;
            default:
                throw new IllegalArgumentException("Error en NoteComposite.comparePitch()");
        }
    }

    public MelodiaAbsolutePitch getHigher() {
        switch (pitch1.compareTo(pitch2)){
            case -1:
            case 0:
                return pitch2;
            case 1:
                return pitch1;
            default:
                throw new IllegalArgumentException("Error en NoteComposite.comparePitch()");
        }
    }

    public boolean includes(MelodiaAbsolutePitch pitch3) {
        return pitch3.compareTo(pitch1) != pitch3.compareTo(pitch2);
    }

    @Override
    public String toString() {
        return "Intervalo{" +
                "note1=" + pitch1 +
                ", note2=" + pitch2 +
                '}';
    }
}
