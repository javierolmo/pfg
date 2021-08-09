package com.javi.uned.pfgcommons.model.constants;

import com.javi.uned.pfgcommons.model.MelodiaStep;
import org.apache.commons.lang3.ArrayUtils;

public class MelodiaSteps {

    public static final MelodiaStep A = new MelodiaStep("A", 9);
    public static final MelodiaStep B = new MelodiaStep("B", 11);
    public static final MelodiaStep C = new MelodiaStep("C", 0);
    public static final MelodiaStep D = new MelodiaStep("D", 2);
    public static final MelodiaStep E = new MelodiaStep("E", 4);
    public static final MelodiaStep F = new MelodiaStep("F", 5);
    public static final MelodiaStep G = new MelodiaStep("G", 7);

    private static final MelodiaStep[] steps = {A, B, C, D, E, F, G};

    private MelodiaSteps () {

    }

    public static MelodiaStep interval(MelodiaStep baseStep, int distance, boolean ascendent) {
        distance--;
        int baseIndex = ArrayUtils.indexOf(steps, baseStep);
        int targetIndex = (ascendent? baseIndex + distance : baseIndex - distance) % steps.length;
        while (targetIndex < 0) targetIndex = steps.length + targetIndex;
        return steps[targetIndex];
    }

}
