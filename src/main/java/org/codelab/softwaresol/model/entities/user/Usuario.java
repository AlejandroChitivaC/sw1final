package org.codelab.softwaresol.model.entities.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.codelab.softwaresol.model.entities.repos.UsuarioRepository;

@Getter
@Setter
@Entity
@Table(name = "usuario", schema = "bd_rosita")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Integer id;

    @Column(name = "usuario", length = 50)
    private String usuario;

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


    @Column(name = "rol", length = 25)
    private String rol;

    public Usuario(Integer id, String usuario, String contraseña, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String estado, String rol) {
        this.id = id;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.estado = estado;
        this.rol = rol;
    }

    public Usuario() {

    }

    public String getPassword() {
        return contraseña;
    }

}