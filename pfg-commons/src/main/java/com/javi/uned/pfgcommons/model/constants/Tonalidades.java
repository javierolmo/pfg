package com.javi.uned.pfgcommons.model.constants;

import com.javi.uned.pfgcommons.model.Tonalidad;

import java.util.Random;

public class Tonalidades {

    public static final Tonalidad DO_M = new Tonalidad(MelodiaRelativePitches.C, true);
    public static final Tonalidad SOL_M = new Tonalidad(MelodiaRelativePitches.G, true);
    public static final Tonalidad RE_M = new Tonalidad(MelodiaRelativePitches.D, true);
    public static final Tonalidad LA_M = new Tonalidad(MelodiaRelativePitches.A, true);
    public static final Tonalidad MI_M = new Tonalidad(MelodiaRelativePitches.E, true);
    public static final Tonalidad SI_M = new Tonalidad(MelodiaRelativePitches.B, true);
    public static final Tonalidad FA_S_M = new Tonalidad(MelodiaRelativePitches.F_S, true);
    public static final Tonalidad SOL_B_M = new Tonalidad(MelodiaRelativePitches.G_B, true);
    public static final Tonalidad RE_B_M = new Tonalidad(MelodiaRelativePitches.D_B, true);
    public static final Tonalidad LA_B_M = new Tonalidad(MelodiaRelativePitches.A_B, true);
    public static final Tonalidad MI_B_M = new Tonalidad(MelodiaRelativePitches.E_B, true);
    public static final Tonalidad SI_B_M = new Tonalidad(MelodiaRelativePitches.B_B, true);
    public static final Tonalidad FA_M = new Tonalidad(MelodiaRelativePitches.F, true);
    public static final Tonalidad LA_m = new Tonalidad(MelodiaRelativePitches.A, false);
    public static final Tonalidad MI_m = new Tonalidad(MelodiaRelativePitches.E, false);
    public static final Tonalidad SI_m = new Tonalidad(MelodiaRelativePitches.B, false);
    public static final Tonalidad FA_S_m = new Tonalidad(MelodiaRelativePitches.F_S, false);
    public static final Tonalidad DO_S_m = new Tonalidad(MelodiaRelativePitches.C_S, false);
    public static final Tonalidad SOL_S_m = new Tonalidad(MelodiaRelativePitches.G_S, false);
    public static final Tonalidad RE_S_m = new Tonalidad(MelodiaRelativePitches.D_S, false);
    public static final Tonalidad MI_B_m = new Tonalidad(MelodiaRelativePitches.E_B, false);
    public static final Tonalidad SI_B_m = new Tonalidad(MelodiaRelativePitches.B_B, false);
    public static final Tonalidad FA_m = new Tonalidad(MelodiaRelativePitches.F, false);
    public static final Tonalidad DO_m = new Tonalidad(MelodiaRelativePitches.C, false);
    public static final Tonalidad SOL_m = new Tonalidad(MelodiaRelativePitches.G, false);
    public static final Tonalidad RE_m = new Tonalidad(MelodiaRelativePitches.D, false);

    private Tonalidades () {

    }

    public static Tonalidad[] getTonalidades(){
        return new Tonalidad[]{
                DO_M, SOL_M, RE_M, LA_M, MI_M, SI_M, FA_S_M, SOL_B_M, RE_B_M, LA_B_M, MI_B_M, SI_B_M, FA_M, LA_m, MI_m,
                SI_m, FA_S_m, DO_S_m, SOL_S_m, RE_S_m, MI_B_m, SI_B_m, FA_m, DO_m, SOL_m, RE_m
        };
    }

    public static Tonalidad random(){
        Tonalidad[] tonalidades = getTonalidades();
        int index = new Random().nextInt(tonalidades.length);
        return tonalidades[index];
    }
}
