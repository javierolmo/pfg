package com.javi.uned.pfgcomposergenetic.adapters.kafka.consumers;

import com.javi.uned.pfgcommons.config.KafkaTopics;
import com.javi.uned.pfgcomposergenetic.adapters.kafka.producers.FileProducer;
import com.javi.uned.pfgcomposergenetic.domain.services.ConverterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class RetryXMLConsumer {

    private final Logger logger = LoggerFactory.getLogger(RetryXMLConsumer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private FileProducer fileProducer;
    @Autowired
    private ConverterService converterService;

    @KafkaListener(topics = KafkaTopics.COMPOSER_GENETIC_RETRYXML, groupId = "0", containerFactory = "geneticSpecsKafkaListenerFactory")
    public void consume(/*Specs specs, */@Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key) {
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


    /*
    private ScoreComposite componer(Specs specs, String key) {
        kafkaTemplate.send(TOPIC_COMPOSER_EXECUTION, key, "Componiendo");
        return ScoreBuilder.getInstance().buildScore(specs);
    }


    private File generarXML(ScoreComposite scoreComposite, String key) throws SpecsConsumerException {
        try{
            kafkaTemplate.send(TOPIC_COMPOSER_EXECUTION, key, "Generando fichero .musicxml");
            File xmlFile = new File(key+".musicxml");
            Export.toXML(scoreComposite, xmlFile);
            fileProducer.sendXML(key, xmlFile);
            return xmlFile;
        } catch (IOException | ExportException e) {
            throw new SpecsConsumerException("SpecsConsumer.generarXML: Error al generar XML", e);
        }
    }

    private File generarPDF(File xmlFile, String key) throws SpecsConsumerException {
        try{
            if(!xmlFile.exists()) throw new SpecsConsumerException("SpecsConsumer.generarPDF: No se ha podido crear el PDF. No existe el archivo " + xmlFile.getAbsolutePath());
            kafkaTemplate.send(TOPIC_COMPOSER_EXECUTION, key, "Generando fichero .pdf");
            File pdfFile = converterService.xmlToPdf(xmlFile, key + ".pdf");
            fileProducer.sendPDF(key, pdfFile);
            return pdfFile;
        } catch (IOException | ConverterException e) {
            throw new SpecsConsumerException("SpecsConsumer.generarPDF: error al guardar PDF", e);
        }
    }
     */

}
