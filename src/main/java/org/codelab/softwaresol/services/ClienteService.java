package org.codelab.softwaresol.services;

import org.codelab.softwaresol.model.entities.cliente.Cliente;
import org.codelab.softwaresol.model.entities.repos.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> obtenerClientes(){
        return clienteRepository.findAll();
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void delete(int id){
        clienteRepository.deleteById(id);
    }

}
