package org.codelab.softwaresol.services;

import org.codelab.softwaresol.model.entities.Venta;
import org.codelab.softwaresol.model.entities.detalles.DetalleVenta;
import org.codelab.softwaresol.model.entities.repos.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleVentaService {

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    public DetalleVenta createDetalleVenta(DetalleVenta detalleVenta){
        detalleVentaRepository.save(detalleVenta);
        return detalleVenta;
    }
}
