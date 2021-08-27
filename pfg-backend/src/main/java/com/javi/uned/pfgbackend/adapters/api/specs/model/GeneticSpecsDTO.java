package com.javi.uned.pfgbackend.adapters.api.specs.model;

import com.javi.uned.pfgbackend.adapters.api.tonalities.model.TonalityDTO;
import com.javi.uned.pfgcommons.model.Compas;
import com.javi.uned.pfgcommons.model.Figura;
import com.javi.uned.pfgcommons.model.Instrumento;
import com.javi.uned.pfgcommons.model.Tonalidad;

public class GeneticSpecsDTO {
    private int requesterId;
    private String movementTitle;
    private String movementNumber;
    private String[] authors;
    private int measures;
    private Compas compas;
    private Instrumento[] instrumentos;
    private TonalityDTO tonalidad;
    private int phraseLength;
    private Figura minFigura;
    private Figura maxFigura;

    public int getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(int requesterId) {
        this.requesterId = requesterId;
    }

    public String getMovementTitle() {
        return movementTitle;
    }

    public void setMovementTitle(String movementTitle) {
        this.movementTitle = movementTitle;
    }

    public String getMovementNumber() {
        return movementNumber;
    }

    public void setMovementNumber(String movementNumber) {
        this.movementNumber = movementNumber;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public int getMeasures() {
        return measures;
    }

    public void setMeasures(int measures) {
        this.measures = measures;
    }

    public Compas getCompas() {
        return compas;
    }

    public void setCompas(Compas compas) {
        this.compas = compas;
    }

    public Instrumento[] getInstrumentos() {
        return instrumentos;
    }

    public void setInstrumentos(Instrumento[] instrumentos) {
        this.instrumentos = instrumentos;
    }

    public TonalityDTO getTonalidad() {
        return tonalidad;
    }

    public void setTonalidad(TonalityDTO tonalidad) {
        this.tonalidad = tonalidad;
    }

    public int getPhraseLength() {
        return phraseLength;
    }

    public void setPhraseLength(int phraseLength) {
        this.phraseLength = phraseLength;
    }

    public Figura getMinFigura() {
        return minFigura;
    }

    public void setMinFigura(Figura minFigura) {
        this.minFigura = minFigura;
    }

    public Figura getMaxFigura() {
        return maxFigura;
    }

    public void setMaxFigura(Figura maxFigura) {
        this.maxFigura = maxFigura;
    }
}
