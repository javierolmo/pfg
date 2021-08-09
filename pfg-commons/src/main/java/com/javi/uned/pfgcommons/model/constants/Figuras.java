package com.javi.uned.pfgcommons.model.constants;

import com.javi.uned.pfgcommons.model.Figura;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Random;

public class Figuras {

    public static final Figura SEMIFUSA = new Figura("64th", 64, (double) 1/16);
    public static final Figura FUSA = new Figura("32nd", 32, (double) 1/8);
    public static final Figura SEMICORCHEA = new Figura("16th", 16, (double) 1/4);
    public static final Figura CORCHEA = new Figura("eighth", 8, (double) 1/2);
    public static final Figura NEGRA = new Figura("quarter", 4, 1D);
    public static final Figura BLANCA = new Figura("half", 2, 2D);
    public static final Figura REDONDA = new Figura("whole", 1,4D);

    private Figuras () {  }

    public static Figura byValue(int value){
        switch (value){
            case 1: return REDONDA;
            case 2: return BLANCA;
            case 4: return NEGRA;
            case 8: return CORCHEA;
            case 16: return SEMICORCHEA;
            case 32: return FUSA;
            case 64: return SEMIFUSA;
            default: throw new IllegalArgumentException("Figura con valor "+value+" inválida");
        }
    }

    public static Figura[] getFiguras(){
        return new Figura[] {SEMIFUSA, FUSA, SEMICORCHEA, CORCHEA, NEGRA, BLANCA, REDONDA};
    }

    public static Figura random(Figura min, Figura max){
        Figura[] figuras = getFiguras();

        int minIndex = ArrayUtils.indexOf(figuras, min);
        int maxIndex = ArrayUtils.indexOf(figuras, max);
        int selectedIndex = new Random().nextInt(maxIndex-minIndex+1) + minIndex;

        return figuras[selectedIndex];
    }

}
