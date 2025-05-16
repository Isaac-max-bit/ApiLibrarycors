package com.library.apiLibrary.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String autor;

    @OneToMany(mappedBy = "libro", targetEntity = Prestamo.class, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Prestamo> prestamos;
    @OneToOne()
    private Reparacion reparacion;



    public Libro() {
    }

    public Libro(Long id, String nombre, String autor) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
