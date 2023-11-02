package org.codelab.softwaresol.controllers;

import org.codelab.softwaresol.model.entities.Venta;
import org.codelab.softwaresol.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/venta")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public List<Venta> obtenerVentas() {
        return ventaService.getVentas();
    }

    @GetMapping("/{idVenta}")
    public Optional<Venta> obtenerVentaById(@PathVariable("idVenta") int idVenta) {
        return ventaService.getVenta(idVenta);
    }

    @PostMapping
    public Venta saveUpdateVenta(@RequestBody Venta venta) {
        ventaService.saveUpdateVenta(venta);
        return venta;
    }

    @DeleteMapping("/{idVenta}")
    public void deleteVenta(@PathVariable("idVenta") int idVenta) {
        ventaService.deleteVenta(idVenta);
    }
}
