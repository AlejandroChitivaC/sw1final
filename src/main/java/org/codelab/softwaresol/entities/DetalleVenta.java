package org.codelab.softwaresol.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "detalle_venta", indexes = {
        @Index(name = "id_venta", columnList = "id_venta"),
        @Index(name = "id_prod", columnList = "id_prod")
})
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_venta", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_venta")
    private Venta idVenta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prod")
    private Producto idProd;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "subtotal")
    private Integer subtotal;

}