package com.javi.uned.pfgcommons.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javi.uned.pfgcommons.model.constants.Tonalidades;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.util.Arrays;
import java.util.stream.Collectors;

@TestInstance(Lifecycle.PER_CLASS)
class TonalidadTest {

    private Tonalidad tonalidad = Tonalidades.DO_M;
    private ObjectMapper objectMapper;


    @BeforeAll
    void setupObjectMapper(){
        objectMapper = new ObjectMapper();
    }

    @Test
    void checkSerializable() throws JsonProcessingException {
        String serialized = objectMapper.writeValueAsString(tonalidad);
        System.out.println(serialized);
        Tonalidad deserialized = objectMapper.readValue(serialized, Tonalidad.class);
        Assertions.assertEquals(tonalidad, deserialized);
    }

    @Test
    void checkNames() {
        for (Tonalidad tonalidade : Tonalidades.getTonalidades()) {
            System.out.println(String.format("%15s | %15s", tonalidade.getAmericanName(), tonalidade.getTraditionalName()));
        }
    }

    @Test
    void construirEscalas() {
        for (Tonalidad tonalidad : Tonalidades.getTonalidades()) {
            System.out.println(new StringBuilder()
                .append(tonalidad.getTraditionalName())
                .append(" - ")
                .append(Arrays.stream(tonalidad.getScale()).map(pitch -> pitch.toString()).collect(Collectors.joining(", ")))
            );
        }
    }

    @Test
    void getAlteraciones() {
        assert Tonalidades.DO_M.getAlteraciones() == 0;
        assert Tonalidades.LA_m.getAlteraciones() == 0;
        assert Tonalidades.SOL_M.getAlteraciones() == 1;
        assert Tonalidades.MI_m.getAlteraciones() == 1;
        assert Tonalidades.RE_M.getAlteraciones() == 2;
        assert Tonalidades.SI_m.getAlteraciones() == 2;
        assert Tonalidades.LA_M.getAlteraciones() == 3;
        assert Tonalidades.FA_S_m.getAlteraciones() == 3;
        assert Tonalidades.MI_M.getAlteraciones() == 4;
        assert Tonalidades.DO_S_m.getAlteraciones() == 4;
        assert Tonalidades.SI_M.getAlteraciones() == 5;
        assert Tonalidades.SOL_S_m.getAlteraciones() == 5;
        assert Tonalidades.FA_S_M.getAlteraciones() == 6;
        assert Tonalidades.SOL_B_M.getAlteraciones() == -6;
        assert Tonalidades.RE_S_m.getAlteraciones() == 6;
        assert Tonalidades.MI_B_m.getAlteraciones() == -6;
        assert Tonalidades.RE_B_M.getAlteraciones() == -5;
        assert Tonalidades.SI_B_m.getAlteraciones() == -5;
        assert Tonalidades.LA_B_M.getAlteraciones() == -4;
        assert Tonalidades.FA_m.getAlteraciones() == -4;
        assert Tonalidades.MI_B_M.getAlteraciones() == -3;
        assert Tonalidades.DO_m.getAlteraciones() == -3;
        assert Tonalidades.SI_B_M.getAlteraciones() == -2;
        assert Tonalidades.SOL_m.getAlteraciones() == -2;
        assert Tonalidades.FA_M.getAlteraciones() == -1;
        assert Tonalidades.RE_m.getAlteraciones() == -1;
    }


}