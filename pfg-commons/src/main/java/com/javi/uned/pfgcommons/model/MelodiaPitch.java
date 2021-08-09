package com.javi.uned.pfgcommons.model;

public interface MelodiaPitch {

    MelodiaStep getStep();
    int getAlter();

    default String getAlterSymbol() {
        switch (getAlter()) {
            case 2: return "##";
            case 1: return "#";
            case -1: return "b";
            case -2: return "bb";
            default: return "";
        }
    }
}
