package com.javi.uned.pfgweb.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FileSystemConfig {

    public static final String DATA_FOLDER_PATH = "data";
    private final Logger logger = LoggerFactory.getLogger(FileSystemConfig.class);

    private final File dataFolder = new File(DATA_FOLDER_PATH);

    private FileSystemConfig () {
        if(dataFolder.isDirectory()) {
            logger.info("Utilizando sistema de archivos ya existente: {}", dataFolder.getAbsolutePath());
        } else {
            dataFolder.mkdirs();
            logger.warn("No se ha encontrado una estructura de ficheros previa. Se ha inicializado una nueva: {}", dataFolder.getAbsolutePath());
        }
    }
}
