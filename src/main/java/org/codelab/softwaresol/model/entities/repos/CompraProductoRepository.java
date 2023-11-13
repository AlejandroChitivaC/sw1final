package org.codelab.softwaresol.model.entities.repos;

import org.codelab.softwaresol.model.entities.CompraProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraProductoRepository extends JpaRepository<CompraProducto, Integer> {
}