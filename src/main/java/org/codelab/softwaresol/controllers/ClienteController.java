package org.codelab.softwaresol.controllers;

import org.codelab.softwaresol.model.entities.cliente.Cliente;
import org.codelab.softwaresol.model.entities.producto.Producto;
import org.codelab.softwaresol.model.entities.repos.ClienteRepository;
import org.codelab.softwaresol.model.entities.repos.ProductoRepository;
import org.codelab.softwaresol.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;


    @GetMapping("/getClientes")
    public String showClientes(Model model) {
        List<Cliente> listClientes = clienteService.getClientes();
        model.addAttribute("listClientes", listClientes);
        return "static/web/users/showCliente.html";
    }

    @GetMapping("/getClientes2")
    public List<Cliente> listaClientes() {
        return this.clienteService.getClientes();
    }

    @GetMapping("/getCliente/{idCliente}")
    public Optional<Cliente> getClienteById(@PathVariable("idCliente") int idCliente) {
        return clienteService.getClienteById(idCliente);
    }

    @PostMapping("/addCliente")
    public Cliente createCliente(Cliente cliente) {
        clienteService.createCliente(cliente);
        return cliente;
    }

    @PutMapping("/updateCliente")
    public Cliente updateCliente(Cliente cliente) {
        clienteService.updateCliente(cliente);
        return cliente;
    }

    @DeleteMapping("/deleteCliente/{idCliente}")
    public void deleteCliente(@PathVariable("idCliente") int idCliente) {
        clienteService.deleteCliente(idCliente);
    }

}