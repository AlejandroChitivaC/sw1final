package org.codelab.softwaresol.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.codelab.softwaresol.model.entities.cliente.Cliente;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "venta", indexes = {
@Index(name = "id_cliente", columnList = "cliente")
})
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    @Column(name = "fecha_venta")
    private LocalDate fechaVenta;

    @Column(name = "total_venta")
    private Integer totalVenta;

    public Venta(Integer id, Cliente cliente, LocalDate fechaVenta, Integer totalVenta) {
        this.id = id;
        this.cliente = cliente;
        this.fechaVenta = fechaVenta;
        this.totalVenta = totalVenta;
    }

    public Venta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Integer getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Integer totalVenta) {
        this.totalVenta = totalVenta;
    }
}