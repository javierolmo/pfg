package com.javi.uned.pfgcomposer.domain.services;

import com.javi.uned.pfgcomposer.domain.exceptions.ConverterException;
import org.jfugue.midi.MidiFileManager;
import org.jfugue.midi.MidiParserListener;
import org.jfugue.pattern.Pattern;
import org.jfugue.theory.ChordProgression;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.staccato.StaccatoParser;

import java.io.File;
import java.io.IOException;

@SpringBootTest
class ConverterServiceTest {

    @Autowired
    private ConverterService converterService;

    @Test
    public void xmlToMidi() throws ConverterException {
        File xmlFile = new File(getClass().getClassLoader().getResource("musicxml_examples/BeetAnGeSample.musicxml").getFile());
        File midiFile = converterService.xmlToMidi(xmlFile, "testmidi.midi");
        System.out.println(midiFile.getAbsolutePath());
    }

    @Test
    public void midiToXml() throws ConverterException, IOException {
        Pattern pattern = new ChordProgression("I IV V")
                .distribute("7%6")
                .allChordsAs("$0 $0 $0 $0 $1 $1 $0 $0 $2 $1 $0 $0")
                .eachChordAs("$0ia100 $1ia80 $2ia80 $3ia80 $4ia100 $3ia80 $2ia80 $1ia80")
                .getPattern()
                .setInstrument("Acoustic_Bass")
                .setTempo(100)
                .setLayer(0);

        Pattern pattern2 = new ChordProgression("I IV V")
                .distribute("7%6")
                .allChordsAs("$0 $0 $0 $0 $1 $1 $0 $0 $2 $1 $0 $0")
                .eachChordAs("$0ia100 $1ia80 $2ia80 $3ia80 $4ia100 $3ia80 $2ia80 $1ia80")
                .getPattern()
                .setInstrument("Acoustic_Bass")
                .setTempo(100)
                .setLayer(1);

        MidiParserListener midiParserListener = new MidiParserListener();

        StaccatoParser staccatoParser = new StaccatoParser();
        staccatoParser.addParserListener(midiParserListener);
        staccatoParser.parse(pattern);

        File midi = new File("testmidi.midi");
        MidiFileManager.save(midiParserListener.getSequence(), midi);

        converterService.midiToXml(midi, "testmidixml.musicxml");

    }

}