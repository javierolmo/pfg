package com.javi.uned.pfgcommons.model.constants;

import com.javi.uned.pfgcommons.model.Figura;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FigurasTest {

    @RepeatedTest(100)
    void Random_MinAndMax_BoundsCheck() {
        Figura minFigura = Figuras.random(Figuras.SEMIFUSA, Figuras.NEGRA);
        Figura maxFigura = Figuras.random(Figuras.NEGRA, Figuras.REDONDA);

        Figura randomFigura = Figuras.random(minFigura, maxFigura);
        assert randomFigura.getDuration() <= maxFigura.getDuration();
        assert randomFigura.getDuration() >= minFigura.getDuration();
        System.out.println(randomFigura);
    }

    @Test
    void Random_WrongBounds_Exception(){
        assertThrows(IllegalArgumentException.class, () -> Figuras.random(Figuras.NEGRA, Figuras.CORCHEA));
    }

}