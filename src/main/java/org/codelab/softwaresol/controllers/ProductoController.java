package org.codelab.softwaresol.controllers;

import org.codelab.softwaresol.model.entities.Ciudad;
import org.codelab.softwaresol.model.entities.producto.Producto;
import org.codelab.softwaresol.model.entities.proveedor.Proveedor;
import org.codelab.softwaresol.model.entities.repos.ProductoRepository;
import org.codelab.softwaresol.model.entities.user.Usuario;
import org.codelab.softwaresol.services.AuthService;
import org.codelab.softwaresol.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/product")
public class ProductoController {


    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    public ProductoService productoService;
    @Autowired
    private AuthController auth;

    @Autowired
    private AuthService authService;



    @GetMapping("/getProducts")
    public String getProducts(Model model) {
        List<Producto> listProducts = productoService.obtenerProductos();
        model.addAttribute("listProducts", listProducts);
        return "product/showProduct";
    }

    @GetMapping(value = "/agregar")
    public String createProduct(Model model){
        String currentUser = auth.getCurrentUser();
        String userRol = authService.getRolUser(currentUser);
        String username = authService.getUsername(currentUser);
        model.addAttribute("username", username);
        if (userRol != null && userRol.equals("ADMIN")) {
            Producto producto = new Producto();
            model.addAttribute("producto", producto);
            return "product/createProduct";
        } else {
            return "error/500";
        }
    }
    @PostMapping(value = "/agregar")
    public String saveUser(@ModelAttribute Producto producto){
        productoService.saveOrUpdate(producto);
        return "redirect:/api/product/getProducts";
    }

    @RequestMapping("/editar/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id){
        String currentUser = auth.getCurrentUser();
        String userRol = authService.getRolUser(currentUser);
        ModelAndView error = new ModelAndView("error/500");
        if (userRol != null && userRol.equals("ADMIN")) {
            ModelAndView model = new ModelAndView("product/editProduct");
            Producto producto = productoService.getById(id);
            model.addObject("producto", producto);
            return model;
        } else {
            return error;
        }

    }













    @GetMapping("/prueba")
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
