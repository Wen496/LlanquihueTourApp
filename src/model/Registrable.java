package model;

/**
 * Interfaz que define un comportamiento común para todas las entidades
 * gestionables del sistema Llanquihue Tour (guías, vehículos,
 * colaboradores externos, etc.).
 */
public interface Registrable {

    /**
     * Muestra un resumen de la entidad por consola. Cada clase que
     * implemente esta interfaz debe definir su propia versión.
     */
    void mostrarResumen();

    /**
     * Devuelve un resumen de la entidad como texto, para mostrarlo
     * en la interfaz gráfica.
     */
    String obtenerResumen();

}