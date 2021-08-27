package com.javi.uned.pfgcommons.model.constants;

import com.javi.uned.pfgcommons.model.Compas;
import com.javi.uned.pfgcommons.model.Instrumento;
import com.javi.uned.pfgcommons.model.Scope;

import java.util.Random;

public class Instrumentos {

    public static final Instrumento PIANO = new Instrumento("PIANO", "PNO", "Piano", null, "Pno.","keyboard.piano", new Scope(Tesituras.PIANO_MANO_DERECHA, Claves.SOL2), new Scope(Tesituras.PIANO_MANO_IZQUIERDA, Claves.FA4));
    public static final Instrumento VIOLIN = new Instrumento("VIOLIN","VLN", "Violin", null, "Vln.", "strings.violin", new Scope(Tesituras.VIOLIN, Claves.SOL2));
    public static final Instrumento SAXOFON_TENOR = new Instrumento("SAXOFON_TENOR","SAX", "Saxofon", null, "Sax.", "wind.reed.saxophone.tenor", new Scope(Tesituras.VIOLIN, Claves.SOL2));

    private Instrumentos () {  }

    public static Instrumento[] getInstrumentos(){
        return new Instrumento[]{PIANO, VIOLIN, SAXOFON_TENOR};
    }

    public static Instrumento random() {
        Instrumento[] elements = getInstrumentos();
        return elements[new Random().nextInt(elements.length)];
    }
}
