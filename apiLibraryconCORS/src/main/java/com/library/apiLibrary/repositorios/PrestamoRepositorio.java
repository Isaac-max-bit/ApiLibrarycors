package com.library.apiLibrary.repositorios;

import com.library.apiLibrary.modelos.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepositorio extends JpaRepository <Prestamo, Long>{
}
