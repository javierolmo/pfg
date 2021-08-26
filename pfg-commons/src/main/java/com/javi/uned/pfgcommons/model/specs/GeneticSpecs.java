package com.javi.uned.pfgcommons.model.specs;

import com.javi.uned.pfgcommons.model.Compas;
import com.javi.uned.pfgcommons.model.Figura;
import com.javi.uned.pfgcommons.model.Instrumento;
import com.javi.uned.pfgcommons.model.Tonalidad;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GeneticSpecs {

    private String movementTitle;
    private String movementNumber;
    private List<String> authors;
    private int measures;
    private Compas compas;
    private Instrumento[] instrumentos;
    private Tonalidad tonalidad;
    private int phraseLength = 8;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneticSpecs geneticSpecs = (GeneticSpecs) o;
        return measures == geneticSpecs.measures && phraseLenght == geneticSpecs.phraseLenght && Objects.equals(movementTitle, geneticSpecs.movementTitle) && Objects.equals(movementNumber, geneticSpecs.movementNumber) && Objects.equals(authors, geneticSpecs.authors) && Objects.equals(compas, geneticSpecs.compas) && Arrays.equals(instrumentos, geneticSpecs.instrumentos) && Objects.equals(tonalidad, geneticSpecs.tonalidad) && Objects.equals(minFigura, geneticSpecs.minFigura) && Objects.equals(maxFigura, geneticSpecs.maxFigura);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(movementTitle, movementNumber, authors, measures, compas, tonalidad, phraseLenght, minFigura, maxFigura);
        result = 31 * result + Arrays.hashCode(instrumentos);
        return result;
    }
}
