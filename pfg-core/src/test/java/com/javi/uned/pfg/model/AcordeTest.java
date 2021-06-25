package com.javi.uned.pfg.model;

import com.javi.uned.pfg.model.constants.Acordes;
import com.javi.uned.pfg.model.constants.MelodiaRelativePitches;
import org.junit.jupiter.api.Test;

class AcordeTest {

    @Test
    public void test() {
        MelodiaRelativePitch[] pitches = Acordes.TRIADA_MAYOR.of(MelodiaRelativePitches.D);
        System.out.println("Hola");
    }

}