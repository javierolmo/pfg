package com.javi.uned.pfg.model.specs;

import com.javi.uned.pfg.model.*;
import com.javi.uned.pfg.model.constants.Compases;
import com.javi.uned.pfg.model.constants.Figuras;
import com.javi.uned.pfg.model.constants.Instrumentos;
import com.javi.uned.pfg.model.constants.Tonalidades;

import java.util.Arrays;

public class UserSpecsBuilder {

    private final UserSpecs userSpecs;

    private UserSpecsBuilder() {
        this.userSpecs = new UserSpecs();
        this.userSpecs.setCompas(Compases.COMPAS_4x4);
        this.userSpecs.setMaxFigura(Figuras.BLANCA);
        this.userSpecs.setMinFigura(Figuras.SEMICORCHEA);
        this.userSpecs.setTonalidad(Tonalidades.DO_M);
        this.userSpecs.setMeasures(80);
        this.userSpecs.setInstrumentos(new Instrumento[]{Instrumentos.PIANO});
        this.userSpecs.setAuthors(Arrays.asList("Melodía"));
        this.userSpecs.setPhraseLenght(8);
        this.userSpecs.setMovementTitle("Melodía default title");
        this.userSpecs.setMovementNumber("1");
    }

    public static UserSpecsBuilder initDefault() {
        return new UserSpecsBuilder();
    }

    public UserSpecsBuilder compas(Compas compas) {
        this.userSpecs.setCompas(compas);
        return this;
    }

    public UserSpecsBuilder maxFigura(Figura figura) {
        this.userSpecs.setMaxFigura(figura);
        return this;
    }

    public UserSpecsBuilder minFigura(Figura figura) {
        this.userSpecs.setMinFigura(figura);
        return this;
    }

    public UserSpecsBuilder tonalidad(Tonalidad tonalidad) {
        this.userSpecs.setTonalidad(tonalidad);
        return this;
    }

    public UserSpecsBuilder measures(int measures) {
        this.userSpecs.setMeasures(measures);
        return this;
    }

    public UserSpecsBuilder instruments(Instrumento...instrumentos) {
        this.userSpecs.setInstrumentos(instrumentos);
        return this;
    }

    public UserSpecsBuilder authors(String...authors) {
        this.userSpecs.setAuthors(Arrays.asList(authors));
        return this;
    }

    public UserSpecsBuilder phraseLength(int phraseLength) {
        this.userSpecs.setPhraseLenght(phraseLength);
        return this;
    }

    public UserSpecsBuilder movementTitle(String movementTitle) {
        this.userSpecs.setMovementTitle(movementTitle);
        return this;
    }

    public UserSpecsBuilder movementNumber(String movementNumber) {
        this.userSpecs.setMovementNumber(movementNumber);
        return this;
    }

    public UserSpecs build() {
        return this.userSpecs;
    }
}
