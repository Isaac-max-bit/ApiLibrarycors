package com.library.apiLibrary.repositorios;

import com.library.apiLibrary.modelos.Reparacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReparacionRepositorio extends JpaRepository<Reparacion, Long> {
}
