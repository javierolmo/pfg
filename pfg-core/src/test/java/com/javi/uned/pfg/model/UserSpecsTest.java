package com.javi.uned.pfg.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javi.uned.pfg.model.constants.Compases;
import com.javi.uned.pfg.model.constants.Instrumentos;
import com.javi.uned.pfg.model.constants.Tonalidades;
import com.javi.uned.pfg.model.specs.UserSpecs;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserSpecsTest {

    private UserSpecs userSpecs;
    private ObjectMapper objectMapper;

    @BeforeAll
    public void setupSpecs(){
        userSpecs = new UserSpecs();
        userSpecs.setMovementTitle("Título");
        userSpecs.setMovementNumber("1");
        userSpecs.setMeasures(30);
        userSpecs.setInstrumentos(new Instrumento[]{Instrumentos.PIANO});
        userSpecs.setCompas(Compases.COMPAS_4x4);
        userSpecs.setAuthors(Arrays.asList("Javier Olmo Injerto"));
        userSpecs.setTonalidad(Tonalidades.DO_M);
    }

    @BeforeAll
    public void setupObjectMapper(){
        objectMapper = new ObjectMapper();
    }

    @Test
    void checkSerializable() throws JsonProcessingException {
        String serialized = objectMapper.writeValueAsString(userSpecs);
        System.out.println(serialized);
        UserSpecs deserialized = objectMapper.readValue(serialized, UserSpecs.class);
        assertEquals(userSpecs, deserialized);
    }

}