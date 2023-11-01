package org.codelab.softwaresol.repositories;

import org.codelab.softwaresol.entities.DetalleCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleClienteRepository extends JpaRepository<DetalleCliente, Integer> {
}