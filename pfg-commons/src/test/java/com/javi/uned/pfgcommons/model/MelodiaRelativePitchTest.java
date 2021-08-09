package com.javi.uned.pfgcommons.model;

import com.javi.uned.pfgcommons.model.constants.Distancias;
import com.javi.uned.pfgcommons.model.constants.MelodiaRelativePitches;
import org.junit.jupiter.api.Test;

class MelodiaRelativePitchTest {

    @Test
    void Interval_2MAsc_Success() {
        assert MelodiaRelativePitches.A.intervalo(Distancias.D_2_M, true).equals(MelodiaRelativePitches.B);
    }

    @Test
    void Interval_6MAsc_Success() {
        assert MelodiaRelativePitches.A.intervalo(Distancias.D_6_M, true).equals(MelodiaRelativePitches.F_S);
    }

    @Test
    void Interval_4JAsc_Success() {
        assert MelodiaRelativePitches.C.intervalo(Distancias.D_4_J, true).equals(MelodiaRelativePitches.F);
    }

    @Test
    void Interval_5JDesc_Success() {
        assert MelodiaRelativePitches.A.intervalo(Distancias.D_5_J, false).equals(MelodiaRelativePitches.D);
    }

    @Test
    void SemitoneDistance_Ascendent_Success() {
        assert MelodiaRelativePitches.C.semitoneDistance(MelodiaRelativePitches.A, true) == 9;
    }

    @Test
    void SemitoneDistance_AscendentWithOverflow_Success() {
        assert MelodiaRelativePitches.A.semitoneDistance(MelodiaRelativePitches.C, true) == 3;
    }

    @Test
    void SemitoneDistance_Descendent_Success() {
        assert MelodiaRelativePitches.A.semitoneDistance(MelodiaRelativePitches.C, false) == 9;
    }

    @Test
    void SemitoneDistance_DescendentWithOverflow_Success() {
        assert MelodiaRelativePitches.C.semitoneDistance(MelodiaRelativePitches.A, false) == 3;
    }

}