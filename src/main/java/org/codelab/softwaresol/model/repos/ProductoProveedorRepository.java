package org.codelab.softwaresol.repos;

import org.codelab.softwaresol.model.domain.producto.ProductoProveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoProveedorRepository extends JpaRepository<ProductoProveedor, Integer> {
}