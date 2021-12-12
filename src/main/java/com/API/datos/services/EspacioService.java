package com.API.datos.services;

import java.util.List;

import com.API.datos.entity.Espacio;
import com.API.datos.repository.EspacioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EspacioService {
    
    @Autowired
    private EspacioRepository espacioRepository;

    public List<Espacio> getEspacios() {
        return espacioRepository.findAll();
    }

    public Espacio getEspacio(Integer id) {
        return espacioRepository.findById(id).get();
    }

    public void addEspacio(Espacio espacio) {
        espacioRepository.save(espacio);
    }

    public void updateEspacio(Espacio espacio) {
        espacioRepository.save(espacio);
    }

    public void deleteEspacio(int id) {
        espacioRepository.deleteById(id);
    }

}
