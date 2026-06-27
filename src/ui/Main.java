package ui;

import data.GestorServicios;
import model.ServicioTuristico;

public class Main {

    public static void main(String[] args) {

        GestorServicios gestor = new GestorServicios();
        ServicioTuristico[] servicios = gestor.crearServiciosDePrueba();

        System.out.println("=== Servicios turísticos - Llanquihue Tour ===");
        System.out.println();

        // Recorremos los servicios y mostramos cada uno con su toString()
        for (ServicioTuristico servicio : servicios) {
            System.out.println(servicio);
        }
    }
}
