package com.javi.uned.pfgcomposergenetic.adapters.kafka.consumers;

import com.javi.uned.pfgcommons.config.KafkaTopics;
import com.javi.uned.pfgcommons.model.specs.GeneticSpecs;
import com.javi.uned.pfgcomposergenetic.adapters.kafka.producers.FileProducer;
import com.javi.uned.pfgcomposergenetic.domain.exceptions.ConverterException;
import com.javi.uned.pfgcomposergenetic.domain.exceptions.SpecsConsumerException;
import com.javi.uned.pfgcomposergenetic.domain.services.ConverterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class SpecsConsumer {

    private final Logger logger = LoggerFactory.getLogger(SpecsConsumer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private FileProducer fileProducer;
    @Autowired
    private ConverterService converterService;

    @KafkaListener(topics = KafkaTopics.COMPOSER_GENETIC_SPECS, groupId = "0", containerFactory = "geneticSpecsKafkaListenerFactory")
    public void consume(GeneticSpecs specs, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key) {
        /*
        File xmlFile = null;
        File pdfFile = null;
        try{
            ScoreComposite scoreComposite = componer(specs, key);
            xmlFile = generarXML(scoreComposite, key);
            pdfFile = generarPDF(xmlFile, key);
            kafkaTemplate.send(TOPIC_COMPOSER_EXECUTION, key, "Terminado!");
            logger.info("Composición finalizada. ID={}", key);
        } catch (SpecsConsumerException e) {
            logger.error("SpecsConsumer.consume: Error al generar partitura", e);
            kafkaTemplate.send(TOPIC_COMPOSER_EXECUTION, key, e.getMessage());
        } finally { // Clean up
            try {
                if (xmlFile != null && xmlFile.exists()) Files.delete(xmlFile.toPath());
                if (pdfFile != null && pdfFile.exists()) Files.delete(pdfFile.toPath());
            } catch (IOException ioe) {
                logger.warn("No se ha podido borrar un archivo temporal", ioe);
            }
        }
         */
    }


    private File generarXML(/*ScoreComposite scoreComposite, */String key) throws SpecsConsumerException {
        /*
        try{
            kafkaTemplate.send(TOPIC_COMPOSER_EXECUTION, key, "Generando fichero .musicxml");
            File xmlFile = new File(key+".musicxml");
            Export.toXML(scoreComposite, xmlFile);
            fileProducer.sendXML(key, xmlFile);
            return xmlFile;
        } catch (ExportException | IOException e) {
            throw new SpecsConsumerException("SpecsConsumer.generarXML: Error al generar XML", e);
        }
         */
        return null;
    }

    private File generarPDF(File xmlFile, String key) throws SpecsConsumerException {
        try{
            if(!xmlFile.exists()) throw new SpecsConsumerException("SpecsConsumer.generarPDF: No se ha podido crear el PDF. No existe el archivo " + xmlFile.getAbsolutePath());
            File pdfFile = converterService.xmlToPdf(xmlFile, key + ".pdf");
            fileProducer.sendPDF(key, pdfFile);
            return pdfFile;
        } catch (IOException | ConverterException e) {
            throw new SpecsConsumerException("SpecsConsumer.generarPDF: error al generar PDF", e);
        }
    }




}
