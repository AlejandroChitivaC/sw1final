package org.codelab.softwaresol.controllers;

import org.codelab.softwaresol.model.entities.cliente.Cliente;
import org.codelab.softwaresol.model.entities.producto.Producto;
import org.codelab.softwaresol.services.AuthService;
import org.codelab.softwaresol.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/api/client")
public class ClienteController {
    @Autowired
    private AuthController auth;

    @Autowired
    private AuthService authService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/getClients")
    public String getClientes(Model model) {
        String currentUser = auth.getCurrentUser();
        String username = authService.getUsername(currentUser);
        model.addAttribute("username", username);
        List<Cliente> listClients = clienteService.getClientes();
        model.addAttribute("listClients", listClients);
        return "Client/showClient";
    }

    @GetMapping(value = "/agregar")
    public String createClient(Model model){
        Cliente cliente = new Cliente();
        String currentUser = auth.getCurrentUser();
        String username = authService.getUsername(currentUser);
        model.addAttribute("username", username);
        model.addAttribute("cliente", cliente);
        return "Client/createClient";
    }

    @PostMapping(value = "/agregar")
    public String saveUser(@ModelAttribute Cliente cliente){
        clienteService.createCliente(cliente);
        //clienteService.saveOrUpdate(cliente);
        return "redirect:/api/Client/getClients";
    }

    @RequestMapping("/editar/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id, Model modelo){
        ModelAndView model = new ModelAndView("Client/editClient");
        String currentUser = auth.getCurrentUser();
        String username = authService.getUsername(currentUser);
        modelo.addAttribute("username", username);
        Cliente cliente = clienteService.getById(id);
        model.addObject("cliente", cliente);
        return model;
    }

/*    @DeleteMapping("/deleteClient/{idClient}")
    public void deleteClient(@PathVariable("idClient") int idClient) {
        clienteService.deleteCliente(idClient);
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


    @GetMapping("/getClientes2")
    public List<Cliente> listaClientes() {
        return this.clienteService.getClientes();
    }*/

}