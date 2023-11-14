package org.codelab.softwaresol.controllers;

import org.codelab.softwaresol.model.entities.proveedor.Proveedor;
import org.codelab.softwaresol.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public List<Proveedor> getSuppliers() {
        return proveedorService.getSuppliers();
    }


    @GetMapping("/getSupplierId/{idSupplier}")
    public Optional<Proveedor> getSupplierById(@PathVariable("idSupplier") int idSupplier) {
        return proveedorService.getSupplierById(idSupplier);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON)
    public Proveedor createSupplier(Proveedor proveedor) {
        proveedorService.createSupplier(proveedor);
        return proveedor;
    }

    @PutMapping
    public Proveedor updateSupplier(Proveedor proveedor) {
        proveedorService.updateSupplier(proveedor);
        return proveedor;
    }

    @DeleteMapping("{idProveedor}")
    public void deleteSupplier(@PathVariable("idProveedor") int idProveedor) {
        proveedorService.deleteSupplier(idProveedor);
    }
}


