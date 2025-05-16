package com.library.apiLibrary.servicios;

import com.library.apiLibrary.modelos.Prestamo;
import com.library.apiLibrary.repositorios.LibroRepositorio;
import com.library.apiLibrary.repositorios.PrestamoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoServicio {
    @Autowired
    private PrestamoRepositorio prestamoRepositorio;

    public PrestamoServicio(PrestamoRepositorio prestamoRepositorio) {
        this.prestamoRepositorio = prestamoRepositorio;
    }

    public List<Prestamo> getPrestamos(){
        return prestamoRepositorio.findAll();
    }
    // Agregar un prestamo
    public Prestamo createPrestamo(Prestamo prestamo){
        return prestamoRepositorio.save(prestamo);
    }
    // Eliminar un préstamo por id
    public void deletePrestamoPorId(Long id){
        prestamoRepositorio.deleteById(id);
    }

}
