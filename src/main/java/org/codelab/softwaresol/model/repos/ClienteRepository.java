package org.codelab.softwaresol.model.repos;

import org.codelab.softwaresol.model.domain.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Override
    default Optional<Cliente> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    default void deleteById(Integer integer) {

    }
}