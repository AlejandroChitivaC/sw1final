package org.codelab.softwaresol.model.entities.repos;

import org.codelab.softwaresol.model.entities.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}