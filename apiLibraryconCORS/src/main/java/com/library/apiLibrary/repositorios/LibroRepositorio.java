package com.library.apiLibrary.repositorios;

import com.library.apiLibrary.modelos.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepositorio extends JpaRepository<Libro, Long> {

    //List<Libro> findByNombre(String nombre);
    //List<Libro> findByNombreContainingIgnoreCase(String nombre);
    List<Libro> findByNombreContainingIgnoreCase(String nombre);
    //List<Libro> findByNombreContaining(String nombreParcial);
    /*
    List<Cliente> findByNombreCompletoContaining(String texto);        // LIKE %texto%
    List<Cliente> findByNombreCompletoStartsWith(String texto);        // LIKE texto%
    List<Cliente> findByNombreCompletoEndsWith(String texto);          // LIKE %texto

    List<Cliente> findByNombreCompletoAndCiudad(String nombre, String ciudad);
    List<Cliente> findByNombreCompletoOrCorreo(String nombre, String correo);

    List<Cliente> findByEdadGreaterThan(int edad);                     // >
    List<Cliente> findByEdadLessThanEqual(int edad);                   // <=
    List<Cliente> findByFechaRegistroBetween(Date start, Date end);    // BETWEEN fechas

    5. Ordenamientos

    List<Cliente> findByCiudadOrderByNombreCompletoAsc();
    List<Cliente> findByCiudadOrderByEdadDesc();
    6. Consultas booleanas

    List<Cliente> findByActivoTrue();     // Clientes activos
    List<Cliente> findByActivoFalse();    // Clientes inactivos
    7. Contar resultados

    Long countByCiudad(String ciudad);

    8. Eliminar por condición

    void deleteByNombreCompleto(String nombre);

    Personalización con @Query
    Cuando necesitas más control:


    @Query("SELECT c FROM Cliente c WHERE c.nombreCompleto LIKE %:nombre%")
    List<Cliente> buscarPorNombreParcial(@Param("nombre") String nombre);
     */
}
