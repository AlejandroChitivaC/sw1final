package org.codelab.softwaresol.model.entities.repos;

import org.codelab.softwaresol.model.entities.detalles.DetalleOrdenProveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleOrdenProveedorRepository extends JpaRepository<DetalleOrdenProveedor, Integer> {
}