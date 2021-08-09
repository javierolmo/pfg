package com.javi.uned.pfgcommons.model;

import com.javi.uned.pfgcommons.model.constants.Escalas;
import com.javi.uned.pfgcommons.model.constants.MelodiaRelativePitches;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

class EscalaTest {

    @Test
    void ChequeoIntervalosEscalaMayor() {
        for(MelodiaRelativePitch pitch : MelodiaRelativePitches.all()){
            MelodiaRelativePitch[] pitches = Escalas.MAYOR.of(pitch);
            for (int i = 1; i < pitches.length; i++) {
                assert pitches[i].equals(pitches[i-1].intervalo(Escalas.MAYOR.getDistances()[i-1], true));
            }

            System.out.printf("Escala %s Mayor: %s%n",
                    pitch.toString(),
                    Arrays.stream(pitches).map(MelodiaRelativePitch::toString).collect(Collectors.joining(", ")));
        }
    }

    @Test
    void ChequeoIntervalosEscalaMenor() {
        for(MelodiaRelativePitch pitch : MelodiaRelativePitches.all()){
            MelodiaRelativePitch[] pitches = Escalas.MENOR.of(pitch);
            for (int i = 1; i < pitches.length; i++) {
                assert pitches[i].equals(pitches[i-1].intervalo(Escalas.MENOR.getDistances()[i-1], true));
            }

            System.out.printf("Escala %s menor: %s%n",
                    pitch.toString(),
                    Arrays.stream(pitches).map(MelodiaRelativePitch::toString).collect(Collectors.joining(", ")));
        }
    }

}