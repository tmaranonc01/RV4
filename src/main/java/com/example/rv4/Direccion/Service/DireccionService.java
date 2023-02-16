package com.example.rv4.Direccion.Service;

import com.example.rv4.BaseService;
import com.example.rv4.Direccion.Domain.Direccion;
import com.example.rv4.Direccion.Repository.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DireccionService extends BaseService<Direccion, Long, DireccionRepository> {

    @Autowired
    private DireccionRepository direccionRepository;


    public Direccion addDireccion(Direccion nuevaDireccion){
        return direccionRepository.save(nuevaDireccion);
    }

    public Direccion updateDireccionById(Direccion nuevaDireccion){
        Optional<Direccion> direccion = null;
        direccion = direccionRepository.findById(nuevaDireccion.getId());
            if (direccion.isPresent()){
                direccionRepository.save(nuevaDireccion);
            }

        return direccion.get();
    }

    public void deleteDireccion(Long id){
        try {
            direccionRepository.delete(direccionRepository.findById(id).get());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Direccion> getDireccion(){
        return direccionRepository.findAll();
    }

    public Optional<Direccion> getDireccionById(Long id){
        return direccionRepository.findById(id);
    }
}
