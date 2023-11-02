package org.codelab.softwaresol.model.domain.repos;

import org.codelab.softwaresol.model.domain.proveedor.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
}