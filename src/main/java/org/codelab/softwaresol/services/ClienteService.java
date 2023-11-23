package org.codelab.softwaresol.services;

import org.codelab.softwaresol.model.entities.cliente.Cliente;
import org.codelab.softwaresol.model.entities.producto.Producto;
import org.codelab.softwaresol.model.entities.repos.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getClientes(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getCliente (int idCliente){
        return clienteRepository.findById(idCliente);
    }

    public Cliente createCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente saveOrUpdate(Cliente cliente) {
        clienteRepository.save(cliente);
        return cliente;
    }

    public void deleteCliente (int idCliente){
        clienteRepository.deleteById(idCliente);
    }

    public Cliente getById(int id) {
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }
}