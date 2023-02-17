package com.example.rv4.Direccion.Controller;

import com.example.rv4.Direccion.Domain.Direccion;
import com.example.rv4.Direccion.Service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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


    @GetMapping("/paginado")
    public ResponseEntity<Page<Direccion>> listaDirecciones(@PageableDefault(size = 10, page = 0)Pageable pageable){
        Page<Direccion> direcciones= direccionService.findAll(pageable);
        if (pageable.getPageNumber() > direcciones.getTotalPages()){
            return new ResponseEntity<>(direcciones, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(direcciones, HttpStatus.OK);
    }

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
