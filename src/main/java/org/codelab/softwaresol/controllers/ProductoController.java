package org.codelab.softwaresol.controllers;

import org.codelab.softwaresol.model.entities.producto.Producto;
import org.codelab.softwaresol.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> obtenerProductos() {
        return productoService.obtenerProductos();
    }

    @GetMapping("/{idProducto}")
    public Optional<Producto> obtenerProducto(@PathVariable("idProducto") int idProducto) {
        return productoService.obtenerProducto(idProducto);
    }

    @PostMapping("/addProduct")
    public Producto saveUpdateProducto(@RequestBody Producto producto) {
        productoService.saveOrUpdate(producto);
        return producto;

    }

    @DeleteMapping("/{idProducto}")
    public void deleteProducto(@PathVariable("idProducto") int idProducto) {
        productoService.deleteProducto(idProducto);
    }


}
