package org.codelab.softwaresol.model.domain.repos;

import org.codelab.softwaresol.model.domain.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Integer> {
}