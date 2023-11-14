package org.codelab.softwaresol.controllers;

import org.codelab.softwaresol.model.entities.CompraProducto;
import org.codelab.softwaresol.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/compra")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @GetMapping("/getCompras")
    public List<CompraProducto> getCompras(){
        return compraService.getCompras();
    }

    @GetMapping("/getCompraId/{idCompra}")
    public Optional<CompraProducto> getCompraById(@PathVariable("idCompra") int idCompra){
        return compraService.getCompra(idCompra);
    }

    @PostMapping("/addCompra")
    public CompraProducto createCompra(CompraProducto compra){
        compraService.createCompra(compra);
        return compra;
    }

    @PutMapping("/updateCompra")
    public CompraProducto updateCompra(CompraProducto compra){
        compraService.updateCompra(compra);
        return compra;
    }

    @DeleteMapping("/delteCompra/{idCompra}")
    public void delteCompra(@PathVariable("idCompra") int idCompra){
        compraService.deleteCompra(idCompra);
    }
}
