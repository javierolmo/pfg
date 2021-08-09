package com.javi.uned.pfgcommons.model.measures;

import com.javi.uned.pfgcommons.model.*;
import com.javi.uned.pfgcommons.model.constants.*;
import com.javi.uned.pfgcommons.model.specs.GeneticSpecs;
import org.audiveris.proxymusic.*;
import org.audiveris.proxymusic.ScorePartwise.Part.Measure;

import java.lang.String;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class MelodiaMeasure {

    private Compas compas;
    private Staff[] staves;
    private int divisions;
    private Instrumento instrumento;
    private Tonalidad tonality;
    private Grado grade;

    public MelodiaMeasure(Instrumento instrumento){
        this.divisions = 1;
        this.compas = Compases.COMPAS_4x4;
        this.staves = new Staff[instrumento.getScopes().length];
        this.instrumento = instrumento;

        //Create staffs
        for(int i=0; i<instrumento.getScopes().length; i++){
            Scope scope = instrumento.getScopes()[i];
            this.staves[i] = new Staff(this, scope.getClave(), i+1, scope.getTesitura());
        }
    }

    public void updateDivisions(){
        Figura minDurationFigure = Figuras.REDONDA;

        for(int i=0; i<staves.length; i++){
            for(MelodiaNote note : staves[i].getNotes()){
                if(note.getFigura().getValue() > minDurationFigure.getValue()){
                    minDurationFigure = note.getFigura();
                }
            }
        }

        int tmpDivisions = minDurationFigure.getValue() / Figuras.NEGRA.getValue();
        if(tmpDivisions >= 1) this.divisions = tmpDivisions;
    }

    public Compas getCompas() {
        return compas;
    }

    public void setCompas(Compas compas) {
        this.compas = compas;
    }

    public void randomize(GeneticSpecs geneticSpecs){
        this.tonality = Tonalidades.DO_M;
        this.grade = Grado.I;
        for (Staff staff : staves) {
            staff.randomize(geneticSpecs);
        }
    }

    public Measure toMeasure(int number) {

        Measure measure = new Measure();

        //Attributes
        Attributes attributes = new Attributes();
        measure.getNoteOrBackupOrForward().add(attributes);
        attributes.setDivisions(BigDecimal.valueOf(divisions));

        if(number == 0) {
            //Staves
            attributes.setStaves(BigInteger.valueOf(staves.length));
            //Clef
            for(int i=0; i<staves.length; i++){
                Clef clef = Claves.toClef(staves[i].getClave());
                clef.setNumber(BigInteger.valueOf(i+1));
                attributes.getClef().add(clef);
            }
            // Time
            Time time = new Time();
            attributes.getTime().add(time);
            time.getTimeSignature().add(new ObjectFactory().createTimeBeats(String.valueOf(compas.getNumerador())));
            time.getTimeSignature().add(new ObjectFactory().createTimeBeatType(String.valueOf(compas.getDenominador())));
        }

        //Number
        measure.setNumber(String.valueOf(number));

        //Implicit
        measure.setImplicit(YesNo.NO);

        //Append notes to measure
        for(int i=0; i<staves.length; i++){
            for(MelodiaNote note : staves[i].getNotes()){
                measure.getNoteOrBackupOrForward().add(note.toNote(divisions, i));
            }
            Backup backup = new Backup();
            int backupValue = (int) (divisions*compas.getNumerador()*Figuras.byValue(compas.getDenominador()).getDuration());
            backup.setDuration(BigDecimal.valueOf(backupValue));
            measure.getNoteOrBackupOrForward().add(backup);
        }
        return measure;
    }

    public Staff[] getStaves() {
        return staves;
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }

    public Tonalidad getTonality() {
        return tonality;
    }

    public void setTonality(Tonalidad tonality) {
        this.tonality = tonality;
    }

    public Grado getGrade() {
        return grade;
    }

    public void setGrade(Grado grade) {
        this.grade = grade;
    }
}
