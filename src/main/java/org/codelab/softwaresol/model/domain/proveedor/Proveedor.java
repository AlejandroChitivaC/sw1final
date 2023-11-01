package org.codelab.softwaresol.model.domain.proveedor;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.codelab.softwaresol.model.domain.Ciudad;

@Getter
@Setter
@Entity
@Table(name = "proveedor", indexes = {
        @Index(name = "id_ciudad", columnList = "id_ciudad")
})
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prov", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciudad")
    private Ciudad idCiudad;

    @Column(name = "nombre", length = 40)
    private String nombre;

    @Column(name = "nit", length = 25)
    private String nit;

    @Column(name = "correo", length = 25)
    private String correo;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "direccion", length = 30)
    private String direccion;

    @Column(name = "estado", length = 1)
    private String estado;

    public Proveedor(Integer id, Ciudad idCiudad, String nombre, String nit, String correo, String telefono, String direccion, String estado) {
        this.id = id;
        this.idCiudad = idCiudad;
        this.nombre = nombre;
        this.nit = nit;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
    }

    public Proveedor() {
    }
}