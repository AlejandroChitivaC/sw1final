package org.codelab.softwaresol.model.entities.repos;

import org.codelab.softwaresol.model.entities.producto.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
