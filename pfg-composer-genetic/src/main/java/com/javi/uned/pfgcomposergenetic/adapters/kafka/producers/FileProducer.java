package com.javi.uned.pfgcomposergenetic.adapters.kafka.producers;

import com.javi.uned.pfgcommons.config.KafkaTopics;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
@Deprecated
public class FileProducer {

    @Autowired
    private KafkaTemplate<String, byte[]> kafkaTemplate;

    public void sendXML(String key, File xmlFile) throws IOException {
        byte[] rawFile = FileUtils.readFileToByteArray(xmlFile);
        kafkaTemplate.send(KafkaTopics.BACKEND_STORE_XML, key, rawFile);
    }

    public void sendPDF(String key, File pdfFile) throws IOException {
        byte[] rawFile = FileUtils.readFileToByteArray(pdfFile);
        kafkaTemplate.send(KafkaTopics.BACKEND_STORE_PDF, key, rawFile);
    }



}
