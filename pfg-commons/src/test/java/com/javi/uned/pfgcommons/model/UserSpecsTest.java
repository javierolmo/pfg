package com.javi.uned.pfgcommons.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javi.uned.pfgcommons.model.constants.Compases;
import com.javi.uned.pfgcommons.model.constants.Instrumentos;
import com.javi.uned.pfgcommons.model.constants.Tonalidades;
import com.javi.uned.pfgcommons.model.specs.GeneticSpecs;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserSpecsTest {

    private GeneticSpecs geneticSpecs;
    private ObjectMapper objectMapper;

    @BeforeAll
    public void setupSpecs(){
        geneticSpecs = new GeneticSpecs();
        geneticSpecs.setMovementTitle("Título");
        geneticSpecs.setMovementNumber("1");
        geneticSpecs.setMeasures(30);
        geneticSpecs.setInstrumentos(new Instrumento[]{Instrumentos.PIANO});
        geneticSpecs.setCompas(Compases.COMPAS_4x4);
        geneticSpecs.setAuthors(new String[]{"Javier Olmo Injerto"});
        geneticSpecs.setTonalidad(Tonalidades.DO_M);
    }

    @BeforeAll
    public void setupObjectMapper(){
        objectMapper = new ObjectMapper();
    }

    @Test
    void checkSerializable() throws JsonProcessingException {
        String serialized = objectMapper.writeValueAsString(geneticSpecs);
        System.out.println(serialized);
        GeneticSpecs deserialized = objectMapper.readValue(serialized, GeneticSpecs.class);
        assertEquals(geneticSpecs, deserialized);
    }

}