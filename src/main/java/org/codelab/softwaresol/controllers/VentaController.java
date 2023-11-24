package org.codelab.softwaresol.controllers;

import org.codelab.softwaresol.model.entities.Venta;
import org.codelab.softwaresol.model.entities.cliente.Cliente;
import org.codelab.softwaresol.model.entities.detalles.DetalleVenta;
import org.codelab.softwaresol.model.entities.producto.Producto;
import org.codelab.softwaresol.model.entities.repos.ClienteRepository;
import org.codelab.softwaresol.model.entities.repos.DetalleVentaRepository;
import org.codelab.softwaresol.model.entities.repos.ProductoRepository;
import org.codelab.softwaresol.services.ProductoService;
import org.codelab.softwaresol.services.VentaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger log = LoggerFactory.getLogger(VentaController.class);

    @Autowired
    private ProductoService productoService;
    @Autowired
    private VentaService ventaService;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private DetalleVentaRepository detalleVentaRepository;
    @Autowired
    private ProductoRepository productoRepository;


    @GetMapping("/getSales")
    public String getSales(Model model) {
        List<Venta> listSales = ventaService.getVentas();
        List<DetalleVenta> listDetalle = detalleVentaRepository.findAll();
        model.addAttribute("listSales", listSales);
        model.addAttribute("listDetalle", listDetalle);

        return "sale/showSale";
    }

    @GetMapping(value = "/agregar")
    public String createSale(Model model) {
        Venta venta = new Venta();
        List<Cliente> listClients = clienteRepository.findAll();
        List<Producto> listProducts = productoService.obtenerProductos();
        List<DetalleVenta> listDetalle = detalleVentaRepository.findAll();
        model.addAttribute("listDetalle", listDetalle);
        model.addAttribute("venta", venta);
        model.addAttribute("listClients", listClients);
        model.addAttribute("listProducts", listProducts);

        return "sale/crearVenta";
    }


    @PostMapping(value = "/agregar")
    public String saveSale(@ModelAttribute Venta venta,
                           @RequestParam("productoIds") List<Integer> productoIds,
                           @RequestParam("cantidades") List<Integer> cantidades) {
        // Guardar la venta en la base de datos
        Venta savedVenta = ventaService.createVenta(venta);
        int totalVenta = 0;

        // Crear y asociar los detalles de venta con la venta guardada
        for (int i = 0; i < productoIds.size(); i++) {
            Integer productoId = productoIds.get(i);
            Integer cantidad = cantidades.get(i);

            Optional<Producto> producto = productoService.obtenerProducto(productoId);
            DetalleVenta detalle = new DetalleVenta();
            detalle.setIdVenta(savedVenta);
            detalle.setIdProd(producto.get());
            detalle.setCantidad(cantidad);
            int subtotal = producto.get().getPrecioVenta() * cantidad;
            detalle.setSubtotal(subtotal);
            // Puedes establecer otros atributos del detalle de venta según sea necesario
            detalleVentaRepository.save(detalle);
            totalVenta += subtotal;
        }
        ventaService.getByIdAndUpdateTotal(savedVenta.getId(), totalVenta);

        return "redirect:/api/sale/factura/" +savedVenta.getId();
    }


    @RequestMapping("/factura/{id}")
    public ModelAndView showFactura(@PathVariable(name = "id") int id) {
        ModelAndView model = new ModelAndView("sale/factura");
        Venta venta = ventaService.getById(id);
        List<DetalleVenta> detalles =  detalleVentaRepository.findByIdVenta(id);

        model.addObject("venta", venta);
        model.addObject("detalles", detalles);

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
