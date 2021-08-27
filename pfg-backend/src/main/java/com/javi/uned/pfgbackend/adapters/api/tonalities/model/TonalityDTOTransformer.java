package com.javi.uned.pfgbackend.adapters.api.tonalities.model;

import com.javi.uned.pfgcommons.model.Tonalidad;
import com.javi.uned.pfgcommons.model.constants.Tonalidades;

public class TonalityDTOTransformer {

    private TonalityDTOTransformer() {
    }

    public static Tonalidad toDomainObject(TonalityDTO tonalityDTO) {
        return Tonalidades.byId(tonalityDTO.getId());
    }

    public static TonalityDTO toTransferObject(Tonalidad tonalidad) {
        TonalityDTO tonalityDTO = new TonalityDTO();
        tonalityDTO.setId(tonalidad.getId());
        tonalityDTO.setMayor(tonalidad.isMayor());
        tonalityDTO.setAlteraciones(tonalidad.getAlteraciones());
        tonalityDTO.setAmericanName(tonalidad.getAmericanName());
        tonalityDTO.setTraditionalName(tonalidad.getTraditionalName());
        return tonalityDTO;
    }
}
