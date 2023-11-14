package org.codelab.softwaresol.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "ciudad")
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ciudad", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_pais", nullable = false)
    @JsonIgnoreProperties
    private Pais pais;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    public Ciudad() {
    }

    public Ciudad(Integer id, Pais pais, String nombre) {
        this.id = id;
        this.pais = pais;
        this.nombre = nombre;
    }

    //Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
