package com.SENA.API.sistema.edicativo.integral.model;

import jakarta.persistence.*;

import java.util.List;
/**
 * Entidad que representa un programa educativo en el sistema educativo integral.
 * Contiene información básica del programa, como su identificador único y su nombre.
 */
@Entity
public class Programa {

    /**
     * Identificador único del programa.
     * Generado automáticamente por la base de datos mediante estrategia de identidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del programa educativo.
     */
    private String nombre;

    @OneToMany(mappedBy = "programa")
    private List<Profesor> profesores;

        // Getters y Setters

    /**
     * Obtiene el identificador único del programa.
     *
     * @return ID del programa.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del programa.
     *
     * @param id ID que se desea asignar al programa.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del programa educativo.
     *
     * @return Nombre del programa.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del programa educativo.
     *
     * @param nombre Nombre que se desea asignar al programa.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
