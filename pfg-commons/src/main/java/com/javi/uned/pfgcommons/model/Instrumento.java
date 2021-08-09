package com.javi.uned.pfgcommons.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.audiveris.proxymusic.ScoreInstrument;

import java.util.Arrays;
import java.util.Objects;

public class Instrumento {

    private String ref;
    private String code;
    private String name;
    private String ensemble;
    private String abbreviation;
    private String sound;
    private Scope[] scopes;

    public Instrumento(){

    }

    public Instrumento(String ref, String code, String name, String ensemble, String abbreviation, String sound, Scope... scopes) {
        this.ref = ref;
        this.code = code;
        this.name = name;
        this.ensemble = ensemble;
        this.abbreviation = abbreviation;
        this.sound = sound;
        this.scopes = scopes;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnsemble() {
        return ensemble;
    }

    public void setEnsemble(String ensemble) {
        this.ensemble = ensemble;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public Scope[] getScopes() {
        return scopes;
    }

    public void setScopes(Scope[] scopes) {
        this.scopes = scopes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instrumento that = (Instrumento) o;
        return Objects.equals(ref, that.ref) && Objects.equals(code, that.code) && Objects.equals(name, that.name) && Objects.equals(ensemble, that.ensemble) && Objects.equals(abbreviation, that.abbreviation) && Objects.equals(sound, that.sound) && Arrays.equals(scopes, that.scopes);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(ref, code, name, ensemble, abbreviation, sound);
        result = 31 * result + Arrays.hashCode(scopes);
        return result;
    }

    @JsonIgnore
    public ScoreInstrument toScoreInstrument(){
        ScoreInstrument scoreInstrument = new ScoreInstrument();
        scoreInstrument.setId(code);
        scoreInstrument.setInstrumentName(name);
        scoreInstrument.setEnsemble(ensemble);
        scoreInstrument.setInstrumentAbbreviation(abbreviation);
        scoreInstrument.setInstrumentSound(sound);
        return scoreInstrument;
    }

}
