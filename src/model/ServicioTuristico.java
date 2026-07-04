package model;

public class ServicioTuristico {

    // Atributos comunes a todos los servicios turísticos
    private String nombre;
    private int duracionHoras;

    // Constructor
    public ServicioTuristico(String nombre, int duracionHoras) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
    }

    // Getters y setters (encapsulamiento)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    // Método polimórfico: implementación base.
    // Las subclases lo sobrescriben para mostrar su información específica.
    public void mostrarInformacion() {
        System.out.println("Servicio: " + nombre + " | Duración: " + duracionHoras + " horas");
    }

    // toString base: las subclases lo extienden con super.toString()
    @Override
    public String toString() {
        return "Servicio: " + nombre + " | Duración: " + duracionHoras + " horas";
    }
}