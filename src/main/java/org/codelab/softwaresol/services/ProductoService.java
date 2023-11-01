package org.codelab.softwaresol.services;

import org.codelab.softwaresol.entities.Producto;
import org.codelab.softwaresol.repositories.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    private ProductoRepository productoRepository;

    public List<Producto> obtenerDatosBd(){
        return productoRepository.findAll();

    }
}
