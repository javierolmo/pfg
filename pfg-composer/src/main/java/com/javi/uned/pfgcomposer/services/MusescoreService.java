package com.javi.uned.pfgcomposer.services;

import com.javi.uned.pfgcomposer.exceptions.MusescoreException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class MusescoreService {

    private final Logger LOGGER = LoggerFactory.getLogger(MusescoreService.class);
    private String musescoreName;

    public MusescoreService() {
        try {
            this.musescoreName = getMusescoreName();
            LOGGER.info("Localizada instalación de MuseScore: "+this.musescoreName);
        } catch (Exception e) {
            throw new BeanInitializationException("Error al inicializar MusescoreService: ", e);
        }

    }

    private String getMusescoreName() throws IOException, InterruptedException {
        String[] possibleNames = new String[]{"mscore", "mscore3"};
        for (String possibleName : possibleNames) {
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command("sh", "-c", "command -v "+possibleName);
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
            if(exitCode == 0) return possibleName;
        }
        throw new FileNotFoundException("No se ha encontrado una instalación válida de Musescore");
    }

    public File convertXMLToPDF(File xmlFile, File pdfFile) throws MusescoreException {
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command("sh", "-c", String.format("musescore3 %s -o %s", xmlFile.getAbsolutePath(), pdfFile.getAbsolutePath()));
            Process process = builder.start();
            int exitCode = process.waitFor();
            if (exitCode != 0) throw new MusescoreException("Error al convertir el archivo "+xmlFile.getName());
            return pdfFile;
        } catch (InterruptedException | IOException e) {
            throw new MusescoreException("Error al convertir el archivo "+xmlFile.getName(), e);
        }
    }
}
