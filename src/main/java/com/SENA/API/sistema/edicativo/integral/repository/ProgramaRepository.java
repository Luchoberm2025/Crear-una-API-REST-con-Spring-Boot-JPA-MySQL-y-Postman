package com.SENA.API.sistema.edicativo.integral.repository;

import com.SENA.API.sistema.edicativo.integral.model.Programa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la entidad Programa.
 * Extiende JpaRepository para proporcionar métodos estándar de operaciones CRUD
 * (crear, leer, actualizar, eliminar) y permite consultas personalizadas.
 *
 * Al heredar de JpaRepository, se incluyen métodos como save, findById, findAll, deleteById, entre otros,
 * facilitando la interacción con la base de datos.
 */
public interface ProgramaRepository extends JpaRepository<Programa, Long> {
}
