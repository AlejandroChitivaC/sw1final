package org.codelab.softwaresol.model.domain.repos;

import org.codelab.softwaresol.model.domain.producto.ProductoProveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoProveedorRepository extends JpaRepository<ProductoProveedor, Integer> {
}