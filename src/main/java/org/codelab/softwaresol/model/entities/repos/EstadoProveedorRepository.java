package org.codelab.softwaresol.model.entities.repos;

import org.codelab.softwaresol.model.entities.proveedor.EstadoProveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoProveedorRepository extends JpaRepository<EstadoProveedor, Integer> {
}