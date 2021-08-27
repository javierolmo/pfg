package com.javi.uned.pfgcommons.model;

import com.javi.uned.pfgcommons.exceptions.ExportException;
import com.javi.uned.pfgcommons.io.Export;
import com.javi.uned.pfgcommons.model.parts.PartComposite;
import com.javi.uned.pfgcommons.model.specs.GeneticSpecs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MelodiaScore {

    private List<PartComposite> parts;
    private final Estructura estructura;
    private final GeneticSpecs geneticSpecs;
    private final String movementTitle;
    private final String movementNumber;
    private final String[] authors;

    public MelodiaScore(GeneticSpecs geneticSpecs){
        this.geneticSpecs = geneticSpecs;
        this.movementNumber = geneticSpecs.getMovementNumber();
        this.movementTitle = geneticSpecs.getMovementTitle();
        this.authors = geneticSpecs.getAuthors();
        this.estructura = new Estructura(geneticSpecs);
        this.parts = new ArrayList<>();
    }

    public String getMovementTitle() {
        return movementTitle;
    }

    public String getMovementNumber() {
        return movementNumber;
    }

    public String[] getAuthors() {
        return authors;
    }

    public List<PartComposite> getParts() {
        return parts;
    }

    public void setParts(List<PartComposite> parts) {
        this.parts = parts;
    }

    public Estructura getEstructura() {
        return estructura;
    }

    public GeneticSpecs getSpecs() {
        return geneticSpecs;
    }

    public void exportToXML(File file) throws ExportException {
        Export.toXML(this, file);
    }

    public void addPartComposite(PartComposite partComposite){
        String partCompositeID = partComposite.getPartId();

        //Comprobar si el ID es válido, y sino incrementarlo
        boolean idValido = false;
        while(!idValido){
            if(existsPartID(partCompositeID)){
                idValido = false;
                String[] arrayID = partCompositeID.split("-");
                arrayID[1] = "" + (Integer.parseInt(arrayID[1])+1);
                partCompositeID = String.join("-", arrayID);
            }else{
                idValido = true;
            }
        }

        //Añadir a la colección
        parts.add(partComposite);

    }

    private boolean existsPartID(String partID){
        //Comprobar si existe el id
        for (PartComposite part : parts) {
            if(partID.equals(part.getPartId())) return true;
        }
        return false;
    }

}
