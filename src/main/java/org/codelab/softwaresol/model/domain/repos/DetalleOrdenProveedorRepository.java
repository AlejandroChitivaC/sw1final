package org.codelab.softwaresol.model.domain.repos;

import org.codelab.softwaresol.model.domain.detalles.DetalleOrdenProveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleOrdenProveedorRepository extends JpaRepository<DetalleOrdenProveedor, Integer> {
}