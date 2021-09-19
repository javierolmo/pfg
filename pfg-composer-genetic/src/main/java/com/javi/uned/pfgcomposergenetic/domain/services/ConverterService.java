package com.javi.uned.pfgcomposergenetic.domain.services;

import com.javi.uned.pfgcomposergenetic.domain.exceptions.ConverterException;
import com.javi.uned.pfgcomposergenetic.domain.exceptions.MusescoreException;
import com.javi.uned.pfgcomposergenetic.domain.ports.MusescorePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class ConverterService {

    private final Logger logger = LoggerFactory.getLogger(ConverterService.class);

    @Autowired
    private MusescorePort musescorePort;

    public File xmlToPdf(File xml, String pdfPath) throws ConverterException {
        try {
            return musescorePort.convertXMLToPDF(xml, pdfPath);
        } catch (MusescoreException e) {
            String message = "Could not convert musicml file '" + xml.getAbsolutePath() + "' to pdf '" + pdfPath + "'";
            logger.error(message);
            throw new ConverterException(message, e);
        }
    }

    public File xmlToMidi(File xml, String midiPath) throws ConverterException {
        //TODO:
        throw new ConverterException("Not implemented!");
    }

    public File midiToXml(File midi, String xmlPath) throws ConverterException {
        try {
            return musescorePort.convertXMLToMIDI(midi, xmlPath);
        } catch (MusescoreException e) {
            String message = "Could not convert musicml file '" + midi.getAbsolutePath() + "' to pdf '" + xmlPath + "'";
            logger.error(message);
            throw new ConverterException(message, e);
        }
    }

}
