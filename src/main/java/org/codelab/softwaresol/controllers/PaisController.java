package org.codelab.softwaresol.controllers;

import org.codelab.softwaresol.model.entities.Pais;
import org.codelab.softwaresol.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping
    public List<Pais> obtenerPaises(){
        return paisService.obtenerPaises();
    }

    @GetMapping("/{idPais}")
    public Optional<Pais> obtenerPais(@PathVariable int idPais){
        return paisService.obtenerPais(idPais);
    }

    @PostMapping
    public Pais createPais(@RequestBody Pais pais){
        return paisService.createPais(pais);
    }

    @PutMapping
    public Pais updatePais(@RequestBody Pais pais){
        return paisService.updatePais(pais);
    }

    @DeleteMapping("/{idPais}")
    public void deletePaisById(@PathVariable("idPais") int idPais){
        paisService.detelePais(idPais);
    }
}
