package org.codelab.softwaresol.model.domain.repos;

import org.codelab.softwaresol.model.domain.detalles.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Integer> {
}