package com.API.datos.services;

import com.API.datos.entity.EstadoEspacio;
import com.API.datos.repository.EstadoEspacioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EstadoEspacioService {
    
    @Autowired
    private EstadoEspacioRepository estadoEspacioRepository;

    public Iterable<EstadoEspacio> listAllEstadoEspacio() {
        return estadoEspacioRepository.findAll();
    }

    public EstadoEspacio getEstadoEspacioById(Integer id) {
        return estadoEspacioRepository.findById(id).get();
    }

    public EstadoEspacio saveEstadoEspacio(EstadoEspacio estadoEspacio) {
        return estadoEspacioRepository.save(estadoEspacio);
    }

    public void deleteEstadoEspacio(Integer id) {
        estadoEspacioRepository.deleteById(id);
    }

}
