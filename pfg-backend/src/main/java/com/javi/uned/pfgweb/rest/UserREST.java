package com.javi.uned.pfgweb.rest;

import com.javi.uned.pfg.model.Instrumento;
import com.javi.uned.pfg.model.Specs;
import com.javi.uned.pfgweb.beans.Sheet;
import com.javi.uned.pfgweb.beans.User;
import com.javi.uned.pfgweb.repositories.SheetRepository;
import com.javi.uned.pfgweb.repositories.UserRepository;
import com.javi.uned.pfgweb.services.CustomUserDetailsService;
import com.javi.uned.pfgweb.services.UserService;
import com.javi.uned.pfgweb.services.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserREST {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SheetRepository sheetRepository;
    @Autowired
    private KafkaTemplate<String, Specs> specsTemplate;
    @Autowired
    private UtilService utilService;

    @GetMapping("/{id}/details")
    public User getDetails(@PathVariable long id){
        return userRepository.findById(id).get();
    }

    @PostMapping("/{userId}/request")
    public Sheet composeSheet(@RequestBody Specs specs, @PathVariable Long userId){

        //Create new sheet
        Sheet sheet = new Sheet();
        sheet.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        sheet.setOwnerId(userId);
        sheet.setName(specs.getMovementTitle());
        sheet.setFinished(false);

        //Save in database
        sheetRepository.save(sheet);

        //Complete instruments info
        Instrumento[] instrumentosIncompletos = specs.getInstrumentos();
        List<Instrumento> instrumentosCompletos = new ArrayList<>();
        for(Instrumento instrumentoIncompleto: instrumentosIncompletos){
            instrumentosCompletos.add(utilService.completarInstrumento(instrumentoIncompleto));
        }
        specs.setInstrumentos(instrumentosCompletos.toArray(new Instrumento[]{}));

        //Order composition request
        String sheetid = ""+sheet.getId();
        specsTemplate.send("melodia.backend.specs", sheetid, specs);

        return sheet;
    }


}
