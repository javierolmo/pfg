package com.javi.uned.pfgcommons.model.constants;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MelodiaStepsTest {

    @Test
    void Interval_SimpleAscendent_Success() {
        assert MelodiaSteps.interval(MelodiaSteps.A, 2, true).equals(MelodiaSteps.B);
    }

    @Test
    void Interval_SimpleDescendent_Success() {
        assert MelodiaSteps.interval(MelodiaSteps.C, 2, false).equals(MelodiaSteps.B);
    }

    @Test
    void Interval_BigAscendent_Success() {
        assert MelodiaSteps.interval(MelodiaSteps.A, 7, true).equals(MelodiaSteps.G);
    }

    @Test
    void Interval_BigDescendent_Success() {
        assert MelodiaSteps.interval(MelodiaSteps.G, 7, false).equals(MelodiaSteps.A);
    }

    @Test
    void Interval_OverflowArrayAscendent_Success () {
        assert MelodiaSteps.interval(MelodiaSteps.F, 3, true).equals(MelodiaSteps.A);
    }

    @Test
    void Interval_OverflowArrayDescendent_Success () {
        assert MelodiaSteps.interval(MelodiaSteps.A, 3, false).equals(MelodiaSteps.F);
    }



}