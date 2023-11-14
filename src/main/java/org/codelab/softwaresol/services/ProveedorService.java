package org.codelab.softwaresol.services;

import org.codelab.softwaresol.model.entities.proveedor.Proveedor;
import org.codelab.softwaresol.model.entities.repos.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> obtener(){
        return proveedorRepository.findAll();
    }

    public Optional<Proveedor> obtenerPorId(int id) {
        return proveedorRepository.findById(id);
    }

    public Proveedor crear(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public Proveedor update(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public void delete(int id) {
        proveedorRepository.deleteById(id);
    }
}
