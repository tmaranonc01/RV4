package com.example.rv4.Pieza.Controller;

import com.example.rv4.Pieza.Domain.Pieza;
import com.example.rv4.Pieza.Service.PiezaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pieza")
public class PiezaController {

    @Autowired
    private PiezaService piezaService;


    @GetMapping
    public ResponseEntity<List<Pieza>> listaPiezas(){
        List<Pieza> piezas = piezaService.getPieza();
        return new ResponseEntity<>(piezas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Pieza> PiezaPorId(@PathVariable Long id){
        return piezaService.getPiezaById(id);
    }

    @PostMapping
    public ResponseEntity<Pieza> addPieza(@RequestBody Pieza pieza){
        pieza.setNombre(pieza.getNombre());
        pieza.setDescripcion(pieza.getDescripcion());
        pieza.setCoche(pieza.getCoche());
        Pieza pieza1 = piezaService.addPieza(pieza);
        return new ResponseEntity<>(pieza1, HttpStatus.OK);
    }

   /* @PostMapping("/fichero")
    public ResponseEntity<Pieza> addPieza(@RequestBody Pieza nuevaPieza, @RequestParam("fichero")MultipartFile file) {
        Pieza pieza = null;
        try {
            String fileName = fileStorageService.storeFile(file);
            pieza = nuevaPieza;
            pieza.setNombre(pieza.getNombre());
            pieza.setDescripcion(pieza.getDescripcion());
            pieza.setCoche(pieza.getCoche());
            pieza.setFoto(fileName);
            Pieza pieza1 = piezaService.addPieza(pieza);
            return new ResponseEntity<>(pieza1, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }*/

    @PutMapping("/{id}")
    public ResponseEntity<Pieza> modifyPieza(@RequestBody Pieza nuevaPieza){
        Pieza pieza = piezaService.updatePiezaById(nuevaPieza);
        return new ResponseEntity<>(pieza, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pieza> deletePieza(@PathVariable Long id){
        piezaService.deletePieza(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
