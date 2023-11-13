package org.codelab.softwaresol.services;

import org.codelab.softwaresol.model.entities.CompraProducto;
import org.codelab.softwaresol.model.entities.repos.CompraProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {
    @Autowired
    private CompraProductoRepository compraProductoRepository;

    public List<CompraProducto> getCompras(){
        return compraProductoRepository.findAll();
    }

    public Optional<CompraProducto> getCompra(int idCompra){
        return compraProductoRepository.findById(idCompra);
    }

    public CompraProducto createCompra(CompraProducto compra){
        compraProductoRepository.save(compra);
        return compra;
    }

    public CompraProducto updateCompra(CompraProducto compra){
        compraProductoRepository.save(compra);
        return compra;
    }

    public void deleteCompra(int idCompra){
        compraProductoRepository.deleteById(idCompra);
    }
}
