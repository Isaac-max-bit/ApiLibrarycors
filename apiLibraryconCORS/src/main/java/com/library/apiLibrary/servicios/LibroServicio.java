package com.library.apiLibrary.servicios;

import com.library.apiLibrary.modelos.Libro;
import com.library.apiLibrary.repositorios.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServicio {
    @Autowired
    private LibroRepositorio libroRepositorio;

    public LibroServicio(LibroRepositorio libroRepositorio) {
        this.libroRepositorio = libroRepositorio;
    }

    // Guardar libro

    /*public Libro saveLibro(Libro libro){
        return libroRepositorio.save(libro);
    }*/

    public Libro saveLibro(Libro libro) throws Exception {
        try {
            return libroRepositorio.save(libro);
        } catch (Exception e) {
            throw new Exception("No se pudo guardar el libro...");
        }
    }

    // Recuperar todos los libros
    /*public List<Libro> getLibros(){
        return libroRepositorio.findAll();
    }*/

    public List<Libro> getLibros() throws Exception {
        try {
            return this.libroRepositorio.findAll();
        } catch (Exception error) {
            throw new Exception("Error al obtener la lista de libros", error);
        }
    }


    // Crear el método para buscar libro por id
    /*public Optional<Libro> getLibroById(Long id){
        return libroRepositorio.findById(id);
    }*/
    public Libro getLibroPorId(Long id) throws Exception {
        try {
            Optional<Libro> libroBuscado = libroRepositorio.findById(id);
            if (libroBuscado.isPresent()) {
                return libroBuscado.get();
            } else {
                throw new Exception("No se encontró el libro con ID: " + id);
            }
        } catch (Exception e) {
            throw new Exception("Error al buscar el libro: " + e.getMessage(), e);
        }
    }

    // Método para buscar libro por nombre
    /*public List<Libro> buscarPorNombre(String nombre) {
        return libroRepositorio.findByNombre(nombre);
    }*/
    // Método para buscar libro por nombre parcial

    /*public List<Libro> buscarPorNombreParcial(String nombreParcial) {
        return libroRepositorio.findByNombreContainingIgnoreCase(nombreParcial);
    }*/
    public List<Libro> buscarPorNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del libro no puede estar vacío");
        }
        return libroRepositorio.findByNombreContainingIgnoreCase(nombre);
    }

    // Método para cambiar los datos de un libro con base en el id
    /*public Libro updateLibro(Long id, Libro libro){
        if (libroRepositorio.existsById(id)){
            libro.setId(id);
            return libroRepositorio.save(libro);
        }
        return null;
    }*/
    public Libro updateLibro(Long id, Libro datosNuevosLibro) throws Exception {
        try {
            Optional<Libro> libroExistente = libroRepositorio.findById(id);

            if (libroExistente.isPresent()) {
                Libro libroAEditar = libroExistente.get();
                libroAEditar.setNombre(datosNuevosLibro.getNombre());
                libroAEditar.setAutor(datosNuevosLibro.getAutor());

                return libroRepositorio.save(libroAEditar);
            } else {
                throw new Exception("Libro no encontrado con ID: " + id);
            }

        } catch (Exception e) {
            throw new Exception("Error al modificar el libro: " + e.getMessage(), e);
        }
    }



    //Método para eliminar un libro
    /*public void deleteLibro(Long id){
        libroRepositorio.deleteById(id);
    }*/
    public boolean deleteLibro(Long id) throws Exception {
        try {
            Optional<Libro> libroAEliminar = libroRepositorio.findById(id);
            if (libroAEliminar.isPresent()) {
                libroRepositorio.deleteById(id);
                return true;
            } else {
                throw new Exception("ID de Libro NO encontrado");
            }
        } catch (Exception e) {
            throw new Exception("Error al eliminar el libro: " + e.getMessage(), e);
        }
    }


}
