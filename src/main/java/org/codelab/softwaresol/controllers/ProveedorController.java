package org.codelab.softwaresol.controllers;

import org.codelab.softwaresol.model.entities.proveedor.Proveedor;
import org.codelab.softwaresol.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/supplier")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/getSuppliers")
    public List<Proveedor> getSuppliers() {
        return proveedorService.getSuppliers();
    }

    @GetMapping("/getSupplierId/{idSupplier}")
    public Optional<Proveedor> getSupplierById(@PathVariable("idSupplier") int idSupplier) {
        return proveedorService.getSupplierById(idSupplier);
    }

    @PostMapping("/addSupplier")
    public Proveedor createSupplier(Proveedor proveedor) {
        proveedorService.createSupplier(proveedor);
        return proveedor;
    }

    @PutMapping("/updateSupplier")
    public Proveedor updateSupplier(Proveedor proveedor) {
        proveedorService.updateSupplier(proveedor);
        return proveedor;
    }

    @DeleteMapping("/deleteSupplier/{idSupplier}")
    public void deleteSupplier(@PathVariable("idSupplier") int idSupplier) {
        proveedorService.deleteSupplier(idSupplier);
    }
}


