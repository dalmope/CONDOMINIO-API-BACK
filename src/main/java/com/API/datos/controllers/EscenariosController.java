package com.API.datos.controllers;

import java.util.HashSet;
import java.util.List;

import com.API.datos.entity.Escenarios;
import com.API.datos.entity.Mensaje;
import com.API.datos.services.EscenariosService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/escenarios")
@CrossOrigin(origins = "*")
public class EscenariosController {

    @Autowired
    EscenariosService escenariosService;

    @ApiOperation("Muestra una lista de Escenarios")
    @GetMapping
    public ResponseEntity<List<Escenarios>> list(){
        List<Escenarios> list = escenariosService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id){
        if(!escenariosService.existsById(id)){
            return new ResponseEntity<>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Escenarios escenario = escenariosService.getOne(id);
        return new ResponseEntity<>(escenario, HttpStatus.OK);
    }

    @ApiOperation("Crea un Escenario")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Escenarios escenario){
        if(StringUtils.isBlank(escenario.getNombre()))
            return new ResponseEntity<>(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(escenariosService.getByNombre(escenario.getNombre()))
            return new ResponseEntity<>(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);

        Escenarios escenarioNuevo = new Escenarios (escenario.getNombre(), escenario.getDescripcion(), escenario.getEstado());

        escenariosService.save(escenarioNuevo);
        return new ResponseEntity<>(new Mensaje("Escenario creado"), HttpStatus.OK);
    }
    
}
