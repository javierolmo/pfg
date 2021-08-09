package com.javi.uned.pfgcommons.model.parts;

import com.javi.uned.pfgcommons.model.Instrumento;
import com.javi.uned.pfgcommons.model.measures.MeasureFactory;
import com.javi.uned.pfgcommons.model.measures.MelodiaMeasure;

import java.util.ArrayList;
import java.util.List;

public abstract class PartComposite {

    private final Instrumento instrumento;
    private final String partName;
    private final List<MelodiaMeasure> measures;
    private String partId;

    protected PartComposite(int size, Instrumento instrumento) {
        this.instrumento = instrumento;
        this.partName = instrumento.getName();
        this.measures = new ArrayList<>();
        this.partId = String.format("%s-%d", instrumento.getCode(), 0);

        //Inicializar compases vacios
        for(int i=0; i<size; i++){
            MelodiaMeasure melodiaMeasure = MeasureFactory.createEmptyMeasure(instrumento);
            measures.add(melodiaMeasure);
        }
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }

    public String getPartName() {
        return partName;
    }

    public String getPartId() {
        return partId;
    }

    public List<MelodiaMeasure> getMeasures() {
        return measures;
    }

}
