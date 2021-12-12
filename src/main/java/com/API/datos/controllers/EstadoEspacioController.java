package com.API.datos.controllers;

import com.API.datos.entity.EstadoEspacio;
import com.API.datos.services.EstadoEspacioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estadosinmuebles")
@CrossOrigin(origins = "*")
public class EstadoEspacioController {

    @Autowired
    private EstadoEspacioService estadoEspacioService;

    @GetMapping
    public Iterable<EstadoEspacio> getEstadosEspacio() {
        return estadoEspacioService.listAllEstadoEspacio();
    }





}