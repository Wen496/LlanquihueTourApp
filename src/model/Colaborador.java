package model;

public class Colaborador {

    // Atributos privados (encapsulamiento)
    private String nombre;
    private String rut;
    private String rol;

    // COMPOSICIÓN: un Colaborador tiene una Direccion adentro
    private Direccion direccion;

    // Constructor vacío
    public Colaborador() {
    }

    // Constructor con parámetros
    public Colaborador(String nombre, String rut, String rol, Direccion direccion) {
        this.nombre = nombre;
        this.rut = rut;
        this.rol = rol;
        this.direccion = direccion;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    // Método toString para mostrar el colaborador como texto
    @Override
    public String toString() {
        return "Colaborador: " + nombre
                + " | RUT: " + rut
                + " | Rol: " + rol
                + " | Direccion: " + direccion;
    }
}