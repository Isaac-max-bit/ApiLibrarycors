package com.library.apiLibrary.controladores;

import com.library.apiLibrary.modelos.Libro;
import com.library.apiLibrary.servicios.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/libros")
@CrossOrigin(origins = "*")
public class LibroControlador {
    @Autowired
    private LibroServicio libroServicio;

    // Guardar el libro
    @PostMapping
    /*public Libro createLibro(@RequestBody Libro libro) throws Exception{
        return libroServicio.saveLibro(libro);
    }*/

    public ResponseEntity<?> createLibro(@RequestBody Libro nuevolibro){
        try{

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.libroServicio.saveLibro(nuevolibro));

        }catch(Exception error){

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }
    // Recuperar todos los libros
    @GetMapping
    /*public List<Libro> getAllLibros() throws Exception{
        return libroServicio.getLibros();
    }*/
    public ResponseEntity<?> getAllLibros() {
        try {
            List<Libro> libros = libroServicio.getLibros();
            return ResponseEntity.ok(libros);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    /*public ResponseEntity<Libro> getBookById(@PathVariable Long id){
        Optional<Libro> libro = libroServicio.getLibroById(id);
        return libro.map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }*/
    public ResponseEntity<?> getLibroById(@PathVariable Long id) {
        try {
            Libro libro = libroServicio.getLibroPorId(id);
            return ResponseEntity.ok(libro);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Id de Libro NO encontrado");
        }
    }

    // Endpoint para buscar libros por nombre
    @GetMapping("/buscarnombre")
    /*public List<Libro> buscarLibrosPorNombre(@RequestParam String nombre) {
        if (!libroServicio.buscarPorNombre(nombre).isEmpty()){
            return libroServicio.buscarPorNombre(nombre);
        }
        return null;
    }*/
    public ResponseEntity<?> buscarLibrosPorNombre(@RequestParam String nombre) {
        try {
            List<Libro> libros = libroServicio.buscarPorNombre(nombre);
            if (libros.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No se encontraron libros con el nombre: " + nombre);
            }
            return ResponseEntity.ok(libros);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al buscar libros: " + e.getMessage());
        }
    }

    // Modificar los datos de un libro
    @PutMapping("/{id}")
    /*public Libro updateLibro(@PathVariable Long id, @RequestBody Libro libro){
        return libroServicio.updateLibro(id, libro);
    }*/
    public ResponseEntity<?> updateLibro(
            @PathVariable Long id,
            @RequestBody Libro datosNuevosLibro) {
        try {
            Libro libroModificado = libroServicio.updateLibro(id, datosNuevosLibro);
            return ResponseEntity.ok(libroModificado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id de libro no encontrado");
        }
    }
    // Eliminar un libro por id
    @DeleteMapping("/{id}")
    /*public void delLibro(@PathVariable Long id){
        libroServicio.deleteLibro(id);
    }*/
    public ResponseEntity<?> eliminarLibro(@PathVariable Long id) {
        try {
            boolean eliminado = libroServicio.deleteLibro(id);
            if (eliminado) {
                return ResponseEntity.ok("Libro eliminado correctamente");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Libro no encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());

        }
    }




}
