package org.codelab.softwaresol.services;

import
        org.codelab.softwaresol.model.entities.producto.Producto;
import org.codelab.softwaresol.model.entities.repos.ProductoRepository;
import org.codelab.softwaresol.model.entities.user.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public List<Producto> obtenerProductos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerProducto(int id) {
        return productoRepository.findById(id);
    }

    public Producto saveOrUpdate(Producto producto) {
        productoRepository.save(producto);
        return producto;
    }
    public void deleteProducto(int id) {
        productoRepository.deleteById(id);
    }

    public Producto getById(int id){
        return productoRepository.findById(id).get();
    }
}
