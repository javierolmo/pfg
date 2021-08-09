package com.javi.uned.pfgcommons.model.constants;

import com.javi.uned.pfgcommons.model.Escala;

import static com.javi.uned.pfgcommons.model.constants.Distancias.D_2_M;
import static com.javi.uned.pfgcommons.model.constants.Distancias.D_2_m;

public class Escalas {

    public static final Escala MAYOR = new Escala(D_2_M, D_2_M, D_2_m, D_2_M, D_2_M, D_2_M, D_2_m);
    public static final Escala MENOR = new Escala(D_2_M, D_2_m, D_2_M, D_2_M, D_2_m, D_2_M, D_2_M);

}
