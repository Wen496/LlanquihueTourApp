package ui;

import data.GestorServicios;
import model.ServicioTuristico;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        GestorServicios gestor = new GestorServicios();
        List<ServicioTuristico> servicios = gestor.crearServiciosDePrueba();

        System.out.println("=== Servicios turísticos - Llanquihue Tour ===");
        System.out.println();

        // Recorremos la colección con for-each aplicando polimorfismo:
        // cada referencia es de tipo ServicioTuristico, pero se ejecuta
        // la versión sobrescrita de mostrarInformacion() según el objeto real.
        for (ServicioTuristico servicio : servicios) {
            servicio.mostrarInformacion();
        }

        // === Semana 8: se lanza la interfaz gráfica de gestión de entidades ===
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.iniciar();
    }

}