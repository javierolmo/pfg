package com.javi.uned.pfgcommons.model.constants;

import com.javi.uned.pfgcommons.model.MelodiaRelativePitch;

public class MelodiaRelativePitches {

    public static final MelodiaRelativePitch C_B = new MelodiaRelativePitch(MelodiaSteps.C, -1);
    public static final MelodiaRelativePitch C = new MelodiaRelativePitch(MelodiaSteps.C, 0);
    public static final MelodiaRelativePitch C_S = new MelodiaRelativePitch(MelodiaSteps.C, 1);
    public static final MelodiaRelativePitch D_B = new MelodiaRelativePitch(MelodiaSteps.D, -1);
    public static final MelodiaRelativePitch D = new MelodiaRelativePitch(MelodiaSteps.D, 0);
    public static final MelodiaRelativePitch D_S = new MelodiaRelativePitch(MelodiaSteps.D, 1);
    public static final MelodiaRelativePitch E_B = new MelodiaRelativePitch(MelodiaSteps.E, -1);
    public static final MelodiaRelativePitch E = new MelodiaRelativePitch(MelodiaSteps.E, 0);
    public static final MelodiaRelativePitch E_S = new MelodiaRelativePitch(MelodiaSteps.E, 1);
    public static final MelodiaRelativePitch F_B = new MelodiaRelativePitch(MelodiaSteps.F, -1);
    public static final MelodiaRelativePitch F = new MelodiaRelativePitch(MelodiaSteps.F, 0);
    public static final MelodiaRelativePitch F_S = new MelodiaRelativePitch(MelodiaSteps.F, 1);
    public static final MelodiaRelativePitch G_B = new MelodiaRelativePitch(MelodiaSteps.G, -1);
    public static final MelodiaRelativePitch G = new MelodiaRelativePitch(MelodiaSteps.G, 0);
    public static final MelodiaRelativePitch G_S = new MelodiaRelativePitch(MelodiaSteps.G, 1);
    public static final MelodiaRelativePitch A_B = new MelodiaRelativePitch(MelodiaSteps.A, -1);
    public static final MelodiaRelativePitch A = new MelodiaRelativePitch(MelodiaSteps.A, 0);
    public static final MelodiaRelativePitch A_S = new MelodiaRelativePitch(MelodiaSteps.A, 1);
    public static final MelodiaRelativePitch B_B = new MelodiaRelativePitch(MelodiaSteps.B, -1);
    public static final MelodiaRelativePitch B = new MelodiaRelativePitch(MelodiaSteps.B, 0);
    public static final MelodiaRelativePitch B_S = new MelodiaRelativePitch(MelodiaSteps.B, 1);

    private MelodiaRelativePitches () {

    }

    public static MelodiaRelativePitch[] all() {
        return new MelodiaRelativePitch[] {
                C_B, C, C_S, D_B, D, D_S, E_B, E, E_S, F_B, F, F_S, G_B, G, G_S, A_B, A, A_S, B_B, B, B_S};
    }
}
