package com.API.datos.services;

import java.util.List;

import javax.transaction.Transactional;

import com.API.datos.entity.Alquiler;
import com.API.datos.repository.AlquilerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AlquilerService {
    
    @Autowired
    AlquilerRepository alquilerRepository;

    public List<Alquiler> list() {
        return alquilerRepository.findAll();
    }

    public Alquiler getOne(Integer id) {
        return alquilerRepository.findById(id).get();
    }

    public void save(Alquiler alquiler){
        alquilerRepository.save(alquiler);
    }

    public void delete(int id){
        alquilerRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return alquilerRepository.existsById(id);
    }
}
