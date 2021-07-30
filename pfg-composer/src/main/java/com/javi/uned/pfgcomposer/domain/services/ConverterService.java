package com.javi.uned.pfgcomposer.domain.services;

import com.javi.uned.pfgcomposer.domain.exceptions.ConverterException;
import com.javi.uned.pfgcomposer.domain.exceptions.MusescoreException;
import com.javi.uned.pfgcomposer.domain.ports.MusescorePort;
import nu.xom.ParsingException;
import org.jfugue.integration.MusicXmlParser;
import org.jfugue.midi.MidiFileManager;
import org.jfugue.midi.MidiParserListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

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
        try {
            MidiParserListener midiParserListener = new MidiParserListener();
            MusicXmlParser parser = new MusicXmlParser();
            parser.addParserListener(midiParserListener);
            parser.parse(xml);
            File result = new File(midiPath);
            MidiFileManager.save(midiParserListener.getSequence(), result);
            return result;
        } catch (ParserConfigurationException | ParsingException | IOException e) {
            String message = "Error trying to parse musicxml '" + xml.getAbsolutePath() + "' to midi '" + midiPath + "'";
            logger.error(message);
            throw new ConverterException(message, e);
        }
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
