package org.codelab.softwaresol.model.domain.proveedor;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.codelab.softwaresol.model.domain.proveedor.EstadoProveedor;
import org.codelab.softwaresol.model.domain.proveedor.Proveedor;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "orden_proveedor", indexes = {
        @Index(name = "id_prov", columnList = "id_prov"),
        @Index(name = "id_estado", columnList = "id_estado")
})
public class OrdenProveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden_proveedor", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prov")
    private Proveedor idProv;

    @Column(name = "fecha_orden")
    private LocalDate fechaOrden;

    @Column(name = "fecha_orden_recibida")
    private LocalDate fechaOrdenRecibida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    private EstadoProveedor idEstado;

}