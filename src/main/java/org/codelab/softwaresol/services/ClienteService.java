package org.codelab.softwaresol.services;

import org.codelab.softwaresol.model.entities.cliente.Cliente;
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

    public Optional<Cliente> getClienteById(int idCliente){
        return clienteRepository.findById(idCliente);
    }

    public Cliente createCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public void deleteCliente (int idCliente){
        clienteRepository.deleteById(idCliente);
    }


    public Cliente findById(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }
}
