package com.example.rv4.Desguace.Service;

import com.example.rv4.BaseService;
import com.example.rv4.Coche.Domain.Coche;
import com.example.rv4.Desguace.Respository.DesguaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesguaceService extends BaseService<Coche, Long, DesguaceRepository> {

    @Autowired
    private DesguaceRepository desguaceRepository;


    public Coche addCoche(Coche nuevoDesguace){
        return desguaceRepository.save(nuevoDesguace);
    }

    public Coche updateDesguaceById(Coche nuevoDesguace){
        Optional<Coche> desguace = null;
        desguace = desguaceRepository.findById(nuevoDesguace.getId());
        if (desguace.isPresent()){
            desguaceRepository.save(nuevoDesguace);
        }
        return desguace.get();
    }

    public void deleteDesguace(Long id){
        try {
            desguaceRepository.delete(desguaceRepository.findById(id).get());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Coche> getDesguace(){
        return desguaceRepository.findAll();
    }

    public Optional<Coche> getDesguaceById(Long id){
        return desguaceRepository.findById(id);
    }
}

