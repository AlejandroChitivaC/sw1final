package org.codelab.softwaresol.repositories;

import org.codelab.softwaresol.entities.DetalleOrdenProveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleOrdenProveedorRepository extends JpaRepository<DetalleOrdenProveedor, Integer> {
}