package com.javi.uned.pfgcommons.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javi.uned.pfgcommons.model.constants.Figuras;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FiguraTest {

    private Figura figura = Figuras.NEGRA;
    private ObjectMapper objectMapper;


    @BeforeAll
    public void setupObjectMapper(){
        objectMapper = new ObjectMapper();
    }

    @Test
    void checkSerializable() throws JsonProcessingException {
        String serialized = objectMapper.writeValueAsString(figura);
        System.out.println(serialized);
        Figura deserialized = objectMapper.readValue(serialized, Figura.class);
        assertEquals(figura.getValue(), deserialized.getValue());
        assertEquals(figura.getType(), deserialized.getType());
        assertEquals(figura.getDuration(), deserialized.getDuration(), 0D);
        assert figura.equals(deserialized);
    }

}