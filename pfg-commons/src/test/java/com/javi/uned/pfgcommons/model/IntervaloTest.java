package com.javi.uned.pfgcommons.model;

import com.javi.uned.pfgcommons.model.constants.MelodiaAbsolutePitches;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IntervaloTest {

    @Test
    void testLower() {
        Intervalo intervalo = new Intervalo(MelodiaAbsolutePitches.A4, MelodiaAbsolutePitches.B4);
        assert intervalo.getLower().equals(MelodiaAbsolutePitches.A4);
    }

    @Test
    void testHigher() {
        Intervalo intervalo = new Intervalo(MelodiaAbsolutePitches.A4, MelodiaAbsolutePitches.B4);
        assert intervalo.getHigher().equals(MelodiaAbsolutePitches.B4);
    }

    @Test
    void testIncludes(){
        Intervalo intervalo = new Intervalo(MelodiaAbsolutePitches.C4, MelodiaAbsolutePitches.G4);
        assert intervalo.includes(MelodiaAbsolutePitches.E4);
    }
}
