package org.codelab.softwaresol.model.entities.repos;

import org.codelab.softwaresol.model.entities.producto.ProductoProveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoProveedorRepository extends JpaRepository<ProductoProveedor, Integer> {
}