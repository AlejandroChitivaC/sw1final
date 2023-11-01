package org.codelab.softwaresol.repositories;

import org.codelab.softwaresol.entities.ProductoProveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoProveedorRepository extends JpaRepository<ProductoProveedor, Integer> {
}