package com.javi.uned.pfgbackend.adapters.api.composer.neuralnetwork;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface NeuralNetworkController {

    @PostMapping(value = "/api/composer/neural-network/train")
    ResponseEntity<String> trainNeuralNetwork(@RequestParam("file") MultipartFile xmlSheet);

}
