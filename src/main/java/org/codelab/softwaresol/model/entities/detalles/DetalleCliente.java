package org.codelab.softwaresol.model.entities.detalles;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.codelab.softwaresol.model.entities.Ciudad;
import org.codelab.softwaresol.model.entities.cliente.Cliente;

@Getter
@Setter
@Entity
@Table(name = "detalle_cliente")
public class DetalleCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_cliente", nullable = false)
    private Integer id;

    @Column(name = "correo", length = 25)
    private String correo;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "direccion", length = 30)
    private String direccion;

    @Column(name = "estado", length = 1)
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciudad")
    private Ciudad idCiudad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente_deta")
    private Cliente idClienteDeta;

}