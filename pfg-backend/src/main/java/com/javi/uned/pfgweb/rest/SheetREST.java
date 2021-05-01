package com.javi.uned.pfgweb.rest;

import com.javi.uned.pfgweb.beans.Sheet;
import com.javi.uned.pfgweb.beans.SheetDTO;
import com.javi.uned.pfgweb.config.FileSystemConfig;
import com.javi.uned.pfgweb.repositories.SheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/sheets")
public class SheetREST {

    @Autowired
    private SheetRepository sheetRepository;
    @Autowired
    private FileSystemConfig fileSystemConfig;

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
                .withMatcher("name", GenericPropertyMatcher::contains);
        Example<Sheet> sheetExample = Example.of(sheet, matcher);
        return sheetRepository.findAll(sheetExample);
    }

    @PostMapping
    public Sheet createSheet(@RequestBody SheetDTO sheetDTO){
        Sheet sheet = new Sheet();
        sheet.setDate(sheetDTO.getDate());
        sheet.setId(sheetDTO.getId());
        sheet.setStyle(sheetDTO.getStyle());
        sheet.setName(sheetDTO.getName());
        sheet.setOwnerId(sheetDTO.getOwnerId());
        sheet.setFinished(sheetDTO.getFinished());
        return sheetRepository.save(sheet);
    }

    @GetMapping("/{id}")
    public Sheet sheet(@PathVariable Integer id) {
        Optional<Sheet> optionalSheet = sheetRepository.findById(id);
        return optionalSheet.isPresent()? optionalSheet.get() : null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sheet> setFinished(@PathVariable Integer id, @RequestBody SheetDTO sheetDTO) {
        Optional<Sheet> optionalSheet = sheetRepository.findById(id);
        if (optionalSheet.isPresent()) {
            Sheet result = optionalSheet.get();
            if(sheetDTO.getFinished() != null) result.setFinished(sheetDTO.getFinished());
            if(sheetDTO.getName() != null) result.setName(sheetDTO.getName());
            if(sheetDTO.getId() != null) result.setId(sheetDTO.getId());
            if(sheetDTO.getDate() != null) result.setDate(sheetDTO.getDate());
            if(sheetDTO.getStyle() != null) result.setStyle(sheetDTO.getStyle());
            if(sheetDTO.getOwnerId() != null) result.setOwnerId(sheetDTO.getOwnerId());
            sheetRepository.save(result);
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Elimina la partitura seleccionada del sistema de archivos y de la base de datos.
     * @param id identificador de la partitura a eliminar
     */
    @DeleteMapping("/{id}")
    public String deleteSheet(@PathVariable int id) {
        sheetRepository.deleteById(id);
        fileSystemConfig.deleteSheetFolder(id);
        return "Partitura eliminada con éxito";
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
        File dir = fileSystemConfig.getSheetFolder(id);
        File musicxmlFile = new File(String.format("%s/%d.musicxml", dir.getAbsolutePath(), id));
        Files.copy(file.getInputStream(), musicxmlFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        Optional<Sheet> optionalSheet = sheetRepository.findById(id);
        return optionalSheet.isPresent()? optionalSheet.get() : null;
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
    public ResponseEntity<Sheet> uploadFilePDF(@RequestBody MultipartFile file, @PathVariable Integer id) throws IOException {
        Optional<Sheet> optionalSheet = sheetRepository.findById(id);
        if (optionalSheet.isPresent()) {
            File dir = fileSystemConfig.getSheetFolder(id);
            File localFile = new File(String.format("%s/%d.pdf", dir.getAbsolutePath(), id));
            Files.copy(file.getInputStream(), localFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Sheet sheet = optionalSheet.get();
            sheet.setFinished(true);
            sheetRepository.save(sheet);
            return ResponseEntity.ok(sheet);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{id}/file/musicxml")
    public ResponseEntity<Resource> downloadFileXML(@PathVariable int id) throws FileNotFoundException {
        Optional<Sheet> optionalSheet = sheetRepository.findById(id);
        if(optionalSheet.isPresent()){
            Sheet sheet = optionalSheet.get();
            File file = new File(fileSystemConfig.getSheetFolder(id), id + ".musicxml");
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + sheet.getName() + ".musicxml\"")
                    .contentLength(file.length())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/file/pdf")
    public ResponseEntity<Resource> downloadFilePDF(@PathVariable int id) throws FileNotFoundException {
        Optional<Sheet> optionalSheet = sheetRepository.findById(id);
        if (optionalSheet.isPresent()) {
            Sheet sheet = optionalSheet.get();
            File file = new File(fileSystemConfig.getSheetFolder(id), id + ".pdf");
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + sheet.getName() + ".pdf\"")
                    .contentLength(file.length())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
