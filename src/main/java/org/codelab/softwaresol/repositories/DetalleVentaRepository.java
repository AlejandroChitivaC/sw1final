package org.codelab.softwaresol.repositories;

import org.codelab.softwaresol.entities.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Integer> {
}