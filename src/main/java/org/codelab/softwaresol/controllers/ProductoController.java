package org.codelab.softwaresol.controllers;

import org.codelab.softwaresol.model.entities.producto.Producto;
import org.codelab.softwaresol.model.entities.repos.ProductoRepository;
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
    private ProductoRepository productoRepository;

 //   @Autowired
 //   private AuthController auth;

    @Autowired
    public ProductoService productoService;

    @GetMapping("/getProducts")
    public String showProducts(Model model) {
        List<Producto> listProductos = productoService.obtenerProductos();
        model.addAttribute("listProductos", listProductos);
        return "static/web/users/showProduct.html";
    }

    @GetMapping("/getProducts3")
    public String showProducts3(Model model) {
        List<Producto> listProductos = productoService.obtenerProductos();
        model.addAttribute("listProductos", listProductos);
        return "static/pages/tables/data.html";
    }

    @GetMapping("/getProducts2")
    public List<Producto>listaProductos(){
        return this.productoService.obtenerProductos();
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
