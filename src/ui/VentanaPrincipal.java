package ui;

import javax.swing.JOptionPane;
import data.GestorEntidades;
import model.GuiaTuristico;
import model.Vehiculo;
import model.ColaboradorExterno;

/**
 * Interfaz gráfica básica (basada en JOptionPane) que permite ingresar
 * distintos tipos de entidades del sistema Llanquihue Tour y visualizar
 * un resumen de todas las registradas.
 *
 * @author Macarena Alvarez Saez
 * @version 1.0
 */
public class VentanaPrincipal {

    /** Gestor que almacena y administra las entidades ingresadas. */
    private GestorEntidades gestor;

    /**
     * Crea la ventana principal con un gestor de entidades vacío.
     */
    public VentanaPrincipal() {
        this.gestor = new GestorEntidades();
    }

    /**
     * Inicia el menú principal de la aplicación. Muestra las opciones en
     * un cuadro de diálogo y repite el ciclo hasta que el usuario elige
     * salir o cierra la ventana.
     */
    public void iniciar() {
        boolean salir = false;

        while (!salir) {
            String menu = "=== Llanquihue Tour - Gestión de Entidades ===\n"
                    + "1. Agregar Guía Turístico\n"
                    + "2. Agregar Vehículo\n"
                    + "3. Agregar Colaborador Externo\n"
                    + "4. Mostrar todas las entidades\n"
                    + "5. Salir\n\n"
                    + "Seleccione una opción:";

            String opcion = JOptionPane.showInputDialog(menu);

            // Si el usuario cierra la ventana o cancela
            if (opcion == null) {
                salir = true;
                continue;
            }

            switch (opcion) {
                case "1":
                    agregarGuia();
                    break;
                case "2":
                    agregarVehiculo();
                    break;
                case "3":
                    agregarColaborador();
                    break;
                case "4":
                    mostrarEntidades();
                    break;
                case "5":
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null,
                            "Opción no válida. Intente nuevamente.");
            }
        }

        JOptionPane.showMessageDialog(null, "¡Hasta pronto!");
    }

    /**
     * Solicita por diálogo los datos de un guía turístico y lo agrega
     * al gestor de entidades.
     */
    private void agregarGuia() {
        String nombre = JOptionPane.showInputDialog("Nombre del guía:");
        String rut = JOptionPane.showInputDialog("RUT:");
        String telefono = JOptionPane.showInputDialog("Teléfono:");
        String idioma = JOptionPane.showInputDialog("Idioma:");
        int anios = Integer.parseInt(
                JOptionPane.showInputDialog("Años de experiencia:"));

        GuiaTuristico guia = new GuiaTuristico(nombre, rut, telefono, idioma, anios);
        gestor.agregarEntidad(guia);

        JOptionPane.showMessageDialog(null, "Guía agregado correctamente.");
    }

    /**
     * Solicita por diálogo los datos de un vehículo y lo agrega
     * al gestor de entidades.
     */
    private void agregarVehiculo() {
        String patente = JOptionPane.showInputDialog("Patente:");
        String marca = JOptionPane.showInputDialog("Marca:");
        String modelo = JOptionPane.showInputDialog("Modelo:");
        int capacidad = Integer.parseInt(
                JOptionPane.showInputDialog("Capacidad (pasajeros):"));

        Vehiculo vehiculo = new Vehiculo(patente, marca, modelo, capacidad);
        gestor.agregarEntidad(vehiculo);

        JOptionPane.showMessageDialog(null, "Vehículo agregado correctamente.");
    }

    /**
     * Solicita por diálogo los datos de un colaborador externo y lo agrega
     * al gestor de entidades.
     */
    private void agregarColaborador() {
        String nombre = JOptionPane.showInputDialog("Nombre del colaborador:");
        String rut = JOptionPane.showInputDialog("RUT:");
        String telefono = JOptionPane.showInputDialog("Teléfono:");
        String empresa = JOptionPane.showInputDialog("Empresa:");
        String tipoServicio = JOptionPane.showInputDialog("Tipo de servicio:");

        ColaboradorExterno col = new ColaboradorExterno(
                nombre, rut, telefono, empresa, tipoServicio);
        gestor.agregarEntidad(col);

        JOptionPane.showMessageDialog(null, "Colaborador agregado correctamente.");
    }

    /**
     * Muestra en un cuadro de diálogo el resumen de todas las entidades
     * registradas, aprovechando el polimorfismo de obtenerResumen().
     * Si no hay entidades, informa al usuario.
     */
    private void mostrarEntidades() {
        if (gestor.getCantidad() == 0) {
            JOptionPane.showMessageDialog(null,
                    "No hay entidades registradas todavía.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("=== Entidades registradas (")
          .append(gestor.getCantidad())
          .append(") ===\n\n");

        for (model.Registrable entidad : gestor.getEntidades()) {
            sb.append(entidad.obtenerResumen()).append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }

}
