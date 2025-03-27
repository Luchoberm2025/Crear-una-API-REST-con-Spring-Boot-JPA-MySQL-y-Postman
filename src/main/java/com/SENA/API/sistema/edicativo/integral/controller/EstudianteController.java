package com.SENA.API.sistema.edicativo.integral.controller;

import com.SENA.API.sistema.edicativo.integral.model.Estudiante;
import com.SENA.API.sistema.edicativo.integral.repository.EstudianteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Clase controladora para la gestión de estudiantes.
 * Proporciona endpoints REST para realizar operaciones CRUD sobre los estudiantes.
 * Estos incluyen listar, obtener por ID, crear, actualizar y eliminar estudiantes.
 */
@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteRepository estudianteRepository;

    /**
     * Constructor de la clase.
     * Inyecta el repositorio de estudiantes para interactuar con la base de datos.
     *
     * @param estudianteRepository Repositorio de estudiantes.
     */
    public EstudianteController(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    /**
     * Endpoint para obtener la lista de todos los estudiantes.
     *
     * @return Lista de objetos Estudiante.
     */
    @GetMapping
    public List<Estudiante> obtenerEstudiantes() {
        return estudianteRepository.findAll();
    }

    /**
     * Endpoint para obtener un estudiante por su ID.
     *
     * @param id Identificador único del estudiante.
     * @return Objeto Estudiante correspondiente al ID proporcionado o null si no se encuentra.
     */
    @GetMapping("/{id}")
    public Estudiante obtenerEstudiantePorId(@PathVariable Long id) {
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        return estudiante.orElse(null);
    }

    /**
     * Endpoint para guardar un nuevo estudiante.
     *
     * @param estudiante Objeto Estudiante que se desea crear.
     * @return Objeto Estudiante creado.
     */
        @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estudiante guardarEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    /**
     * Endpoint para actualizar un estudiante existente.
     *
     * @param id         Identificador único del estudiante que se desea actualizar.
     * @param estudiante Objeto Estudiante con los nuevos datos.
     * @return Objeto Estudiante actualizado.
     */
    @PutMapping("/{id}")
    public Estudiante actualizarEstudiante(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        estudiante.setId(id);
        return estudianteRepository.save(estudiante);
    }

    /**
     * Endpoint para eliminar un estudiante por su ID.
     *
     * @param id Identificador único del estudiante que se desea eliminar.
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarEstudiante(@PathVariable Long id) {
        estudianteRepository.deleteById(id);
    }
}
