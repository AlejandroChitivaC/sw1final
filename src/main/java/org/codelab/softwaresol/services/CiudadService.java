package org.codelab.softwaresol.services;

import org.codelab.softwaresol.model.entities.Ciudad;
import org.codelab.softwaresol.model.entities.repos.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;

    public List<Ciudad> obtenerCiudades() {
        return ciudadRepository.findAll();
    }

    public Optional<Ciudad> obtenerCiudad(int id) {
        return ciudadRepository.findById(id);
    }

    public Ciudad crearCiudad(Ciudad ciudad) {
        return ciudadRepository.save(ciudad);
    }

    public Ciudad actualizarCiudad(Ciudad ciudad) {
        return ciudadRepository.save(ciudad);
    }

    public void eliminarCiudad(int id) {
        ciudadRepository.deleteById(id);
    }
}
