package com.SENA.API.sistema.edicativo.integral.controller;

import com.SENA.API.sistema.edicativo.integral.model.Profesor;
import com.SENA.API.sistema.edicativo.integral.model.Programa;
import com.SENA.API.sistema.edicativo.integral.repository.ProfesorRepository;
import com.SENA.API.sistema.edicativo.integral.repository.ProgramaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/**
 * Clase controladora para la gestión de profesores.
 * Proporciona endpoints REST para realizar operaciones CRUD sobre los profesores.
 * Incluye funcionalidades como listar, obtener por ID, crear, actualizar y eliminar profesores.
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    private final ProfesorRepository profesorRepository;
    private final ProgramaRepository programaRepository; // 🔹 Agregar el repositorio de programas

    /**
     * Constructor de la clase.
     * Inyecta los repositorios de profesores y programas para interactuar con la base de datos.
     *
     * @param profesorRepository Repositorio de profesores.
     * @param programaRepository Repositorio de programas.
     */
    @Autowired
    public ProfesorController(ProfesorRepository profesorRepository, ProgramaRepository programaRepository) {
        this.profesorRepository = profesorRepository;
        this.programaRepository = programaRepository; // 🔹 Asignación del repositorio
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
        return profesorRepository.findById(id).orElse(null);
    }

    /**
     * Endpoint para guardar un nuevo profesor.
     *
     * @param profesor Objeto Profesor que se desea crear.
     * @return Objeto Profesor creado.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Profesor crearProfesor(@RequestBody Profesor profesor) {
        if (profesor.getFecha_contratacion() == null || profesor.getFecha_contratacion().isEmpty()) {
            profesor.setFecha_contratacion("2025-01-01"); // 🔹 Asignar fecha por defecto si es NULL
        }
        return profesorRepository.save(profesor);
    }

    /**
     * Endpoint para actualizar un profesor existente.
     *
     * @param id Identificador único del profesor que se desea actualizar.
     * @return Objeto Profesor actualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Profesor> actualizarProfesor(@PathVariable Long id, @RequestBody Profesor profesorDetalles) {
        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado con ID: " + id));

        profesor.setNombre(profesorDetalles.getNombre());
        profesor.setApellido(profesorDetalles.getApellido());
        profesor.setEspecializacion(profesorDetalles.getEspecializacion());

        if (profesorDetalles.getFecha_contratacion() != null && !profesorDetalles.getFecha_contratacion().isEmpty()) {
            profesor.setFecha_contratacion(profesorDetalles.getFecha_contratacion());
        }

        if (profesorDetalles.getPrograma() != null && profesorDetalles.getPrograma().getId() != null) {
            Programa programa = programaRepository.findById(profesorDetalles.getPrograma().getId())
                    .orElseThrow(() -> new RuntimeException("Programa no encontrado con ID: " + profesorDetalles.getPrograma().getId()));

            profesor.setPrograma(programa);
        }

        Profesor profesorActualizado = profesorRepository.save(profesor);
        return ResponseEntity.ok(profesorActualizado);
    }

    /**
     * Endpoint para eliminar un profesor por su ID.
     *
     * @param id Identificador único del profesor que se desea eliminar.
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> eliminarProfesor(@PathVariable Long id) {
        if (!profesorRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profesor no encontrado con ID: " + id);
        }

        profesorRepository.deleteById(id);
        return ResponseEntity.ok().body("Profesor eliminado correctamente.");
    }
}