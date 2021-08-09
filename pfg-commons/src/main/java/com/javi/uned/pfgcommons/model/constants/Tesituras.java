package com.javi.uned.pfgcommons.model.constants;

import com.javi.uned.pfgcommons.model.Tesitura;

public class Tesituras {

    public static final Tesitura PIANO_MANO_DERECHA = new Tesitura(MelodiaAbsolutePitches.G3, MelodiaAbsolutePitches.C6);
    public static final Tesitura PIANO_MANO_IZQUIERDA = new Tesitura(MelodiaAbsolutePitches.A2, MelodiaAbsolutePitches.G4);
    public static final Tesitura VIOLIN = new Tesitura(MelodiaAbsolutePitches.G3, MelodiaAbsolutePitches.A6);

    private Tesituras () {  }
}
