package org.codelab.softwaresol.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.codelab.softwaresol.model.entities.Ciudad;
import org.codelab.softwaresol.model.entities.proveedor.Proveedor;
import org.codelab.softwaresol.model.entities.repos.CiudadRepository;
import org.codelab.softwaresol.model.entities.user.Usuario;
import org.codelab.softwaresol.services.AuthService;
import org.codelab.softwaresol.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/supplier")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;
    @Autowired
    private CiudadRepository ciudadRepository;
    @Autowired
    private AuthController auth;

    @Autowired
    private AuthService authService;
    @RequestMapping("/getSuppliers")
    public String getSupplier(Model model){
        String currentUser = auth.getCurrentUser();
        String username = authService.getUsername(currentUser);
        model.addAttribute("username", username);
        List<Proveedor> listSuppliers = proveedorService.getSuppliers();
        model.addAttribute("listSuppliers", listSuppliers);
        return "supplier/showSupplier";
    }

    @GetMapping(value = "/agregar")
    public String createSupplier(Model model){
        String currentUser = auth.getCurrentUser();
        String userRol = authService.getRolUser(currentUser);
        String username = authService.getUsername(currentUser);
        model.addAttribute("username", username);
        if (userRol != null && userRol.equals("ADMIN")) {
            Proveedor proveedor = new Proveedor();
            List<Ciudad> listCities =ciudadRepository.findAll();
            model.addAttribute("listCities", listCities);
            model.addAttribute("proveedor", proveedor);
            return "supplier/createSupplier";
        } else {
            return "error/500";
        }
    }
    @PostMapping(value = "/agregar")
    public String saveSupplier(@ModelAttribute Proveedor proveedor){
        proveedorService.createSupplier(proveedor);
        return "redirect:/api/supplier/getSuppliers";
    }

    @RequestMapping("/editar/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id, Model modelo){
        String currentUser = auth.getCurrentUser();
        String userRol = authService.getRolUser(currentUser);
        String username = authService.getUsername(currentUser);
        modelo.addAttribute("username", username);
        ModelAndView error = new ModelAndView("error/500");
        if (userRol != null && userRol.equals("ADMIN")) {
            ModelAndView model = new ModelAndView("supplier/editSupplier");
            Proveedor proveedor = proveedorService.getById(id);
            List<Ciudad> listCities =ciudadRepository.findAll();
            modelo.addAttribute("listCities", listCities);
            model.addObject("proveedor", proveedor);
            return model;
        } else {
            return error;
        }
    }


    @GetMapping("/prueba")
    public List<Proveedor> getSuppliers() {
        return proveedorService.getSuppliers();
    }


    @GetMapping("/getSupplierId/{idSupplier}")
    public Optional<Proveedor> getSupplierById(@PathVariable("idSupplier") int idSupplier) {
        return proveedorService.getSupplierById(idSupplier);
    }

    @PostMapping()
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


