//package org.codelab.softwaresol.controllers;
//
//import org.codelab.softwaresol.model.entities.producto.Producto;
//import org.codelab.softwaresol.services.ProductoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class ProductoController {
//
//    @Autowired
//    private ProductoService productoService;
//
//    @GetMapping("/obtener-producto")
//    @ResponseBody
//    public List<Producto> obtenerDatos(){
//            List<Producto> datosProducto = productoService.obtenerDatosBd();
//        return datosProducto;
//    }
//
//
//}
