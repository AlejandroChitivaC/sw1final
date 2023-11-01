package org.codelab.softwaresol.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 60)
    private String nombre;

    @Column(name = "nit", length = 25)
    private String nit;

    @Column(name = "estado", length = 1)
    private String estado;

}
