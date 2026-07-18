package model;

/**
 * Interfaz que define un comportamiento comun para todas las entidades
 * gestionables del sistema Llanquihue Tour (guias, vehiculos,
 * colaboradores externos, etc.).
 *
 * Actua como un contrato: cualquier clase que la implemente se
 * compromete a saber describirse a si misma, lo que permite tratar
 * entidades de distinto tipo bajo una misma referencia polimorfica.
 *
 * @author Macarena Alvarez Saez
 */
public interface Registrable {

    /**
     * Muestra un resumen de la entidad por consola. Cada clase que
     * implemente esta interfaz debe definir su propia version.
     */
    void mostrarResumen();

    /**
     * Devuelve un resumen de la entidad como texto, para mostrarlo
     * en la interfaz grafica.
     *
     * @return descripcion breve de la entidad
     */
    String obtenerResumen();
}
