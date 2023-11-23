package org.codelab.softwaresol.model.entities.repos;

import org.codelab.softwaresol.model.entities.producto.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    Producto findProductosByNombreProducto (String producto);

    Producto findById(int idProducto);
}
