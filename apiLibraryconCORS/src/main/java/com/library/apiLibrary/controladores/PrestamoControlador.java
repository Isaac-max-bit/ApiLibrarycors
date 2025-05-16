package com.library.apiLibrary.controladores;

import com.library.apiLibrary.modelos.Prestamo;
import com.library.apiLibrary.servicios.PrestamoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
public class PrestamoControlador {
    @Autowired
    private PrestamoServicio prestamoServicio;
    // Recuperar todos los prestamos
    @GetMapping
    public List<Prestamo> getAllPrestamos(){
        return prestamoServicio.getPrestamos();
    }
    // Agregar un prestamo
    @PostMapping
    public Prestamo savePrestamo(@RequestBody Prestamo prestamo){
        return prestamoServicio.createPrestamo(prestamo);
    }
    // Eliminar un prestamo
    @DeleteMapping("/{id}")
    public void delPrestamo(@PathVariable Long id){
        prestamoServicio.deletePrestamoPorId(id);
    }
}
