package com.javi.uned.pfgcommons.config;

public class KafkaTopics {

    // Genetic composer topics
    public static final String COMPOSER_GENETIC_SPECS = "melodia.composer.genetic.specs";
    public static final String COMPOSER_GENETIC_LOGS = "melodia.composer.genetic.logs";
    public static final String COMPOSER_GENETIC_RETRYPDF = "melodia.composer.genetic.retry-pdf";
    public static final String COMPOSER_GENETIC_RETRYXML = "melodia.composer.genetic.retry-xml";

    // Neural network composer topics
    public static final String COMPOSER_NEURALNETWORK_SPECS = "melodia.composer.neural-network.specs";
    public static final String COMPOSER_NEURALNETWORK_LOGS = "melodia.composer.neural-network.logs";

    // Backend topics
    public static final String BACKEND_STORE_PDF = "melodia.backend.input.pdf";
    public static final String BACKEND_STORE_XML = "melodia.backend.input.xml";
    public static final String BACKEND_LOGS = "melodia.backend.logs";

}
