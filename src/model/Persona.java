package model;

/**
 * Clase base que representa a una persona relacionada con la agencia
 * (guía turístico, colaborador externo, etc.). Agrupa los datos
 * comunes que comparten estas entidades.
 */
public abstract class Persona {

    protected String nombre;
    protected String rut;
    protected String telefono;

    public Persona(String nombre, String rut, String telefono) {
        this.nombre = nombre;
        this.rut = rut;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRut() {
        return rut;
    }

    public String getTelefono() {
        return telefono;
    }

}