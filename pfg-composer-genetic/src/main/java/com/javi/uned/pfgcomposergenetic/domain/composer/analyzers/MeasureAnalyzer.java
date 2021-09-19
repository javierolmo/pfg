package com.javi.uned.pfgcomposergenetic.domain.composer.analyzers;

import com.javi.uned.pfgcommons.model.measures.MelodiaMeasure;

public interface MeasureAnalyzer {

    /**
     * Analyze a measure according to analyzer properties and give back a value between [0-1]
     * @param measure measure to be analyzed
     * @return value between [0-1]
     */
    double analyze(MelodiaMeasure measure);

}
