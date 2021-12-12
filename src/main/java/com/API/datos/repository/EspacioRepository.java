package com.API.datos.repository;

import java.util.List;

import com.API.datos.entity.Espacio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspacioRepository extends JpaRepository<Espacio, Integer> {
    List<Espacio> findByNombre(String nombre);
}
    

