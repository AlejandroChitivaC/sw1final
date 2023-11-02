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
        @Index(name = "id_cliente", columnList = "id_cliente")
})
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente idCliente;

    @Column(name = "fecha_venta")
    private LocalDate fechaVenta;

    @Column(name = "total_venta")
    private Integer totalVenta;

    public Venta(Integer id, Cliente idCliente, LocalDate fechaVenta, Integer totalVenta) {
        this.id = id;
        this.idCliente = idCliente;
        this.fechaVenta = fechaVenta;
        this.totalVenta = totalVenta;
    }
}