package com.javi.uned.pfgcommons.composer;

import com.javi.uned.pfgcommons.composer.piano.PianoComposer;
import com.javi.uned.pfgcommons.model.Staff;
import com.javi.uned.pfgcommons.model.Tesitura;
import com.javi.uned.pfgcommons.model.constants.Figuras;
import com.javi.uned.pfgcommons.model.constants.Tesituras;
import com.javi.uned.pfgcommons.model.parts.PartComposite;
import com.javi.uned.pfgcommons.model.specs.GeneticSpecs;
import com.javi.uned.pfgcommons.model.specs.UserSpecsBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PianoComposerTest {

    private PartComposite pianoPart;

    @BeforeAll
    public void setup(){
        // Specs
        GeneticSpecs geneticSpecs = UserSpecsBuilder.initDefault()
                .movementTitle("Prueba composición")
                .minFigura(Figuras.SEMICORCHEA)
                .maxFigura(Figuras.CORCHEA)
                .build();

        PianoComposer pianoComposer = new PianoComposer();

        this.pianoPart = pianoComposer.compose(geneticSpecs);
    }

    @Test
    void comprobarTesitura(){
        this.pianoPart.getMeasures().forEach(measureComposite -> {
            for (Staff staff : measureComposite.getStaves()) {
                staff.getNotes().forEach(noteComposite -> {
                    assert staff.getTesitura().getIntervalo().includes(noteComposite.getPitch());
                });
            }
        });
    }

    @Test
    void comprobarDuracionCompases(){
        this.pianoPart.getMeasures().forEach(measureComposite -> {
            for (Staff staff : measureComposite.getStaves()) {
                assert staff.isFull();
            }
        });
    }

    @Test
    void comprobarTesitura2(){
        Tesitura tesituraPiano = Tesituras.PIANO_MANO_DERECHA;
        this.pianoPart.getMeasures().forEach(measureComposite -> {
            for (Staff staff : measureComposite.getStaves()) {
                staff.getNotes().forEach(noteComposite -> {
                    System.out.printf("%b: %s -> %s\n",
                            staff.getTesitura().getIntervalo().includes(noteComposite.getPitch()),
                            noteComposite,
                            staff.getTesitura().getIntervalo().toString());
                });
            }
        });
    }

}
