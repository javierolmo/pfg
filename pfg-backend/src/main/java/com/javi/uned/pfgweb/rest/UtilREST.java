package com.javi.uned.pfgweb.rest;

import com.javi.uned.pfg.model.Compas;
import com.javi.uned.pfg.model.Instrumento;
import com.javi.uned.pfg.model.Tonalidad;
import com.javi.uned.pfg.model.constants.Compases;
import com.javi.uned.pfg.model.constants.Instrumentos;
import com.javi.uned.pfg.model.constants.Tonalidades;
import com.javi.uned.pfgweb.services.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/util")
@Api(tags = "Util")
public class UtilREST {

    @Autowired
    private UserService userService;

    @GetMapping("available-instruments")
    public Instrumento[] getAvailableInstruments() {
        return Instrumentos.getInstrumentos();
    }

    @GetMapping("available-measures")
    public Compas[] getAvailableMeasures() {
        return Compases.getCompases();
    }

    @GetMapping("available-tonalities")
    public Tonalidad[] getAvailableTonality() {
        return Tonalidades.getTonalidades();
    }

}
