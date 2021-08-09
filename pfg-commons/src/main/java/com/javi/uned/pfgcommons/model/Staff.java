package com.javi.uned.pfgcommons.model;

import com.javi.uned.pfgcommons.model.constants.Figuras;
import com.javi.uned.pfgcommons.model.measures.MelodiaMeasure;
import com.javi.uned.pfgcommons.model.specs.GeneticSpecs;

import java.util.ArrayList;
import java.util.List;

/**
 * Compás en un único pentagrama, a diferencia de Measure, que abarcaría todos los compases
 * de mismo índice en partituras de varios pentagramas. (Ej: un Measure de una partitura de
 * piano tendría dos Staffs, el de clave de sol y el de fa en 4º)
 */
public class Staff {

    private final List<MelodiaNote> notes;
    private final MelodiaMeasure measure;
    private final Clave clave;
    private int index;
    private final Tesitura tesitura;

    public Staff(MelodiaMeasure measure, Clave clave, int index, Tesitura tesitura){
        this.measure = measure;
        this.notes = new ArrayList<>();
        this.clave = clave;
        this.index = index;
        this.tesitura = tesitura;
    }

    public List<MelodiaNote> getNotes() {
        return notes;
    }

    public Clave getClave() {
        return clave;
    }

    public int getIndex() {
        return index;
    }

    public Tesitura getTesitura() {
        return tesitura;
    }

    public void appendNote(MelodiaNote melodiaNote){
        if(fits(melodiaNote)){
            notes.add(melodiaNote);
            measure.updateDivisions();
        }
    }

    private boolean fits(MelodiaNote note){
        double duracionTotal = Figuras.byValue(measure.getCompas().getDenominador()).getDuration() * measure.getCompas().getNumerador();
        double duracionOcupada = notes.stream().mapToDouble(note1 -> note1.getFigura().getDuration()).sum();
        double duracionRequerida = note.getFigura().getDuration();

        return duracionTotal - duracionOcupada >= duracionRequerida;
    }

    private double duracionRestante() {
        double duracionTotal = Figuras.byValue(measure.getCompas().getDenominador()).getDuration() * measure.getCompas().getNumerador();
        double duracionOcupada = notes.stream().mapToDouble(note1 -> note1.getFigura().getDuration()).sum();
        return duracionTotal - duracionOcupada;
    }

    public boolean isFull(){
        double duracionTotal = Figuras.byValue(measure.getCompas().getDenominador()).getDuration() * measure.getCompas().getNumerador();
        double duracionOcupada = 0;
        for(MelodiaNote melodiaNote : notes){
            duracionOcupada += melodiaNote.getFigura().getDuration();
        }
        return duracionTotal == duracionOcupada;
    }

    //TODO: Aquí se puede mejorar. Aleatorizar nueva figura en función del espacio disponible
    public void randomize(GeneticSpecs geneticSpecs) {
        while(!isFull()){
            MelodiaNote melodiaNote = MelodiaNote.random(geneticSpecs.getMinFigura(), geneticSpecs.getMaxFigura(),
                    tesitura.getIntervalo().getLower(), tesitura.getIntervalo().getHigher());
            appendNote(melodiaNote);
        }
    }



}
