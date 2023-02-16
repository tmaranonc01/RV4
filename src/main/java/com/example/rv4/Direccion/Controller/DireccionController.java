package com.example.rv4.Direccion.Controller;

import com.example.rv4.Direccion.Domain.Direccion;
import com.example.rv4.Direccion.Service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/direccion")
public class DireccionController {

    @Autowired
    private DireccionService direccionService;


    @GetMapping
    public ResponseEntity<List<Direccion>> listaDirecciones() {
        List<Direccion> direcciones =
                direccionService.getDireccion();
        return new ResponseEntity<>(direcciones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Direccion> DireccionPorId(@PathVariable Long id) {
        return direccionService.getDireccionById(id);
    }

    @PostMapping
    public ResponseEntity<Direccion> addDireccion(@RequestBody Direccion direccion) {
        direccion.setCalle(direccion.getCalle());
        direccion.setPortal(direccion.getPortal());
        direccion.setPoblacion(direccion.getPoblacion());
        Direccion direccion1 = direccionService.addDireccion(direccion);
        return new ResponseEntity<>(direccion1, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Direccion> modifyDireccion(@RequestBody Direccion nuevaDireccion) {
        Direccion direccion = direccionService.updateDireccionById(nuevaDireccion);
        return new ResponseEntity<>(direccion, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Direccion> deleteDireccion(@PathVariable Long id) {
        direccionService.deleteDireccion(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }


}
