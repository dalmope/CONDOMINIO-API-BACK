package com.API.datos.controllers;

import com.API.datos.entity.EstadoEspacio;
import com.API.datos.entity.Mensaje;
import com.API.datos.services.EstadoEspacioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/estadosespacios")
@CrossOrigin(origins = "*")
public class EstadoEspacioController {

    @Autowired
    private EstadoEspacioService estadoEspacioService;
    
    @ApiOperation("Devuelve todos los estados de espacio")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping
    public Iterable<EstadoEspacio> getEstadosEspacio() {
        return estadoEspacioService.listAllEstadoEspacio();
    }

    @ApiOperation("Crea un nuevo estado de espacio")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<?> addEstadoEspacio(EstadoEspacio estadoEspacio) {
        if (estadoEspacioService.getEstadoEspacioById(estadoEspacio.getId()) != null) {
            return new ResponseEntity<>(new Mensaje("Id ya existe"), HttpStatus.BAD_REQUEST);
        }
        estadoEspacioService.saveEstadoEspacio(estadoEspacio);
        return new ResponseEntity<>(new Mensaje("Nuevo Estado de espacio Creado"), HttpStatus.CREATED);
    }

    @ApiOperation("Actualiza un estado de espacio")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEstadoEspacio(@PathVariable("id") Integer id, EstadoEspacio estadoEspacio) {
        if (estadoEspacioService.getEstadoEspacioById(id) != null) {
            estadoEspacio.setId(id);
            return new ResponseEntity<>(new Mensaje("Id no valido"), HttpStatus.BAD_REQUEST);
        }
        estadoEspacioService.saveEstadoEspacio(estadoEspacio);
        return new ResponseEntity<>(new Mensaje("Estado de espacio actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEstadoEspacio(@PathVariable("id") Integer id) {
        if (estadoEspacioService.getEstadoEspacioById(id) == null) {
            return new ResponseEntity<>(new Mensaje("Id no valido"), HttpStatus.BAD_REQUEST);
        }
        estadoEspacioService.deleteEstadoEspacio(id);
        return new ResponseEntity<>(new Mensaje("Estado de espacio Eliminado"), HttpStatus.OK);
    }







}