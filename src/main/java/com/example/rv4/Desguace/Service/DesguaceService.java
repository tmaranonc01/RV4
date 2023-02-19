package com.example.rv4.Desguace.Service;

import com.example.rv4.BaseService;
import com.example.rv4.Desguace.Domain.Desguace;
import com.example.rv4.Desguace.Repository.DesguaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesguaceService extends BaseService<Desguace, Long, DesguaceRepository> {

    @Autowired
    private DesguaceRepository desguaceRepository;

    public Desguace addDesguace(Desguace nuevoDesguace){
        return desguaceRepository.save(nuevoDesguace);
    }

    public Desguace updateDesguaceById(Desguace nuevoDesguace){
        Optional<Desguace> desguace = null;
        desguace = desguaceRepository.findById(nuevoDesguace.getId());
        if (desguace.isPresent()){
            desguaceRepository.save(nuevoDesguace);
        }
        return desguace.get();
    }

    public void deleteDesguace(Long id){
        try {
            desguaceRepository.delete(desguaceRepository.findById(id).get());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Desguace> getDesguace(){
        return desguaceRepository.findAll();
    }

    public Optional<Desguace> getDesguaceById(Long id){
        return desguaceRepository.findById(id);
    }

}
