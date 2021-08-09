package com.javi.uned.pfgcommons.composer.analyzers.configs;

import java.io.Serializable;

public class SimpleMeasureAnalyzerConfig implements Serializable {

    public final ConfigValue<Double> INTERVAL_STANDARD_DEVIATION = new ConfigValue<>(3D, 80);

    public final ConfigValue<Double> HARMONY_ACCURACY = new ConfigValue<>(3D, 80);

}
