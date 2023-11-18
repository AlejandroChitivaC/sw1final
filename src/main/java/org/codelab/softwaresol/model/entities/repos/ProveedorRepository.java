package org.codelab.softwaresol.model.entities.repos;

import org.codelab.softwaresol.model.entities.proveedor.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
}