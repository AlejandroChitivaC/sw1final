package org.codelab.softwaresol.repositories;

import org.codelab.softwaresol.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}