package com.javi.uned.pfgcommons.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javi.uned.pfgcommons.model.constants.Escalas;

import java.util.Objects;

public class Tonalidad {

    private final long id;
    private final MelodiaRelativePitch pitch;
    private final boolean mayor;

    public Tonalidad(long id, MelodiaRelativePitch melodiaRelativePitch, boolean mayor) {
        this.id = id;
        this.mayor = mayor;
        this.pitch = melodiaRelativePitch;
    }

    public short getAlteraciones() {
        short alteraciones = 0;
        for (MelodiaRelativePitch melodiaRelativePitch : getScale()) {
            alteraciones += melodiaRelativePitch.getAlter();
        }
        return alteraciones;
    }

    public MelodiaRelativePitch getPitch() {
        return pitch;
    }

    public long getId() {
        return id;
    }

    public String getAmericanName() {
        return String.format("%s %s %s", pitch.getStep().getName(), pitch.getAlterSymbol(), mayor? "Major": "minor");
    }

    public String getTraditionalName() {
        return String.format("%s %s %s", pitch.getStep().getTraditionalName(), pitch.getAlterSymbol(), mayor? "Mayor": "menor");
    }

    public boolean isMayor() {
        return mayor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tonalidad tonalidad = (Tonalidad) o;
        return mayor == tonalidad.mayor && Objects.equals(pitch, tonalidad.pitch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pitch, mayor);
    }

    @JsonIgnore
    public MelodiaRelativePitch[] getScale() {
        Escala escala = mayor? Escalas.MAYOR : Escalas.MENOR;
        return escala.of(pitch);
    }

}
