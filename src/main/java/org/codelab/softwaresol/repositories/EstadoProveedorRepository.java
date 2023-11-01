package org.codelab.softwaresol.repositories;

import org.codelab.softwaresol.entities.EstadoProveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoProveedorRepository extends JpaRepository<EstadoProveedor, Integer> {
}