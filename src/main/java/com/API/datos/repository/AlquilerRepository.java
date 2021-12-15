package com.API.datos.repository;

import com.API.datos.entity.Alquiler;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, Integer>{
    Boolean  existsById(int id);    
}
