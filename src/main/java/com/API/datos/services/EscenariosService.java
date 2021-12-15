package com.API.datos.services;

import java.util.List;

import javax.transaction.Transactional;

import com.API.datos.entity.Escenarios;
import com.API.datos.repository.EscenariosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EscenariosService {
    
    @Autowired
    EscenariosRepository escenariosRepository;

     public List<Escenarios> list() {
        return escenariosRepository.findAll();
    }


    public Escenarios getOne(Integer id) {
        return escenariosRepository.findById(id).get();
    }

    public List<Escenarios> getActivos(){
        return escenariosRepository.findByEstado(true).get();
    }

    public boolean getByNombre(String nombre) {
        return escenariosRepository.existsByNombre(nombre);
    }

    public void save(Escenarios Escenario){
        escenariosRepository.save(Escenario);
    }

    public void delete(int id){
        escenariosRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return escenariosRepository.existsById(id);
    }
}
