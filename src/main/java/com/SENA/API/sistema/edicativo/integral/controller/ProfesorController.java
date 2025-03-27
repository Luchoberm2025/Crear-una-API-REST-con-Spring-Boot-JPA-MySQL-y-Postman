package com.SENA.API.sistema.edicativo.integral.controller;

import com.SENA.API.sistema.edicativo.integral.model.Profesor;
import com.SENA.API.sistema.edicativo.integral.repository.ProfesorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Clase controladora para la gestión de profesores.
 * Proporciona endpoints REST para realizar operaciones CRUD sobre los profesores.
 * Incluye funcionalidades como listar, obtener por ID, crear, actualizar y eliminar profesores.
 */
@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    private final ProfesorRepository profesorRepository;

    /**
     * Constructor de la clase.
     * Inyecta el repositorio de profesores para interactuar con la base de datos.
     *
     * @param profesorRepository Repositorio de profesores.
     */
    public ProfesorController(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    /**
     * Endpoint para obtener la lista de todos los profesores.
     *
     * @return Lista de objetos Profesor.
     */
    @GetMapping
    public List<Profesor> obtenerProfesores() {
        return profesorRepository.findAll();
    }

    /**
     * Endpoint para obtener un profesor por su ID.
     *
     * @param id Identificador único del profesor.
     * @return Objeto Profesor correspondiente al ID proporcionado o null si no se encuentra.
     */
    @GetMapping("/{id}")
    public Profesor obtenerProfesorPorId(@PathVariable Long id) {
        Optional<Profesor> profesor = profesorRepository.findById(id);
        return profesor.orElse(null);
    }

    /**
     * Endpoint para guardar un nuevo profesor.
     *
     * @param profesor Objeto Profesor que se desea crear.
     * @return Objeto Profesor creado.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Profesor guardarProfesor(@RequestBody Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    /**
     * Endpoint para actualizar un profesor existente.
     *
     * @param id       Identificador único del profesor que se desea actualizar.
     * @param profesor Objeto Profesor con los nuevos datos.
     * @return Objeto Profesor actualizado.
     */
    @PutMapping("/{id}")
    public Profesor actualizarProfesor(@PathVariable Long id, @RequestBody Profesor profesor) {
        profesor.setId(id);
        return profesorRepository.save(profesor);
    }

    /**
     * Endpoint para eliminar un profesor por su ID.
     *
     * @param id Identificador único del profesor que se desea eliminar.
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarProfesor(@PathVariable Long id) {
        profesorRepository.deleteById(id);
    }
}
