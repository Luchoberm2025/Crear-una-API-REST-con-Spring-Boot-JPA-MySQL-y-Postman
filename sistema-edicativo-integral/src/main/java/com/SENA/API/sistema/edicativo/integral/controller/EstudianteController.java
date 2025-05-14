package com.SENA.API.sistema.edicativo.integral.controller;

import com.SENA.API.sistema.edicativo.integral.model.Estudiante;
import com.SENA.API.sistema.edicativo.integral.model.Programa;
import com.SENA.API.sistema.edicativo.integral.repository.EstudianteRepository;
import com.SENA.API.sistema.edicativo.integral.repository.ProgramaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Clase controladora para la gestión de estudiantes.
 * Proporciona endpoints REST para realizar operaciones CRUD sobre los estudiantes.
 * Incluye funcionalidades como listar, obtener por ID, crear, actualizar y eliminar estudiantes.
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteRepository estudianteRepository;
    private final ProgramaRepository programaRepository; // 🔹 Agregar el repositorio de programas

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Constructor de la clase.
     * Inyecta los repositorios de estudiantes y programas para interactuar con la base de datos.
     *
     * @param estudianteRepository Repositorio de estudiantes.
     * @param programaRepository Repositorio de programas.
     */
    @Autowired
    public EstudianteController(EstudianteRepository estudianteRepository, ProgramaRepository programaRepository) {
        this.estudianteRepository = estudianteRepository;
        this.programaRepository = programaRepository; // 🔹 Asignación del repositorio
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
        return estudianteRepository.findById(id).orElse(null);
    }

    /**
     * Endpoint para guardar un nuevo estudiante.
     *
     * @param estudiante Objeto Estudiante que se desea crear.
     * @return Objeto Estudiante creado.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estudiante crearEstudiante(@RequestBody Estudiante estudiante) {
        if (estudiante.getNombre() == null || estudiante.getNombre().isEmpty()) {
            throw new RuntimeException("El nombre del estudiante no puede estar vacío.");
        }

        if (estudiante.getApellido() == null || estudiante.getApellido().isEmpty()) {
            throw new RuntimeException("El apellido del estudiante no puede estar vacío.");
        }

        if (estudiante.getPrograma() != null && estudiante.getPrograma().getId() != null) {
            Programa programa = programaRepository.findById(estudiante.getPrograma().getId())
                    .orElseThrow(() -> new RuntimeException("Programa no encontrado con ID: " + estudiante.getPrograma().getId()));

            estudiante.setPrograma(programa);
        }

        return estudianteRepository.save(estudiante);
    }

    /**
     * Endpoint para actualizar un estudiante existente.
     *
     * @param id Identificador único del estudiante que se desea actualizar.
     * @return Objeto Estudiante actualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable Long id, @RequestBody Estudiante estudianteDetalles) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con ID: " + id));

        estudiante.setNombre(estudianteDetalles.getNombre());
        estudiante.setApellido(estudianteDetalles.getApellido());

        if (estudianteDetalles.getPrograma() != null && estudianteDetalles.getPrograma().getId() != null) {
            Programa programa = programaRepository.findById(estudianteDetalles.getPrograma().getId())
                    .orElseThrow(() -> new RuntimeException("Programa no encontrado con ID: " + estudianteDetalles.getPrograma().getId()));

            estudiante.setPrograma(programa);
        }

        Estudiante estudianteActualizado = estudianteRepository.save(estudiante);
        return ResponseEntity.ok(estudianteActualizado);
    }

    /**
     * Endpoint para eliminar un estudiante por su ID.
     *
     * @param id Identificador único del estudiante que se desea eliminar.
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> eliminarProfesor(@PathVariable Long id) {
        if (!estudianteRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudiante no encontrado con ID: " + id);
        }

        estudianteRepository.deleteById(id);
        return ResponseEntity.ok().body("Profesor eliminado correctamente.");
    }
}