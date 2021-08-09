package com.javi.uned.pfgcommons.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javi.uned.pfgcommons.model.constants.Compases;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CompasTest {

    private Compas compas = Compases.COMPAS_4x4;
    private ObjectMapper objectMapper;


    @BeforeAll
    public void setupObjectMapper(){
        objectMapper = new ObjectMapper();
    }

    @Test
    void checkSerializable() throws JsonProcessingException {
        String serialized = objectMapper.writeValueAsString(compas);
        System.out.println(serialized);
        Compas deserialized = objectMapper.readValue(serialized, Compas.class);
        assertEquals(compas, deserialized);
    }

}