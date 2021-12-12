package com.API.datos.services;

import java.util.List;

import com.API.datos.entity.EstadoInmueble;
import com.API.datos.repository.EstadoInmuebleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EstadoInmuebleService {
    
    @Autowired
    EstadoInmuebleRepository estadoInmuebleRepository;

    public List<EstadoInmueble> list() {
        return estadoInmuebleRepository.findAll();
    }

    public EstadoInmueble getOne(Integer id) {
        return estadoInmuebleRepository.findById(id).get();
    }

    public void save(EstadoInmueble estadoInmueble){
        estadoInmuebleRepository.save(estadoInmueble);
    }

    public void delete(int id){
        estadoInmuebleRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return estadoInmuebleRepository.existsById(id);
    }

}
