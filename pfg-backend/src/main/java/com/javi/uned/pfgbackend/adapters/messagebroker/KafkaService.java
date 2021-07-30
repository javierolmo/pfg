package com.javi.uned.pfgbackend.adapters.messagebroker;

import com.javi.uned.pfg.model.Specs;
import com.javi.uned.pfgbackend.adapters.filesystem.FileService;
import com.javi.uned.pfgbackend.domain.enums.Formats;
import com.javi.uned.pfgbackend.domain.exceptions.MelodiaIOException;
import com.javi.uned.pfgbackend.domain.ports.messagebroker.MessageBrokerService;
import com.javi.uned.pfgbackend.domain.sheet.SheetService;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class KafkaService implements MessageBrokerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaService.class);

    @Autowired
    private KafkaTemplate<String, Specs> specsTemplate;
    @Autowired
    private KafkaTemplate<String, byte[]> byteArrayTemplate;
    @Autowired
    private FileService fileService;
    @Autowired
    private SheetService sheetService;


    public void composerGeneticsProduceSpecs(Specs specs, String sheetId) {
        specsTemplate.send(PRODUCE_COMPOSER_GENETIC_SPECS, sheetId, specs);
    }

    @KafkaListener(topics = CONSUME_COMPOSER_GENETIC_PDF, groupId = "0", containerFactory = "fileListenerFactory")
    public void consumePDF(byte[] rawFile, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key) throws IOException {

        long keyLong = Long.parseLong(key);

        // Receive and save pdf
        File dir = fileService.getSheetFolder(Long.parseLong(key));
        File pdfFile = new File(String.format("%s/%s%s", dir.getAbsolutePath(), key, Formats.PDF));
        FileUtils.writeByteArrayToFile(pdfFile, rawFile);

        // Mark as finished
        if (fileService.hasPDF(keyLong) && fileService.hasXML(keyLong)) {
            int id = Integer.parseInt(key);
            sheetService.markAsFinished(id);
        }
    }

    @KafkaListener(topics = CONSUME_COMPOSER_GENETIC_XML, groupId = "0", containerFactory = "fileListenerFactory")
    public void consumeXML(byte[] rawFile, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key) throws IOException {

        long keyLong = Long.parseLong(key);

        // Receive and save xml
        File dir = fileService.getSheetFolder(keyLong);
        File musicxmlFile = new File(String.format("%s/%s%s", dir.getAbsolutePath(), key, Formats.MUSICXML));
        FileUtils.writeByteArrayToFile(musicxmlFile, rawFile);

        // Mark as finished
        if (fileService.hasPDF(keyLong) && fileService.hasXML(keyLong)) {
            int id = Integer.parseInt(key);
            sheetService.markAsFinished(id);
        }
    }

    public void composerGeneticProducePDFRetry(long sheetid, File xml) throws MelodiaIOException {
        try {
            byte[] xmlbinary = FileUtils.readFileToByteArray(xml);
            String sheetIdString = "" + sheetid;
            byteArrayTemplate.send("melodia.backend.retrypdf", sheetIdString, xmlbinary);
        } catch (IOException e) {
            throw new MelodiaIOException("Could not read xml file '" + xml.getAbsolutePath() + "'");
        }
    }

    public void composerNeuralNetworkProduceTrainElement(MultipartFile file) throws MelodiaIOException {
        try {
            byte[] xmlbinary = file.getBytes();
            byteArrayTemplate.send(PRODUCE_COMPOSER_NEURALNETWORK_TRAINELEMENT, xmlbinary);
        } catch (IOException e) {
            throw new MelodiaIOException("Could not read xml file '" + file.getName() + "'");
        }
    }

}
