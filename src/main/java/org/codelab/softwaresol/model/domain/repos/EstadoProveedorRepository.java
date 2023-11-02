package org.codelab.softwaresol.model.domain.repos;

import org.codelab.softwaresol.model.domain.proveedor.EstadoProveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoProveedorRepository extends JpaRepository<EstadoProveedor, Integer> {
}