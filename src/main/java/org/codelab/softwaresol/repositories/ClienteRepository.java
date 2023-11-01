package org.codelab.softwaresol.repositories;

import org.codelab.softwaresol.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}