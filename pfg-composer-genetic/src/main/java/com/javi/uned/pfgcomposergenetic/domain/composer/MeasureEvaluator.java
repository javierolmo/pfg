package com.javi.uned.pfgcomposergenetic.domain.composer;

import io.jenetics.Gene;
import io.jenetics.Genotype;

public interface MeasureEvaluator<G extends Gene<?, G>> {

    Double evaluate(Genotype<G> genotype);

}
