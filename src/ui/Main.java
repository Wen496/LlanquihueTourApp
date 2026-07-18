package ui;

import data.GestorServicios;
import data.LectorArchivos;
import java.util.List;
import model.ColaboradorExterno;
import model.GuiaTuristico;
import model.Persona;
import model.Registrable;
import model.ServicioTuristico;
import java.util.ArrayList;

/**
 * Clase principal del sistema LlanquihueTourApp.
 *
 * Carga las entidades del dominio desde archivos de texto plano,
 * demuestra el uso de colecciones, polimorfismo e instanceof, y
 * finalmente lanza la interfaz grafica de gestion.
 *
 * @author Macarena Alvarez Saez
 */
public class Main {

    /**
     * Punto de entrada de la aplicacion.
     *
     * @param args argumentos de linea de comandos (no utilizados)
     */
    public static void main(String[] args) {

        // === Carga de servicios turisticos desde archivo .txt ===
        GestorServicios gestor = new GestorServicios();
        List<ServicioTuristico> servicios = gestor.cargarDesdeArchivo("servicios.txt");

        System.out.println("=== Servicios turisticos - Llanquihue Tour ===");
        System.out.println("Servicios cargados desde archivo: " + servicios.size());
        System.out.println();

        // Recorremos la coleccion con for-each aplicando polimorfismo:
        // cada referencia es de tipo ServicioTuristico, pero se ejecuta
        // la version sobrescrita de mostrarInformacion() segun el objeto real.
        gestor.mostrarTodos();

        // Filtrado sobre la coleccion: servicios de 3 horas o menos
        System.out.println();
        System.out.println("=== Servicios cortos (hasta 3 horas) ===");
        for (ServicioTuristico servicio : gestor.filtrarPorDuracion(3)) {
            System.out.println(servicio);
        }

        // === Carga de colaboradores desde archivo .txt ===
        List<Persona> colaboradores = LectorArchivos.cargarColaboradores("colaboradores.txt");

        System.out.println();
        System.out.println("=== Colaboradores - Llanquihue Tour ===");
        System.out.println("Colaboradores cargados desde archivo: " + colaboradores.size());
        System.out.println();

        // Lista polimorfica de Registrable: agrupa entidades de distinto
        // tipo bajo el contrato comun de la interfaz.
        List<Registrable> registrables = new ArrayList<>();
        for (Persona persona : colaboradores) {
            if (persona instanceof Registrable) {
                registrables.add((Registrable) persona);
            }
        }

        // Uso de instanceof para diferenciar el tipo real de cada objeto
        for (Registrable registrable : registrables) {
            if (registrable instanceof GuiaTuristico) {
                GuiaTuristico guia = (GuiaTuristico) registrable;
                System.out.println("[GUIA] " + guia.getIdioma()
                        + " | " + guia.getAniosExperiencia() + " anios de experiencia");
            } else if (registrable instanceof ColaboradorExterno) {
                ColaboradorExterno externo = (ColaboradorExterno) registrable;
                System.out.println("[EXTERNO] " + externo.getEmpresa()
                        + " | " + externo.getTipoServicio());
            }
            registrable.mostrarResumen();
        }

        // === Se lanza la interfaz grafica de gestion de entidades ===
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.iniciar();
    }
}
