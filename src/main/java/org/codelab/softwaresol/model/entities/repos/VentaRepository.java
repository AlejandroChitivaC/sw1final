package org.codelab.softwaresol.model.entities.repos;

import org.codelab.softwaresol.model.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Integer> {
}