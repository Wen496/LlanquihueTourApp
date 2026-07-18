package model;

/**
 * Representa un vehiculo de la agencia Llanquihue Tour, utilizado para
 * el traslado de turistas entre los distintos puntos de la Region de
 * Los Lagos.
 *
 * Implementa Registrable para poder ser gestionado junto a las demas
 * entidades del sistema, aunque no sea una Persona: es precisamente
 * este caso el que justifica usar una interfaz en lugar de herencia,
 * ya que un vehiculo y un guia no comparten una raiz comun pero si
 * comparten el comportamiento de poder describirse a si mismos.
 *
 * @author Macarena Alvarez Saez
 */
public class Vehiculo implements Registrable {

    /** Patente del vehiculo */
    private String patente;

    /** Marca del vehiculo */
    private String marca;

    /** Modelo del vehiculo */
    private String modelo;

    /** Cantidad maxima de pasajeros que puede transportar */
    private int capacidad;

    /**
     * Crea un vehiculo con todos sus datos de identificacion.
     *
     * @param patente patente del vehiculo
     * @param marca marca del vehiculo
     * @param modelo modelo del vehiculo
     * @param capacidad cantidad maxima de pasajeros
     */
    public Vehiculo(String patente, String marca, String modelo, int capacidad) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidad = capacidad;
    }

    /**
     * Obtiene la patente del vehiculo.
     *
     * @return patente
     */
    public String getPatente() {
        return patente;
    }

    /**
     * Actualiza la patente del vehiculo.
     *
     * @param patente nueva patente
     */
    public void setPatente(String patente) {
        this.patente = patente;
    }

    /**
     * Obtiene la marca del vehiculo.
     *
     * @return marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Actualiza la marca del vehiculo.
     *
     * @param marca nueva marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtiene el modelo del vehiculo.
     *
     * @return modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Actualiza el modelo del vehiculo.
     *
     * @param modelo nuevo modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtiene la capacidad de pasajeros del vehiculo.
     *
     * @return cantidad maxima de pasajeros
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Actualiza la capacidad de pasajeros del vehiculo.
     *
     * @param capacidad nueva cantidad maxima de pasajeros
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Muestra por consola el resumen del vehiculo.
     * Implementacion propia del contrato definido en Registrable.
     */
    @Override
    public void mostrarResumen() {
        System.out.println(obtenerResumen());
    }

    /**
     * Devuelve el resumen del vehiculo como texto, para mostrarlo en
     * la interfaz grafica.
     *
     * @return descripcion breve del vehiculo
     */
    @Override
    public String obtenerResumen() {
        return "Vehiculo: " + marca + " " + modelo
                + " | Patente: " + patente
                + " | Capacidad: " + capacidad + " pasajeros";
    }

    /**
     * Representacion textual del vehiculo con todos sus datos.
     *
     * @return cadena con los datos completos del vehiculo
     */
    @Override
    public String toString() {
        return "[Vehiculo] " + marca + " " + modelo
                + " | Patente: " + patente
                + " | Capacidad: " + capacidad + " pasajeros";
    }
}
