package com.example.rv4.Coche.Service;

import com.example.rv4.BaseService;
import com.example.rv4.Coche.Domain.Coche;
import com.example.rv4.Coche.Repository.CocheRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CocheService extends BaseService<Coche, Long, CocheRepository> {

    @Autowired
    private CocheRepository cocheRepository;


    public Coche addCoche(Coche nuevoCoche){
        return cocheRepository.save(nuevoCoche);
    }

    public Coche updateCocheById(Coche nuevoCoche){
        Optional<Coche> coche = null;
        coche = cocheRepository.findById(nuevoCoche.getId());
        if (coche.isPresent()){
            cocheRepository.save(nuevoCoche);
        }
        return coche.get();
    }

    public void deleteCoche(Long id){
        try {
            cocheRepository.delete(cocheRepository.findById(id).get());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Coche> getCoche(){
        return cocheRepository.findAll();
    }

    public Optional<Coche> getCocheById(Long id){
        return cocheRepository.findById(id);
    }

    /*public Page<Coche> getCoches(Pageable pageable, @SearchSpec Specification<Coche> specs){
        return cocheRepository.findAll(specs,pageable);
    }*/
}
