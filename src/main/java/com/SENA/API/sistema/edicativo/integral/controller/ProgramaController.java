package com.SENA.API.sistema.edicativo.integral.controller;

import com.SENA.API.sistema.edicativo.integral.model.Programa;
import com.SENA.API.sistema.edicativo.integral.repository.ProgramaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Clase controladora para la gestión de programas educativos.
 * Proporciona endpoints REST para realizar operaciones CRUD sobre los programas.
 * Incluye funcionalidades como listar, obtener por ID, crear, actualizar y eliminar programas.
 */
@RestController
@RequestMapping("/api/programas")
public class ProgramaController {

    private final ProgramaRepository programaRepository;

    /**
     * Constructor de la clase.
     * Inyecta el repositorio de programas para interactuar con la base de datos.
     *
     * @param programaRepository Repositorio de programas.
     */
    public ProgramaController(ProgramaRepository programaRepository) {
        this.programaRepository = programaRepository;
    }

    /**
     * Endpoint para obtener la lista de todos los programas educativos.
     *
     * @return Lista de objetos Programa.
     */
    @GetMapping
    public List<Programa> obtenerProgramas() {
        return programaRepository.findAll();
    }

    /**
     * Endpoint para obtener un programa por su ID.
     *
     * @param id Identificador único del programa.
     * @return Objeto Programa correspondiente al ID proporcionado o null si no se encuentra.
     */
    @GetMapping("/{id}")
    public Programa obtenerProgramaPorId(@PathVariable Long id) {
        Optional<Programa> programa = programaRepository.findById(id);
        return programa.orElse(null);
    }

    /**
     * Endpoint para guardar un nuevo programa educativo.
     *
     * @param programa Objeto Programa que se desea crear.
     * @return Objeto Programa creado.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Programa guardarPrograma(@RequestBody Programa programa) {
        return programaRepository.save(programa);
    }

    /**
     * Endpoint para actualizar un programa existente.
     *
     * @param id       Identificador único del programa que se desea actualizar.
     * @param programa Objeto Programa con los nuevos datos.
     * @return Objeto Programa actualizado.
     */
    @PutMapping("/{id}")
    public Programa actualizarPrograma(@PathVariable Long id, @RequestBody Programa programa) {
        programa.setId(id);
        return programaRepository.save(programa);
    }

    /**
     * Endpoint para eliminar un programa por su ID.
     *
     * @param id Identificador único del programa que se desea eliminar.
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarPrograma(@PathVariable Long id) {
        programaRepository.deleteById(id);
    }
}
