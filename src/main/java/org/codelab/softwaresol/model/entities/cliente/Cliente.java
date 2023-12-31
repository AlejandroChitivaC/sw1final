package org.codelab.softwaresol.model.entities.cliente;

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

    public Cliente(Integer id, String nombre, String nit, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
        this.estado = estado;
    }
    public Cliente() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}