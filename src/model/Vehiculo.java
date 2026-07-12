package model;

/**
 * Representa un vehículo de la agencia Llanquihue Tour, utilizado
 * para el traslado de turistas. Implementa Registrable para poder
 * ser gestionado junto a las demás entidades del sistema.
 */
public class Vehiculo implements Registrable {

    private String patente;
    private String marca;
    private String modelo;
    private int capacidad;

    public Vehiculo(String patente, String marca, String modelo, int capacidad) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidad = capacidad;
    }

    public String getPatente() {
        return patente;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("Vehículo: " + marca + " " + modelo
                + " | Patente: " + patente
                + " | Capacidad: " + capacidad + " pasajeros");
    }

    @Override
    public String obtenerResumen() {
        return "Vehículo: " + marca + " " + modelo
                + " | Patente: " + patente
                + " | Capacidad: " + capacidad + " pasajeros";
    }

}