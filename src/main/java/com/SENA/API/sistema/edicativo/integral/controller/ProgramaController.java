package com.SENA.API.sistema.edicativo.integral.controller;

import com.SENA.API.sistema.edicativo.integral.model.Programa;
import com.SENA.API.sistema.edicativo.integral.repository.ProgramaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/programas")
public class ProgramaController {

    private final ProgramaRepository programaRepository;

    public ProgramaController(ProgramaRepository programaRepository) {
        this.programaRepository = programaRepository;
    }

    @GetMapping
    public List<Programa> obtenerProgramas() {
        return programaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Programa obtenerProgramaPorId(@PathVariable Long id) {
        Optional<Programa> programa = programaRepository.findById(id);
        return programa.orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Programa guardarPrograma(@RequestBody Programa programa) {
        return programaRepository.save(programa);
    }

    @PutMapping("/{id}")
    public Programa actualizarPrograma(@PathVariable Long id, @RequestBody Programa programa) {
        programa.setId(id);
        return programaRepository.save(programa);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarPrograma(@PathVariable Long id) {
        programaRepository.deleteById(id);
    }
}
