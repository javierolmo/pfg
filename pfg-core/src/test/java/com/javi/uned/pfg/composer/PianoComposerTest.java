package com.javi.uned.pfg.composer;

import com.javi.uned.pfg.composer.piano.PianoComposer;
import com.javi.uned.pfg.model.specs.UserSpecs;
import com.javi.uned.pfg.model.Staff;
import com.javi.uned.pfg.model.Tesitura;
import com.javi.uned.pfg.model.constants.Figuras;
import com.javi.uned.pfg.model.constants.Tesituras;
import com.javi.uned.pfg.model.parts.PartComposite;
import com.javi.uned.pfg.model.specs.UserSpecsBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PianoComposerTest {

    private PartComposite pianoPart;

    @BeforeAll
    public void setup(){
        // Specs
        UserSpecs userSpecs = UserSpecsBuilder.initDefault()
                .movementTitle("Prueba composición")
                .minFigura(Figuras.SEMICORCHEA)
                .maxFigura(Figuras.CORCHEA)
                .build();

        PianoComposer pianoComposer = new PianoComposer();

        this.pianoPart = pianoComposer.compose(userSpecs);
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
