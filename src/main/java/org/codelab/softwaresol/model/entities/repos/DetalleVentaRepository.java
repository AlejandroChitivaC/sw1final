package org.codelab.softwaresol.model.entities.repos;

import org.codelab.softwaresol.model.entities.detalles.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Integer> {
    @Query("SELECT dv FROM DetalleVenta dv WHERE dv.idVenta.id = :idVenta")
    List<DetalleVenta> findByIdVenta(@Param("idVenta") Integer idVenta);
}