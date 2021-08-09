package com.javi.uned.pfgcommons.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javi.uned.pfgcommons.model.constants.Claves;
import com.javi.uned.pfgcommons.model.constants.Tesituras;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ScopeTest {

    private Scope scope;
    private ObjectMapper objectMapper;


    @BeforeAll
    public void setupObjectMapper(){
        objectMapper = new ObjectMapper();
    }

    @BeforeAll
    public void setupScope(){
        scope = new Scope();
        scope.setClave(Claves.SOL2);
        scope.setTesitura(Tesituras.PIANO_MANO_DERECHA);
    }

    @Test
    void checkSerializable() throws JsonProcessingException {
        String serialized = objectMapper.writeValueAsString(scope);
        System.out.println(serialized);
        Scope deserialized = objectMapper.readValue(serialized, Scope.class);
        assert scope.equals(deserialized);
    }

}