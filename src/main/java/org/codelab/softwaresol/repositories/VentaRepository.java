package org.codelab.softwaresol.repositories;

import org.codelab.softwaresol.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Integer> {
}