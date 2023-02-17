package com.example.rv4.Pieza.Service;

import com.example.rv4.BaseService;
import com.example.rv4.Pieza.Domain.Pieza;
import com.example.rv4.Pieza.Repository.PiezaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PiezaService extends BaseService<Pieza, Long, PiezaRepository> {

    @Autowired
    private PiezaRepository piezaRepository;


    public Pieza addPieza(Pieza nuevaPieza) {
        return piezaRepository.save(nuevaPieza);
    }

    public Pieza updatePiezaById(Pieza nuevaPieza){
        Optional<Pieza> pieza = null;
        pieza = piezaRepository.findById(nuevaPieza.getId());
        if (pieza.isPresent()){
            piezaRepository.save(nuevaPieza);
        }
        return pieza.get();
    }

    public void deletePieza(Long id){
        try {
            piezaRepository.delete(piezaRepository.findById(id).get());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Pieza> getPieza(){
        return piezaRepository.findAll();
    }

    public Optional<Pieza> getPiezaById(Long id){
        return piezaRepository.findById(id);
    }
}
