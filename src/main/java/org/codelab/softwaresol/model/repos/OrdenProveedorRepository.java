package org.codelab.softwaresol.repos;

import org.codelab.softwaresol.model.domain.proveedor.OrdenProveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenProveedorRepository extends JpaRepository<OrdenProveedor, Integer> {
}