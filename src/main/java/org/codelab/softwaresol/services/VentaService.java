package org.codelab.softwaresol.services;

import org.codelab.softwaresol.model.entities.Venta;
import org.codelab.softwaresol.model.entities.repos.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    @Autowired
    VentaRepository ventaRepository;

    public List<Venta> getVentas(){
        return ventaRepository.findAll();
    }

    public Optional<Venta> getVenta(int idVenta){
        return ventaRepository.findById(idVenta);
    }

    public Venta saveUpdateVenta(Venta venta){
        ventaRepository.save(venta);
        return venta;
    }

    public void deleteVenta(int idVenta){
        ventaRepository.deleteById(idVenta);
    }
}
