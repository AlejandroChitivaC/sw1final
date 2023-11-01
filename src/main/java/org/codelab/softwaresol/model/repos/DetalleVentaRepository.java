package org.codelab.softwaresol.repos;

import org.codelab.softwaresol.model.domain.detalles.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Integer> {
}