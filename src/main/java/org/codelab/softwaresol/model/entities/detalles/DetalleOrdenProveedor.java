package org.codelab.softwaresol.model.entities.detalles;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.codelab.softwaresol.model.entities.proveedor.OrdenProveedor;
import org.codelab.softwaresol.model.entities.producto.ProductoProveedor;

@Getter
@Setter
@Entity
@Table(name = "detalle_orden_proveedor", indexes = {
        @Index(name = "id_orden_proveedor", columnList = "id_orden_proveedor"),
        @Index(name = "id_prod_prov", columnList = "id_prod_prov")
})
public class DetalleOrdenProveedor {
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

}