package com.javi.uned.pfgcommons.model.constants;

import com.javi.uned.pfgcommons.model.Compas;

import java.util.Random;

public class Compases {

    public static final Compas COMPAS_2x4 = new Compas(2, 4, 2);
    public static final Compas COMPAS_3x4 = new Compas(3, 4, 3);
    public static final Compas COMPAS_4x4 = new Compas(4, 4, 4);
    public static final Compas COMPAS_3X8 = new Compas(3, 8, 3);
    public static final Compas COMPAS_6X8 = new Compas(6, 8, 2);
    public static final Compas COMPAS_9X8 = new Compas(9, 8, 3);
    public static final Compas COMPAS_12X8 = new Compas(12, 8, 4);

    private Compases () {  }

    public static Compas[] getCompases(){
        return new Compas[]{COMPAS_2x4, COMPAS_3x4, COMPAS_4x4, COMPAS_3X8, COMPAS_6X8, COMPAS_6X8, COMPAS_12X8};
    }

    public static Compas random() {
        Compas[] elements = getCompases();
        return elements[new Random().nextInt(elements.length)];
    }

}
