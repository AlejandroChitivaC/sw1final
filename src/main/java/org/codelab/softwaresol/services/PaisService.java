package org.codelab.softwaresol.services;

import org.codelab.softwaresol.model.entities.Pais;
import org.codelab.softwaresol.model.entities.repos.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisService {

    @Autowired
    PaisRepository paisRepository;

    public List<Pais> obtenerPaises(){
        return paisRepository.findAll();
    }

    public Optional<Pais> obtenerPais(int id){
        return paisRepository.findById(id);
    }

    public Pais getPaisByID(int id){
        return paisRepository.findById(id).orElseThrow(() -> new RuntimeException("Pais no encontrado"));
    }

    public Pais createPais(Pais pais) {
        return paisRepository.save(pais);
    }

    public Pais updatePais(Pais pais) {
        return paisRepository.save(pais);
    }
    public Pais saveOrUpdate(Pais pais){
        return paisRepository.save(pais);
    }

    public void detelePais(int id){
        paisRepository.deleteById(id);
    }
}
