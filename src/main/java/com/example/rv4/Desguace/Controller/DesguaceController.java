package com.example.rv4.Desguace.Controller;

import com.example.rv4.Desguace.Domain.Desguace;
import com.example.rv4.Desguace.Service.DesguaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/desguace")
public class DesguaceController {

    @Autowired
    private DesguaceService desguaceService;

    @GetMapping
    public ResponseEntity<List<Desguace>> listaDesguaces(){
        List<Desguace> desguaces = desguaceService.getDesguace();
        return new ResponseEntity<>(desguaces, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Desguace> DesguacePorId(@PathVariable Long id){
        return desguaceService.getDesguaceById(id);
    }

    @PostMapping
    public ResponseEntity<Desguace> addDesguace(@RequestBody Desguace desguace){
        desguace.setDireccion(desguace.getDireccion());
        desguace.setNombre(desguace.getNombre());
        desguace.setCiudad(desguace.getCiudad());
        desguace.setTlf(desguace.getTlf());
        desguace.setPedidos(desguace.getPedidos());
        Desguace desguace1 = desguaceService.addDesguace(desguace);
        return new ResponseEntity<>(desguace1,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Desguace> modifyDesguace(@RequestBody Desguace nuevoDesguace){
        Desguace desguace = desguaceService.updateDesguaceById(nuevoDesguace);
        return new ResponseEntity<>(desguace, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Desguace> deleteDesguace(@PathVariable Long id){
        desguaceService.deleteDesguace(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
