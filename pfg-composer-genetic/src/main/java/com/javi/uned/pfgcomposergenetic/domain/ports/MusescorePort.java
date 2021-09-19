package com.javi.uned.pfgcomposergenetic.domain.ports;

import com.javi.uned.pfgcomposergenetic.domain.exceptions.MusescoreException;

import java.io.File;

public interface MusescorePort {

    File convertXMLToPDF(File xmlFile, String pdfPath) throws MusescoreException;

    File convertXMLToMIDI(File xmlFile, String midiPath) throws MusescoreException;

}
