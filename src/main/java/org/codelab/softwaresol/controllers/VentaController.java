package org.codelab.softwaresol.controllers;

import org.codelab.softwaresol.model.entities.Venta;
import org.codelab.softwaresol.model.entities.cliente.Cliente;
import org.codelab.softwaresol.model.entities.repos.ClienteRepository;
import org.codelab.softwaresol.services.ClienteService;
import org.codelab.softwaresol.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/sale")
public class VentaController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private VentaService ventaService;
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/getSales")
    public String getSales(Model model) {
        List<Venta> listSales = ventaService.getVentas();
        model.addAttribute("listSales", listSales);
        return "sale/showSale";
    }

    @GetMapping(value = "/agregar")
    public String createSale(Model model){
        Venta venta = new Venta();
        List<Cliente> listClients = clienteRepository.findAll();
        model.addAttribute("listClients", listClients);
        model.addAttribute("venta", venta);
        return "sale/createSale";
    }
    @PostMapping(value = "/agregar")
    public String saveSale(@ModelAttribute Venta venta){
        ventaService.createVenta(venta);
        return "redirect:/api/sale/getSales";
    }

    @RequestMapping("/editar/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id, Model modelo){
        ModelAndView model = new ModelAndView("sale/editSale");
        Venta venta = ventaService.getById(id);
        List<Cliente> listClients = clienteRepository.findAll();
        modelo.addAttribute("listClients", listClients);
        model.addObject("venta", venta);
        return model;
    }

    @GetMapping("/getAll")
    public List<Venta> obtenerVentas() {
        return ventaService.getVentas();
    }

    @GetMapping("/get{idVenta}")
    public Optional<Venta> obtenerVentaById(@PathVariable("idVenta") int idVenta) {
        return ventaService.getVenta(idVenta);
    }

    @PostMapping("/updateventa")
    public Venta saveUpdateVenta(@RequestBody Venta venta) {
        ventaService.updateVenta(venta);
        return venta;
    }

    @DeleteMapping("/{idVenta}")
    public void deleteVenta(@PathVariable("idVenta") int idVenta) {
        ventaService.deleteVenta(idVenta);
    }
}
