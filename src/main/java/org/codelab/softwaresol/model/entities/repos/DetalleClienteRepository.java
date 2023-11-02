package org.codelab.softwaresol.model.entities.repos;

import org.codelab.softwaresol.model.entities.detalles.DetalleCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleClienteRepository extends JpaRepository<DetalleCliente, Integer> {
}