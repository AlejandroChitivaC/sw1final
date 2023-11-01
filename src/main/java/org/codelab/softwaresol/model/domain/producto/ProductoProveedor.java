package org.codelab.softwaresol.model.domain.producto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.codelab.softwaresol.model.domain.proveedor.Proveedor;

@Getter
@Setter
@Entity
@Table(name = "producto_proveedor", indexes = {
        @Index(name = "id_prod", columnList = "id_prod"),
        @Index(name = "id_prov", columnList = "id_prov")
})
public class ProductoProveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prod_prov", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prod")
    private Producto idProd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prov")
    private Proveedor idProv;

}