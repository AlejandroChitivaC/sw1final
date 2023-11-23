package org.codelab.softwaresol.model.entities.repos;

import org.codelab.softwaresol.model.entities.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {


    Cliente findClienteByNit(String nit);

    @Override
    default void deleteById(Integer integer) {

    }
}