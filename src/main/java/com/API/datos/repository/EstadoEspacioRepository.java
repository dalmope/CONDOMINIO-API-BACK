package com.API.datos.repository;

import com.API.datos.entity.EstadoEspacio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoEspacioRepository extends JpaRepository<EstadoEspacio, Integer> {

    Iterable<EstadoEspacio> findByNombre(String nombre);
}
