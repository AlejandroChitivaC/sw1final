package org.codelab.softwaresol.services;

import org.codelab.softwaresol.model.entities.proveedor.Proveedor;
import org.codelab.softwaresol.model.entities.repos.ProveedorRepository;
import org.codelab.softwaresol.model.entities.user.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> getSuppliers() {
        return proveedorRepository.findAll();
    }

    public Optional<Proveedor> getSupplierById(int idSupplier) {
        return proveedorRepository.findById(idSupplier);
    }

    public Proveedor createSupplier(Proveedor proveedor) {
        proveedorRepository.save(proveedor);
        return proveedor;
    }

    public Proveedor updateSupplier(Proveedor proveedor) {
        proveedorRepository.save(proveedor);
        return proveedor;
    }

    public void deleteSupplier(int idSupplier) {
        proveedorRepository.deleteById(idSupplier);
    }

    public Proveedor getById(int id){
        return proveedorRepository.findById(id).get();
    }
}