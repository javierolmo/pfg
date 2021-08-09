package com.javi.uned.pfgcommons.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javi.uned.pfgcommons.model.constants.Figuras;
import com.javi.uned.pfgcommons.model.constants.MelodiaAbsolutePitches;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MelodiaNoteTest {

    private MelodiaNote melodiaNote;
    private ObjectMapper objectMapper;

    @BeforeAll
    public void setupNoteComposite(){
        melodiaNote = new MelodiaNote(MelodiaAbsolutePitches.C4, Figuras.NEGRA);
    }

    @BeforeAll
    public void setupObjectMapper(){
        objectMapper = new ObjectMapper();
    }

    @Test
    void checkSerializable() throws JsonProcessingException {
        String serialized = objectMapper.writeValueAsString(melodiaNote);
        System.out.println(serialized);
        MelodiaNote deserialized = objectMapper.readValue(serialized, MelodiaNote.class);
        assert melodiaNote.equals(deserialized);
    }

}