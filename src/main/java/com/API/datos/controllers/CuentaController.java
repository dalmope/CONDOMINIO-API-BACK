package com.API.datos.controllers;

import java.util.Date;
import java.util.List;

import com.API.datos.entity.Cuenta;
import com.API.datos.entity.Mensaje;
import com.API.datos.services.CuentaService;
import com.API.datos.services.EstadoCuentaService;
import com.API.datos.services.InmuebleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/cuentas")
@CrossOrigin(origins = "*")
public class CuentaController {
    @Autowired
    CuentaService CuentaService;

    @Autowired
    EstadoCuentaService estadoCuentaService;

    @Autowired
    InmuebleService inmuebleService;

    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation("Muestra una lista de Estados de cuenta")
    @GetMapping
    public ResponseEntity<List<Cuenta>> getCuentas(){
        List<Cuenta> list = CuentaService.getCuentas();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation("Muestra una lista de Estados de cuenta")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Cuenta cuenta) {
        Date hoy = new Date();

        if (cuenta.getFechaLimite().before(hoy)) {
            return new ResponseEntity<>(new Mensaje("Fecha Limite no puede ser menor a la fecha actual"), HttpStatus.OK);
        }

        if(cuenta.getFechaLimite().after(hoy)){
            cuenta.setEstadoId(estadoCuentaService.getOne(2).get());
            if(cuenta.getMesesMora() > 5){
                cuenta.setEstadoId(estadoCuentaService.getOne(3).get());
            }
        }

        cuenta.setIdInmueble(inmuebleService.getOne(cuenta.getIdInmueble().getId()).get());

        CuentaService.save(cuenta);
        return new ResponseEntity<>(new Mensaje("Cuenta creada con exito"), HttpStatus.OK);
    }

    


}
