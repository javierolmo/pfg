package com.javi.uned.pfgweb.rest;

import com.javi.uned.pfgweb.beans.Sheet;
import com.javi.uned.pfgweb.repositories.SheetRepository;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/sheets")
public class SheetREST {

    @Autowired
    private SheetRepository sheetRepository;

    @GetMapping("/pages")
    public Page<Sheet> getSheets(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "50") int size,
            @RequestParam(required = false, defaultValue = "") String text
    ){
        text = ".*"+text+".*";
        return sheetRepository.find(text, PageRequest.of(page, size));
    }

    @GetMapping
    public List<Sheet> getSheets(
            @RequestParam(required = false) String nameContains,
            @RequestParam(required = false) Boolean finished,
            @RequestParam(required = false) Long ownerId,
            @RequestParam(required = false) Integer id
    ){
        Sheet sheet = new Sheet();
        sheet.setFinished(finished);
        sheet.setName(nameContains);
        sheet.setOwnerId(ownerId);
        sheet.setId(id);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", matcher1 -> matcher1.contains());
        Example<Sheet> sheetExample = Example.of(sheet, matcher);
        return sheetRepository.findAll(sheetExample);
    }

    @PostMapping
    public Sheet createSheet(@RequestBody Sheet sheet){
        return sheetRepository.save(sheet);
    }

    @GetMapping("/{id}")
    public Sheet sheet(@PathVariable Integer id) {
        return sheetRepository.findById(id).get();
    }

    /**
     * Elimina la partitura seleccionada del sistema de archivos y de la base de datos.
     * @param id identificador de la partitura a eliminar
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteSheet(@PathVariable int id) throws IOException {
        sheetRepository.deleteById(id);
        File file = new File(String.format("sheets/%d", id));
        FileUtils.forceDelete(file);
        return ResponseEntity.ok("Partitura eliminada con éxito");
    }

    /**
     * Guarda una partitura en la carpeta 'sheets', renombrando el archivo y modificando la ruta y el estado en la base
     * de datos.
     * @param file partitura en formato .musicxml
     * @param id identificador de la partitura en base de datos
     * @return devuelve un objeto {@link Sheet} con la información de la partitura
     * @throws IOException
     */
    @PostMapping("/{id}/file/musicxml")
    public Sheet uploadFileXML(@RequestBody MultipartFile file, @PathVariable Integer id) throws IOException {
        File dir = new File(String.format("sheets/%d", id));
        if(!dir.exists()) dir.mkdirs();
        File localFile = new File(String.format("sheets/%d/%d.musicxml", id, id));
        Files.copy(file.getInputStream(), localFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        Sheet sheet = sheetRepository.findById(id).get();
        return sheet;
    }

    /**
     * Guarda una partitura en la carpeta 'sheets', renombrando el archivo y modificando la ruta y el estado en la base
     * de datos.
     * @param file partitura en formato .pdf
     * @param id identificador de la partitura en base de datos
     * @return devuelve un objeto {@link Sheet} con la información de la partitura
     * @throws IOException
     */
    @PostMapping("/{id}/file/pdf")
    public Sheet uploadFilePDF(@RequestBody MultipartFile file, @PathVariable Integer id) throws IOException {
        File dir = new File(String.format("sheets/%d", id));
        if(!dir.exists()) dir.mkdirs();
        File localFile = new File(String.format("sheets/%d/%d.pdf", id, id));
        Files.copy(file.getInputStream(), localFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        Sheet sheet = sheetRepository.findById(id).get();
        sheet.setFinished(true);
        sheetRepository.save(sheet);
        return sheet;
    }

    @GetMapping("/{id}/file/musicxml")
    public ResponseEntity<Resource> downloadFileXML(@PathVariable int id) throws FileNotFoundException {
        Sheet sheet = sheetRepository.findById(id).get();
        File file = new File(String.format("sheets/%d/%d.musicxml", id, id));
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + sheet.getName() + ".musicxml\"")
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    @GetMapping("/{id}/file/pdf")
    public ResponseEntity<Resource> downloadFilePDF(@PathVariable int id) throws FileNotFoundException {
        Sheet sheet = sheetRepository.findById(id).get();
        File file = new File(String.format("sheets/%d/%d.pdf", id, id));
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + sheet.getName() + ".pdf\"")
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    @PostMapping("/{id}/finished")
    public Sheet setFinished(@PathVariable Integer id, @RequestBody Sheet sheet) {
        Sheet tmp = sheetRepository.findById(id).get();
        tmp.setFinished(sheet.getFinished());
        sheetRepository.save(tmp);
        return tmp;
    }
}
