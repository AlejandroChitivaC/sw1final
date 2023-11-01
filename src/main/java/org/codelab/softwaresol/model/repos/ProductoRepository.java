package org.codelab.softwaresol.repos;

import org.codelab.softwaresol.model.domain.producto.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}