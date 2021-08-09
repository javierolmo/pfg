package com.javi.uned.pfgbackend.adapters.api.tonalities;

import com.javi.uned.pfgcommons.model.Tonalidad;
import com.javi.uned.pfgcommons.model.constants.Tonalidades;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@Api(tags = "Tonality")
public class TonalityControllerImpl implements TonalityController {

    public Tonalidad[] getAvailableTonality() {
        return Tonalidades.getTonalidades();
    }

}
