package org.codelab.softwaresol.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.codelab.softwaresol.model.entities.producto.ProductoProveedor;
import org.codelab.softwaresol.model.entities.proveedor.OrdenProveedor;

@Getter
@Setter
@Entity
@Table(name = "compra_producto", schema = "bd_rosita")
public class CompraProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_orden_proveedor", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orden_proveedor")
    private OrdenProveedor idOrdenProveedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prod_prov")
    private ProductoProveedor idProdProv;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "precio_compra")
    private Integer precioCompra;

    @Column(name = "estado_compra", length = 1)
    private String estadoCompra;

}