package org.codelab.softwaresol.controllers;

import org.codelab.softwaresol.model.entities.producto.Producto;
import org.codelab.softwaresol.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
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

    @PostMapping
    public Producto create(@RequestBody Producto producto){
        return productoService.create(producto);
    }

    @PutMapping
    public Producto update(@RequestBody Producto producto) {
        return productoService.update(producto);
    }

    @DeleteMapping("/{idProducto}")
    public void delete(@PathVariable("idProducto") int idProducto) {
        productoService.deleteProducto(idProducto);
    }
}
