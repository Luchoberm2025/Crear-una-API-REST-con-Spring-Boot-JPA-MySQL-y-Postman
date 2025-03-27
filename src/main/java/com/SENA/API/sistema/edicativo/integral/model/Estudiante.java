package com.SENA.API.sistema.edicativo.integral.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * Entidad que representa un estudiante en el sistema educativo integral.
 * Contiene información básica del estudiante, como nombre, apellido y los programas a los que está inscrito.
 */
@Entity
public class Estudiante {

    /**
     * Identificador único del estudiante.
     * Generado automáticamente por la base de datos mediante estrategia de identidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del estudiante.
     */
    private String nombre;

    /**
     * Apellido del estudiante.
     */
    private String apellido;

    /**
     * Lista de programas asociados al estudiante.
     * Relación muchos-a-muchos entre estudiantes y programas.
     */
    @ManyToMany
    @JoinTable(
            name = "estudiante_programa",
            joinColumns = @JoinColumn(name = "estudiante_id"),
            inverseJoinColumns = @JoinColumn(name = "programa_id"))
    private List<Programa> programas;

    // Getters y Setters

    /**
     * Obtiene el identificador único del estudiante.
     *
     * @return ID del estudiante.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del estudiante.
     *
     * @param id ID que se desea asignar al estudiante.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del estudiante.
     *
     * @return Nombre del estudiante.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del estudiante.
     *
     * @param nombre Nombre que se desea asignar al estudiante.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del estudiante.
     *
     * @return Apellido del estudiante.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del estudiante.
     *
     * @param apellido Apellido que se desea asignar al estudiante.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene la lista de programas asociados al estudiante.
     *
     * @return Lista de programas.
     */
    public List<Programa> getProgramas() {
        return programas;
    }

    /**
     * Establece la lista de programas asociados al estudiante.
     *
     * @param programas Lista de programas que se desea asignar al estudiante.
     */
    public void setProgramas(List<Programa> programas) {
        this.programas = programas;
    }
}