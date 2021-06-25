package com.javi.uned.pfg.model.constants;

import com.javi.uned.pfg.model.Instrumento;
import com.javi.uned.pfg.model.Scope;

public class Instrumentos {

    public static final Instrumento PIANO = new Instrumento("PIANO", "PNO", "Piano", null, "Pno.","keyboard.piano", new Scope(Tesituras.PIANO_MANO_DERECHA, Claves.SOL2), new Scope(Tesituras.PIANO_MANO_IZQUIERDA, Claves.FA4));
    public static final Instrumento VIOLIN = new Instrumento("VIOLIN","VLN", "Violin", null, "Vln.", "strings.violin", new Scope(Tesituras.VIOLIN, Claves.SOL2));
    public static final Instrumento SAXOFON_TENOR = new Instrumento("SAXOFON_TENOR","SAX", "Saxofon", null, "Sax.", "wind.reed.saxophone.tenor", new Scope(Tesituras.VIOLIN, Claves.SOL2));

    private Instrumentos () {  }

    public static Instrumento[] getInstrumentos(){
        return new Instrumento[]{PIANO, VIOLIN, SAXOFON_TENOR};
    }
}
