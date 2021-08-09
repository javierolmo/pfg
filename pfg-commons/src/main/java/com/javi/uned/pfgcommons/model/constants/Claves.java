package com.javi.uned.pfgcommons.model.constants;

import com.javi.uned.pfgcommons.model.Clave;
import org.audiveris.proxymusic.Clef;
import org.audiveris.proxymusic.ClefSign;

import java.math.BigInteger;

public class Claves {

    public static final Clave SOL1 = new Clave("G", 1);
    public static final Clave SOL2 = new Clave("G", 2);
    public static final Clave FA3 = new Clave("F", 3);
    public static final Clave FA4 = new Clave("F", 4);
    public static final Clave FA5 = new Clave("F", 5);
    public static final Clave DO1 = new Clave("C", 1);
    public static final Clave DO2 = new Clave("C", 2);
    public static final Clave DO3 = new Clave("C", 3);
    public static final Clave DO4 = new Clave("C", 4);
    public static final Clave DO5 = new Clave("C", 5);

    private Claves () {  }

    public static Clave[] getClaves(){
        return new Clave[]{SOL1, SOL2, FA3, FA4, FA5, DO1, DO2, DO3, DO4, DO5};
    }

    public static Clef toClef(Clave clave){
        Clef clef = new Clef();
        clef.setSign(ClefSign.valueOf(clave.getStep()));
        clef.setLine(BigInteger.valueOf(clave.getLine()));
        return clef;
    }


}
