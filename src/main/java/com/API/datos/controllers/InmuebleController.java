package com.API.datos.controllers;

import java.util.List;

import com.API.datos.entity.Inmuebles;
import com.API.datos.entity.Mensaje;
import com.API.datos.services.InmuebleService;

import org.apache.commons.lang3.StringUtils;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/inmuebles")
@CrossOrigin(origins = "*")
public class InmuebleController {

    @Autowired
    InmuebleService inmuebleService;

    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation("Muestra una lista Inmuebles")
    @GetMapping
    public ResponseEntity<List<Inmuebles>> list() {
        List<Inmuebles> list = inmuebleService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @ApiOperation("Obtiene un Inmueble por su id")
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) {
        if (id <= 0) {
            return new ResponseEntity<>(new Mensaje("Id no valido"), HttpStatus.BAD_REQUEST);
        }
        if (!inmuebleService.existsById(id)) {
            return new ResponseEntity<>(new Mensaje("No existe el inmueble solicitado"), HttpStatus.NOT_FOUND);
        }
        Inmuebles inmueble = inmuebleService.getOne(id).get();
        return new ResponseEntity<>(inmueble, HttpStatus.OK);
    }

    @ApiOperation("Crea un Inmueble")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Inmuebles inmueble) {
        if (StringUtils.isBlank(inmueble.getDireccion()))
            return new ResponseEntity<>(new Mensaje("la direccion es obligatoria"), HttpStatus.BAD_REQUEST);
        if (inmuebleService.getByDireccion(inmueble.getDireccion()) != null)
            return new ResponseEntity<>(new Mensaje("Esa dirección ya se encuentra registrada"),
                    HttpStatus.BAD_REQUEST);
        inmuebleService.save(inmueble);
        return new ResponseEntity<>(new Mensaje("Inmueble creado"), HttpStatus.OK);
    }

    @ApiOperation("Actualiza un Inmueble")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Inmuebles inmueble) {
        if (!inmuebleService.existsById(id))
            return new ResponseEntity<>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if (inmuebleService.existsByDireccion(inmueble.getDireccion()))
            return new ResponseEntity<>(new Mensaje("esa direccion ya existe"), HttpStatus.BAD_REQUEST);
        inmuebleService.save(inmueble);
        return new ResponseEntity<>(new Mensaje("Inmueble actualizado"), HttpStatus.OK);
    }

    @ApiOperation("Elimina un Inmueble")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!inmuebleService.existsById(id))
            return new ResponseEntity<>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        inmuebleService.delete(id);
        return new ResponseEntity<>(new Mensaje("Inmueble eliminado"), HttpStatus.OK);
    }

    // @ApiOperation("Obtiene una lista de Inmuebles por su estado")
    // @GetMapping("/estado/{estado}")
    // public ResponseEntity<?> getByEstado(@PathVariable("estado") String estado) {
    //     if (StringUtils.isBlank(estado))
    //         return new ResponseEntity<>(new Mensaje("el estado es obligatorio"), HttpStatus.BAD_REQUEST);
    //     List<Inmuebles> list = inmuebleService.getByEstado(estado);
    //     return new ResponseEntity<>(list, HttpStatus.OK);
    // }
    

}
