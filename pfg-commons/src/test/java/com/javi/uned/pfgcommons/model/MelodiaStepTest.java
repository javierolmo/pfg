package com.javi.uned.pfgcommons.model;

import com.javi.uned.pfgcommons.model.constants.MelodiaSteps;
import org.junit.jupiter.api.Test;

class MelodiaStepTest {

    @Test
    void Interval_SimpleAscendent_Success() {
        assert MelodiaSteps.A.interval(2, true).equals(MelodiaSteps.B);
    }

    @Test
    void Interval_SimpleDescendent_Success() {
        assert MelodiaSteps.C.interval(2, false).equals(MelodiaSteps.B);
    }

    @Test
    void Interval_BigAscendent_Success() {
        assert MelodiaSteps.A.interval(7, true).equals(MelodiaSteps.G);
    }

    @Test
    void Interval_BigDescendent_Success() {
        assert MelodiaSteps.G.interval(7, false).equals(MelodiaSteps.A);
    }

    @Test
    void Interval_OverflowArrayAscendent_Success () {
        assert MelodiaSteps.F.interval(3, true).equals(MelodiaSteps.A);
    }

    @Test
    void Interval_OverflowArrayDescendent_Success () {
        assert MelodiaSteps.A.interval(3, false).equals(MelodiaSteps.F);
    }

}