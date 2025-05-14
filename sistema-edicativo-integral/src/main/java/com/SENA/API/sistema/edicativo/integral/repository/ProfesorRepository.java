package com.SENA.API.sistema.edicativo.integral.repository;

import com.SENA.API.sistema.edicativo.integral.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Repositorio para la entidad Profesor.
 * Extiende JpaRepository para proporcionar métodos estándar de operaciones CRUD
 * (crear, leer, actualizar, eliminar) y consultas personalizadas si son necesarias.
 *
 * JpaRepository incluye métodos predefinidos como save, findById, findAll, deleteById, entre otros.
 * Esta interfaz permite interactuar fácilmente con la base de datos sin implementar métodos adicionales.
 */
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
