package org.codelab.softwaresol.model.entities.repos;

import org.codelab.softwaresol.model.entities.detalles.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Integer> {
}