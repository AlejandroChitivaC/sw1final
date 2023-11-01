package org.codelab.softwaresol.repositories;

import org.codelab.softwaresol.entities.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
}