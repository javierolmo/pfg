package com.javi.uned.pfgbackend.domain.ports.messagebroker;

import com.javi.uned.pfg.model.Specs;
import com.javi.uned.pfgbackend.domain.exceptions.MelodiaIOException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface MessageBrokerService {

    //TODO: Estos topics estarían mejor al revés, el nombre debería ser el destino
    String PRODUCE_COMPOSER_GENETIC_SPECS = "melodia.backend.specs";
    String CONSUME_COMPOSER_GENETIC_PDF = "melodia.composer.pdf";
    String CONSUME_COMPOSER_GENETIC_XML = "melodia.composer.xml";

    String PRODUCE_COMPOSER_NEURALNETWORK_TRAINELEMENT = "melodia.composer.neural-network.train.input";

    void composerGeneticsProduceSpecs(Specs specs, String sheetId);

    void consumePDF(byte[] rawFile, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key) throws IOException;

    void consumeXML(byte[] rawFile, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key) throws IOException;

    void composerGeneticProducePDFRetry(long sheetid, File xml) throws MelodiaIOException;

    void composerNeuralNetworkProduceTrainElement(MultipartFile file) throws MelodiaIOException;
}
