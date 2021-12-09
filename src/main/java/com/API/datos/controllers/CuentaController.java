package com.API.datos.controllers;

import java.util.List;

import com.API.datos.entity.Cuenta;
import com.API.datos.services.CuentaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Cuentas")
@CrossOrigin(origins = "*")
public class CuentaController {
    @Autowired
    CuentaService CuentaService;

    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation("Muestra una lista de Estados de cuenta")
    @GetMapping
    public ResponseEntity<List<Cuenta>> getCuentas(){
        List<Cuenta> list = CuentaService.getCuentas();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
