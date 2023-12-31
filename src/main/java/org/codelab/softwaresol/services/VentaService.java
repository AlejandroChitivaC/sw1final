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
        return Optional.ofNullable(ventaRepository.findById(idVenta));
    }

    public Venta updateVenta(Venta venta){
        ventaRepository.save(venta);
        return venta;
    }

    public Venta createVenta(Venta venta){
        ventaRepository.save(venta);
        return venta;
    }

    public void deleteVenta(int idVenta){
        ventaRepository.deleteById(idVenta);
    }

    public Venta getByIdAndUpdateTotal(int id, int total) {
        Venta venta = ventaRepository.findById(id);
        if (venta != null) {
            venta.setTotalVenta(total);
            ventaRepository.save(venta);
        }
        return venta;
    }

    public Venta getById(int id) {
        return ventaRepository.findById(id);
    }
}
