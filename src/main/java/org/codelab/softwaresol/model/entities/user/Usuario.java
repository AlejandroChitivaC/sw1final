package org.codelab.softwaresol.model.entities.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Integer id;

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "`contraseña`", nullable = false, length = 30)
    private String contraseña;

    @Column(name = "primer_nombre", length = 20)
    private String primerNombre;

    @Column(name = "segundo_nombre", length = 20)
    private String segundoNombre;

    @Column(name = "primer_apellido", length = 20)
    private String primerApellido;

    @Column(name = "segundo_apellido", length = 20)
    private String segundoApellido;

    @Column(name = "estado", length = 1)
    private String estado;

    @Column(name = "rol", nullable = false, length = 25)
    private String rol;

    public String getPassword() {
        return contraseña;
    }
}