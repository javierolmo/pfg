package com.javi.uned.pfgcommons.io;

import com.javi.uned.pfgcommons.ScoreFactory;
import com.javi.uned.pfgcommons.composer.analyzers.SimpleMeasureAnalyzer;
import com.javi.uned.pfgcommons.composer.analyzers.configs.SimpleMeasureAnalyzerConfig;
import com.javi.uned.pfgcommons.exceptions.ExportException;
import com.javi.uned.pfgcommons.model.MelodiaScore;
import com.javi.uned.pfgcommons.model.constants.Figuras;
import com.javi.uned.pfgcommons.model.constants.Instrumentos;
import com.javi.uned.pfgcommons.model.specs.GeneticSpecs;
import com.javi.uned.pfgcommons.model.specs.UserSpecsBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.File;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExportTest {

    MelodiaScore melodiaScore;

    @BeforeAll
    void setUp () {

        // Specs
        GeneticSpecs geneticSpecs = UserSpecsBuilder.initDefault()
                .movementTitle("Prueba composición")
                .minFigura(Figuras.CORCHEA)
                .maxFigura(Figuras.BLANCA)
                .instruments(Instrumentos.VIOLIN)
                .measures(20)
                .build();

        this.melodiaScore = ScoreFactory.getInstance().createScore(geneticSpecs);
    }

    @Test
    void ExportToXml_PianoComposition_Success () throws ExportException {
        File testFolder = new File("test");
        testFolder.mkdir();
        Export.toXML(melodiaScore, new File(testFolder, "testComposition.musicxml"));
        melodiaScore.getParts().get(0).getMeasures().forEach(measure -> {
            SimpleMeasureAnalyzer analyzer = new SimpleMeasureAnalyzer(new SimpleMeasureAnalyzerConfig());
            System.out.println(analyzer.analyze(measure));
        });
    }

}