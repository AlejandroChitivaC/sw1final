package org.codelab.softwaresol.model.domain.repos;

import org.codelab.softwaresol.model.domain.detalles.DetalleCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleClienteRepository extends JpaRepository<DetalleCliente, Integer> {
}