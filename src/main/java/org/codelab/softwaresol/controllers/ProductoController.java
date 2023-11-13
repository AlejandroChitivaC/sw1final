package org.codelab.softwaresol.controllers;

import org.codelab.softwaresol.model.entities.producto.Producto;
import org.codelab.softwaresol.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private AuthController auth;

    @Autowired
    public ProductoService productoService;

    @GetMapping("/")
    public String showProducts(Model modelo) {
        List<Producto> listProductos = productoService.obtenerProductos();
        modelo.addAttribute("listProductos", listProductos);
        return "showProduct";
    }

    @GetMapping("/{idProducto}")
    public Optional<Producto> obtenerProducto(@PathVariable("idProducto") int idProducto) {
        return productoService.obtenerProducto(idProducto);
    }

    @PostMapping
    public Producto saveUpdateProducto(@RequestBody Producto producto) {
        productoService.saveOrUpdate(producto);
        return producto;

    }

    @DeleteMapping("/{idProducto}")
    public void deelteProducto(@PathVariable("idProducto") int idProducto) {
        productoService.deleteProducto(idProducto);
    }


}
