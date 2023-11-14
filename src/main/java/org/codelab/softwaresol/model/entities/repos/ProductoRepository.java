package org.codelab.softwaresol.model.entities.repos;

import org.codelab.softwaresol.model.entities.producto.Producto;
import org.codelab.softwaresol.model.entities.user.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    Producto findProductosByNombreProducto (String producto);
}
