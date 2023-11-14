package org.codelab.softwaresol.controllers;

import org.codelab.softwaresol.model.entities.cliente.Cliente;
import org.codelab.softwaresol.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> obtenerClientes(){
        return clienteService.obtenerClientes();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Cliente createCliente(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

    @PutMapping
    public Cliente update(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

    @DeleteMapping("/{idCliente}")
    public void deleteById(@PathVariable("idCliente") int idCliente){
        clienteService.delete(idCliente);
    }
}
