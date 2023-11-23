package org.codelab.softwaresol.model.entities.detalles;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.codelab.softwaresol.model.entities.Venta;
import org.codelab.softwaresol.model.entities.producto.Producto;

@Getter
@Setter
@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_venta", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Venta idVenta;

    @ManyToOne
    @JoinColumn(name = "id_prod")
    private Producto idProd;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "subtotal")
    private Integer subtotal;

    @Column(name = "estado", length = 1)
    private String estado;

}