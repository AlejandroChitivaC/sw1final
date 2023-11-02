package org.codelab.softwaresol.model.entities.repos;

import org.codelab.softwaresol.model.entities.proveedor.OrdenProveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenProveedorRepository extends JpaRepository<OrdenProveedor, Integer> {
}