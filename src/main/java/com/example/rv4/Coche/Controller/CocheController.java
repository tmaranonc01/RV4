package com.example.rv4.Coche.Controller;

import com.example.rv4.Coche.Domain.Coche;
import com.example.rv4.Coche.Service.CocheService;
import com.sipios.springsearch.SpecificationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sipios.springsearch.anotation.SearchSpec;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/coche")
public class CocheController {

    @Autowired
    private CocheService cocheService;


    @GetMapping
    public ResponseEntity<List<Coche>> listaCoches(){
        List<Coche> coches = cocheService.getCoche();
        return new ResponseEntity<>(coches, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Coche> CochePorId(@PathVariable Long id){
        return cocheService.getCocheById(id);
    }

    @GetMapping("/paginado")
    public ResponseEntity <Page<Coche>> listaCoches(@PageableDefault(size = 10, page = 0) Pageable pageable, @SearchSpec Specification<Coche> specs){
        Page<Coche> coches = cocheService.getCoches(pageable,specs);
        if (pageable.getPageNumber() > coches.getTotalPages()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(coches, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Coche> addCoche(@RequestBody Coche coche){
        coche.setModelo(coche.getModelo());
        coche.setMotor(coche.getMotor());
        coche.setAno(coche.getAno());
        Coche coche1 = cocheService.addCoche(coche);
        return new ResponseEntity<>(coche1, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coche> modifyCoche(@RequestBody Coche nuevoCoche){
        Coche coche = cocheService.updateCocheById(nuevoCoche);
        return new ResponseEntity<>(coche, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Coche> deleteCoche(@PathVariable Long id){
        cocheService.deleteCoche(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
