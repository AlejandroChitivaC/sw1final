package org.codelab.softwaresol.repos;

import org.codelab.softwaresol.model.domain.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Integer> {
}