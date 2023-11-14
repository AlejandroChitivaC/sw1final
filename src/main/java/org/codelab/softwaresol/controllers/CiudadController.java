package org.codelab.softwaresol.controllers;

import org.codelab.softwaresol.model.entities.Ciudad;
import org.codelab.softwaresol.services.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ciudades")
public class CiudadController {

    @Autowired
    private CiudadService ciudadService;

    @GetMapping
    public List<Ciudad> obtenerCiudades() {
        return ciudadService.obtenerCiudades();
    }

    @GetMapping("/{idCiudad}")
    public Optional<Ciudad> obtenerCiudad(@PathVariable int idCiudad) {
        return ciudadService.obtenerCiudad(idCiudad);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Ciudad crearCiudad(@RequestBody Ciudad ciudad) {
        return ciudadService.crearCiudad(ciudad);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Ciudad actualizarCiudad(@RequestBody Ciudad ciudad) {
        return ciudadService.actualizarCiudad(ciudad);
    }

    @DeleteMapping("/{idCiudad}")
    public void eliminarCiudad(@PathVariable("idCiudad") int idCiudad) {
        ciudadService.eliminarCiudad(idCiudad);
    }
}
