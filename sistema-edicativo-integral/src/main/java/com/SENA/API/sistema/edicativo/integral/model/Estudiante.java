package com.SENA.API.sistema.edicativo.integral.model;

import jakarta.persistence.*;

/**
 * Entidad que representa un estudiante en el sistema educativo integral.
 * Contiene información básica del estudiante, como su nombre, apellido, email,
 * fecha de ingreso, semestre y el programa educativo asociado.
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
     * Email del estudiante.
     */
    private String email;

    /**
     * Fecha de ingreso del estudiante.
     */
    private String fecha_ingreso;

    /**
     * Semestre actual del estudiante.
     */
    private int semestre;

    /**
     * Programa educativo asociado al estudiante.
     * Relación muchos-a-uno con la entidad Programa.
     * Esta relación indica que varios estudiantes pueden estar asociados a un programa.
     */
    @ManyToOne
    @JoinColumn(name = "programa_id")
    private Programa programa;

    // 🔹 Constructor vacío requerido por Hibernate
    public Estudiante() {}

    public Estudiante(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

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
     * Obtiene el email del estudiante.
     *
     * @return Email del estudiante.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el email del estudiante.
     *
     * @param email Email que se desea asignar al estudiante.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la fecha de ingreso del estudiante.
     *
     * @return Fecha de ingreso del estudiante.
     */
    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    /**
     * Establece la fecha de ingreso del estudiante.
     *
     * @param fecha_ingreso Fecha de ingreso que se desea asignar al estudiante.
     */
    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    /**
     * Obtiene el semestre actual del estudiante.
     *
     * @return Semestre del estudiante.
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * Establece el semestre actual del estudiante.
     *
     * @param semestre Semestre que se desea asignar al estudiante.
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    /**
     * Obtiene el programa educativo asociado al estudiante.
     *
     * @return Objeto Programa asociado al estudiante.
     */
    public Programa getPrograma() {
        return programa;
    }

    /**
     * Establece el programa educativo asociado al estudiante.
     *
     * @param programa Objeto Programa que se desea asignar al estudiante.
     */
    public void setPrograma(Programa programa) {
        this.programa = programa;
    }
}
