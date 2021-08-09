package com.javi.uned.pfgcommons.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javi.uned.pfgcommons.model.constants.Tesituras;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TesituraTest {

    private Tesitura tesitura = Tesituras.PIANO_MANO_DERECHA;
    private ObjectMapper objectMapper;


    @BeforeAll
    public void setupObjectMapper(){
        objectMapper = new ObjectMapper();
    }

    @Test
    void checkSerializable() throws JsonProcessingException {
        String serialized = objectMapper.writeValueAsString(tesitura);
        System.out.println(serialized);
        Tesitura deserialized = objectMapper.readValue(serialized, Tesitura.class);
        assert tesitura.equals(deserialized);
    }

    @Test
    void checkSemitonosTesitura() {
        // TODO:
    }

}