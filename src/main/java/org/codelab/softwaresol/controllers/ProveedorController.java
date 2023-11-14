package org.codelab.softwaresol.controllers;

import org.codelab.softwaresol.model.entities.proveedor.Proveedor;
import org.codelab.softwaresol.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public List<Proveedor> obtener() {
        return proveedorService.obtener();
    }

    @GetMapping("/{idProv}")
    public Optional<Proveedor> obtenerPorId(@PathVariable int idProv) {
        return proveedorService.obtenerPorId(idProv);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Proveedor crear(@RequestBody Proveedor proveedor) {
        return proveedorService.crear(proveedor);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Proveedor actualizar(@RequestBody Proveedor proveedor) {
        return proveedorService.update(proveedor);
    }

    @DeleteMapping("/{idProv}")
    public void eliminar(@PathVariable("idProv") int idProv) {
        proveedorService.delete(idProv);
    }
}
