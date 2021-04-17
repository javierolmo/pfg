package com.javi.uned.pfgcomposer.consumers;

import com.javi.uned.pfg.ScoreBuilder;
import com.javi.uned.pfg.io.Export;
import com.javi.uned.pfg.model.ScoreComposite;
import com.javi.uned.pfg.model.Specs;
import com.javi.uned.pfgcomposer.services.BackendService;
import com.javi.uned.pfgcomposer.services.MusescoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class SpecsConsumer {

    private final Logger LOGGER = LoggerFactory.getLogger(SpecsConsumer.class);
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private BackendService backendService;
    @Autowired
    private MusescoreService musescoreService;

    @KafkaListener(topics = "melodia.backend.specs", groupId = "0", containerFactory = "specsKafkaListenerFactory")
    public void consume(Specs specs, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key) throws Exception {
        kafkaTemplate.send("melodia.composer.execution", key, "Componiendo");
        ScoreComposite scoreComposite = ScoreBuilder.getInstance().buildScore(specs);
        kafkaTemplate.send("melodia.composer.execution", key, "Generando fichero .musicxml");
        File xmlFile = new File(key+".musicxml");
        Export.toXML(scoreComposite.toScorePartwise(), xmlFile);
        kafkaTemplate.send("melodia.composer.execution", key, "Generando fichero .pdf");
        File pdfFile = new File(key+".pdf");
        musescoreService.convertXMLToPDF(xmlFile, pdfFile);
        kafkaTemplate.send("melodia.composer.execution", key, "Publicando partitura");
        backendService.storeSheetXML(xmlFile, key);
        backendService.storeSheetPDF(pdfFile, key);
        kafkaTemplate.send("melodia.composer.execution", key, "Borrando archivos temporales");
        xmlFile.delete();
        pdfFile.delete();
        kafkaTemplate.send("melodia.composer.execution", key, "Terminado!");
        LOGGER.info("Composición finalizada. ID="+key);
    }


}
