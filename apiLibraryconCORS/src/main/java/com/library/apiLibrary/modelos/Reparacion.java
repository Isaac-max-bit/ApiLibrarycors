package com.library.apiLibrary.modelos;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Reparacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;

    @OneToOne()
    @JoinColumn(referencedColumnName = "id")
    private Libro libro;



    public Reparacion() {
    }

    public Reparacion(Long id, LocalDate fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
