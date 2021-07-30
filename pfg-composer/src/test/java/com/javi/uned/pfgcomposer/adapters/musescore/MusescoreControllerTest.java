package com.javi.uned.pfgcomposer.adapters.musescore;

import com.javi.uned.pfgcomposer.domain.exceptions.MusescoreException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MusescoreControllerTest {

    private MusescoreController musescoreController;

    @BeforeAll
    public void setUp() {
        musescoreController = new MusescoreController();
    }

    @Test
    public void test() throws MusescoreException {
        File xmlFile = new File(getClass().getClassLoader().getResource("musicxml_examples/BeetAnGeSample.musicxml").getFile());
        File pdfFile = musescoreController.convertXMLToPDF(xmlFile, "testpdf.pdf");
        assert pdfFile.exists();
        assert pdfFile.delete();
    }



}