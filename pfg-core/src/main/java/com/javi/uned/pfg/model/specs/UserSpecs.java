package com.javi.uned.pfg.model.specs;

import com.javi.uned.pfg.model.Compas;
import com.javi.uned.pfg.model.Figura;
import com.javi.uned.pfg.model.Instrumento;
import com.javi.uned.pfg.model.Tonalidad;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class UserSpecs {

    private String movementTitle;
    private String movementNumber;
    private List<String> authors;
    private int measures;
    private Compas compas;
    private Instrumento[] instrumentos;
    private Tonalidad tonalidad;
    private int phraseLenght = 8;
    private Figura minFigura;
    private Figura maxFigura;

    public String getMovementTitle() {
        return movementTitle;
    }

    public String getMovementNumber() {
        return movementNumber;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public int getMeasures() {
        return measures;
    }

    public Compas getCompas() {
        return compas;
    }

    public void setMovementTitle(String movementTitle) {
        this.movementTitle = movementTitle;
    }

    public void setMovementNumber(String movementNumber) {
        this.movementNumber = movementNumber;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void setMeasures(int measures) {
        this.measures = measures;
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

    public Tonalidad getTonalidad() {
        return tonalidad;
    }

    public void setTonalidad(Tonalidad tonalidad) {
        this.tonalidad = tonalidad;
    }

    public int getPhraseLenght() {
        return phraseLenght;
    }

    public void setPhraseLenght(int phraseLenght) {
        this.phraseLenght = phraseLenght;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSpecs userSpecs = (UserSpecs) o;
        return measures == userSpecs.measures && phraseLenght == userSpecs.phraseLenght && Objects.equals(movementTitle, userSpecs.movementTitle) && Objects.equals(movementNumber, userSpecs.movementNumber) && Objects.equals(authors, userSpecs.authors) && Objects.equals(compas, userSpecs.compas) && Arrays.equals(instrumentos, userSpecs.instrumentos) && Objects.equals(tonalidad, userSpecs.tonalidad) && Objects.equals(minFigura, userSpecs.minFigura) && Objects.equals(maxFigura, userSpecs.maxFigura);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(movementTitle, movementNumber, authors, measures, compas, tonalidad, phraseLenght, minFigura, maxFigura);
        result = 31 * result + Arrays.hashCode(instrumentos);
        return result;
    }
}
