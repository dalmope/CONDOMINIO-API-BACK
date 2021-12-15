package com.API.datos.repository;

import java.util.List;
import java.util.Optional;

import com.API.datos.entity.Escenarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscenariosRepository extends JpaRepository<Escenarios, Integer> {
    boolean findByNombre(String nombre);
    Optional<List<Escenarios>> findByEstado(boolean b);
}
