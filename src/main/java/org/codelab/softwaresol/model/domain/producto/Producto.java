package org.codelab.softwaresol.model.domain.producto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prod", nullable = false)
    private Integer id;

    @Column(name = "nombre_producto", length = 50)
    private String nombreProducto;

    @Column(name = "precio_venta")
    private Integer precioVenta;

    @Column(name = "stock_min")
    private Integer stockMin;

    @Column(name = "stock_max")
    private Integer stockMax;

    @Column(name = "existencia")
    private Integer existencia;

    @Column(name = "estado", length = 1)
    private String estado;

    public Producto(Integer id, String nombreProducto, Integer precioVenta, Integer stockMin, Integer stockMax, Integer existencia, String estado) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.precioVenta = precioVenta;
        this.stockMin = stockMin;
        this.stockMax = stockMax;
        this.existencia = existencia;
        this.estado = estado;
    }

    public Producto() {
    }
}