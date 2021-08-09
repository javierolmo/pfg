package com.javi.uned.pfgcommons.model;

import com.javi.uned.pfgcommons.model.constants.Acordes;
import com.javi.uned.pfgcommons.model.constants.MelodiaRelativePitches;
import org.junit.jupiter.api.Test;

class AcordeTest {

    @Test
    public void test() {
        MelodiaRelativePitch[] pitches = Acordes.TRIADA_MAYOR.of(MelodiaRelativePitches.D);
        System.out.println("Hola");
    }

}