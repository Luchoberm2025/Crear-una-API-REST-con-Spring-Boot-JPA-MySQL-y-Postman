package com.SENA.API.sistema.edicativo.integral.repository;

import com.SENA.API.sistema.edicativo.integral.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la entidad Estudiante.
 * Extiende JpaRepository para proporcionar métodos estándar de operaciones CRUD
 * (crear, leer, actualizar, eliminar) y consultas personalizadas si son necesarias.
 *
 * JpaRepository ya incluye métodos como save, findById, findAll, deleteById, entre otros.
 */
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}
