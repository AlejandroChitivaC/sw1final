package org.codelab.softwaresol.model.domain.repos;

import org.codelab.softwaresol.model.domain.proveedor.OrdenProveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenProveedorRepository extends JpaRepository<OrdenProveedor, Integer> {
}