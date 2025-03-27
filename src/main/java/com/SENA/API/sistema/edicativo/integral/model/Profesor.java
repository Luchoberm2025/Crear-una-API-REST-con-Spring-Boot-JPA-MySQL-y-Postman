package com.SENA.API.sistema.edicativo.integral.model;

import jakarta.persistence.*;

/**
 * Entidad que representa un profesor en el sistema educativo integral.
 * Contiene información básica del profesor, como su nombre, apellido, especialización
 * y el programa educativo asociado.
 */
@Entity
public class Profesor {

    /**
     * Identificador único del profesor.
     * Generado automáticamente por la base de datos mediante estrategia de identidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del profesor.
     */
    private String nombre;

    /**
     * Apellido del profesor.
     */
    private String apellido;

    /**
     * Especialización del profesor.
     */
    private String especializacion;

    /**
     * Programa educativo asociado al profesor.
     * Relación muchos-a-uno con la entidad Programa.
     * Esta relación indica que varios profesores pueden estar asociados a un programa.
     */
    @ManyToOne
    @JoinColumn(name = "programa_id", nullable = false)
    private Programa programa;

    // Getters y Setters

    /**
     * Obtiene el identificador único del profesor.
     *
     * @return ID del profesor.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del profesor.
     *
     * @param id ID que se desea asignar al profesor.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del profesor.
     *
     * @return Nombre del profesor.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del profesor.
     *
     * @param nombre Nombre que se desea asignar al profesor.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del profesor.
     *
     * @return Apellido del profesor.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del profesor.
     *
     * @param apellido Apellido que se desea asignar al profesor.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene la especialización del profesor.
     *
     * @return Especialización del profesor.
     */
    public String getEspecializacion() {
        return especializacion;
    }

    /**
     * Establece la especialización del profesor.
     *
     * @param especializacion Especialización que se desea asignar al profesor.
     */
    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    /**
     * Obtiene el programa educativo asociado al profesor.
     *
     * @return Objeto Programa asociado al profesor.
     */
    public Programa getPrograma() {
        return programa;
    }

    /**
     * Establece el programa educativo asociado al profesor.
     *
     * @param programa Objeto Programa que se desea asignar al profesor.
     */
    public void setPrograma(Programa programa) {
        this.programa = programa;
    }
}