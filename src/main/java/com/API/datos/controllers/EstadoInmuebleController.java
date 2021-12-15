package com.API.datos.controllers;

import java.util.List;

import com.API.datos.entity.EstadoInmueble;
import com.API.datos.services.EstadoInmuebleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/estadosinmuebles")
@CrossOrigin(origins = "*")
public class EstadoInmuebleController {
    
    @Autowired
    private EstadoInmuebleService estadoInmuebleService;

    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation("Muestra una lista de Estados de Inmuebles")
    @GetMapping
    public ResponseEntity<List<EstadoInmueble>> list(){
        List<EstadoInmueble> list = estadoInmuebleService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation("Muestra un Estado de Inmueble")
    @GetMapping("/{id}")
    public ResponseEntity<EstadoInmueble> get(Integer id){
        EstadoInmueble estadoInmueble = estadoInmuebleService.getOne(id);
        return new ResponseEntity<>(estadoInmueble, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation("Crea un Estado de Inmueble")
    @PostMapping
    public ResponseEntity<EstadoInmueble> create(@RequestBody EstadoInmueble estadoInmueble){
        estadoInmuebleService.save(estadoInmueble);
        return new ResponseEntity<>(estadoInmueble, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation("Actualiza un Estado de Inmueble")
    @PostMapping("/{id}")
    public ResponseEntity<EstadoInmueble> update(@RequestBody EstadoInmueble estadoInmueble, Integer id){
        estadoInmuebleService.save(estadoInmueble);
        return new ResponseEntity<>(estadoInmueble, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation("Elimina un Estado de Inmueble")
    @DeleteMapping("/{id}")
    public ResponseEntity<EstadoInmueble> delete(@PathVariable("id")Integer id){
        estadoInmuebleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    

    







}
