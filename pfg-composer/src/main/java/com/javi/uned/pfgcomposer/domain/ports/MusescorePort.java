package com.javi.uned.pfgcomposer.domain.ports;

import com.javi.uned.pfgcomposer.domain.exceptions.MusescoreException;

import java.io.File;

public interface MusescorePort {

    File convertXMLToPDF(File xmlFile, String pdfPath) throws MusescoreException;

    File convertXMLToMIDI(File xmlFile, String midiPath) throws MusescoreException;

}
