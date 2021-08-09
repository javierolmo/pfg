package com.javi.uned.pfgcommons.composer.analyzers;

import com.javi.uned.pfgcommons.composer.analyzers.configs.SimpleMeasureAnalyzerConfig;
import com.javi.uned.pfgcommons.model.constants.Instrumentos;
import com.javi.uned.pfgcommons.model.measures.SimpleMeasure;
import com.javi.uned.pfgcommons.model.specs.GeneticSpecs;
import com.javi.uned.pfgcommons.model.specs.UserSpecsBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SimpleMeasureAnalyzerTest {

    SimpleMeasureAnalyzer simpleMeasureAnalyzer;
    GeneticSpecs geneticSpecs;


    @BeforeAll
    public void setUp() {
        simpleMeasureAnalyzer = new SimpleMeasureAnalyzer(new SimpleMeasureAnalyzerConfig());
        geneticSpecs = UserSpecsBuilder.initDefault().build();
    }

    @RepeatedTest(50)
    public void analyzeIntervals_checkInBounds() {

        // Create measure
        SimpleMeasure simpleMeasure = new SimpleMeasure(Instrumentos.VIOLIN);
        simpleMeasure.staff().randomize(geneticSpecs);

        double mark = simpleMeasureAnalyzer.analyzeIntervals(simpleMeasure, 10D);
        assert mark >= 0 && mark <= 1;
    }

    @RepeatedTest(50)
    public void analyze() {
        SimpleMeasure simpleMeasure = new SimpleMeasure(Instrumentos.VIOLIN);
        simpleMeasure.staff().randomize(geneticSpecs);

        double mark = simpleMeasureAnalyzer.analyze(simpleMeasure);
        assert mark >= 0 && mark <= 1;
    }

}