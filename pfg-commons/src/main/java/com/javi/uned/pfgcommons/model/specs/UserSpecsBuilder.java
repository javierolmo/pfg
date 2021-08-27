package com.javi.uned.pfgcommons.model.specs;

import com.javi.uned.pfgcommons.model.Compas;
import com.javi.uned.pfgcommons.model.Figura;
import com.javi.uned.pfgcommons.model.Instrumento;
import com.javi.uned.pfgcommons.model.Tonalidad;
import com.javi.uned.pfgcommons.model.constants.Compases;
import com.javi.uned.pfgcommons.model.constants.Figuras;
import com.javi.uned.pfgcommons.model.constants.Instrumentos;
import com.javi.uned.pfgcommons.model.constants.Tonalidades;

import java.util.Arrays;

public class UserSpecsBuilder {

    private final GeneticSpecs geneticSpecs;

    private UserSpecsBuilder() {
        this.geneticSpecs = new GeneticSpecs();
        this.geneticSpecs.setCompas(Compases.COMPAS_4x4);
        this.geneticSpecs.setMaxFigura(Figuras.BLANCA);
        this.geneticSpecs.setMinFigura(Figuras.SEMICORCHEA);
        this.geneticSpecs.setTonalidad(Tonalidades.DO_M);
        this.geneticSpecs.setMeasures(80);
        this.geneticSpecs.setInstrumentos(new Instrumento[]{Instrumentos.PIANO});
        this.geneticSpecs.setAuthors(new String[]{"Melodía"});
        this.geneticSpecs.setPhraseLength(8);
        this.geneticSpecs.setMovementTitle("Melodía default title");
        this.geneticSpecs.setMovementNumber("1");
    }

    public static UserSpecsBuilder initDefault() {
        return new UserSpecsBuilder();
    }

    public UserSpecsBuilder compas(Compas compas) {
        this.geneticSpecs.setCompas(compas);
        return this;
    }

    public UserSpecsBuilder maxFigura(Figura figura) {
        this.geneticSpecs.setMaxFigura(figura);
        return this;
    }

    public UserSpecsBuilder minFigura(Figura figura) {
        this.geneticSpecs.setMinFigura(figura);
        return this;
    }

    public UserSpecsBuilder tonalidad(Tonalidad tonalidad) {
        this.geneticSpecs.setTonalidad(tonalidad);
        return this;
    }

    public UserSpecsBuilder measures(int measures) {
        this.geneticSpecs.setMeasures(measures);
        return this;
    }

    public UserSpecsBuilder instruments(Instrumento...instrumentos) {
        this.geneticSpecs.setInstrumentos(instrumentos);
        return this;
    }

    public UserSpecsBuilder authors(String...authors) {
        this.geneticSpecs.setAuthors(authors);
        return this;
    }

    public UserSpecsBuilder phraseLength(int phraseLength) {
        this.geneticSpecs.setPhraseLength(phraseLength);
        return this;
    }

    public UserSpecsBuilder movementTitle(String movementTitle) {
        this.geneticSpecs.setMovementTitle(movementTitle);
        return this;
    }

    public UserSpecsBuilder movementNumber(String movementNumber) {
        this.geneticSpecs.setMovementNumber(movementNumber);
        return this;
    }

    public GeneticSpecs build() {
        return this.geneticSpecs;
    }
}
