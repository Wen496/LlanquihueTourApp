package data;

import java.util.ArrayList;
import model.Registrable;
import model.GuiaTuristico;
import model.Vehiculo;
import model.ColaboradorExterno;

/**
 * Gestiona las distintas entidades del sistema (guías, vehículos,
 * colaboradores externos) en una única colección polimórfica de tipo
 * Registrable, diferenciándolas en tiempo de ejecución con instanceof.
 *
 * @author Macarena Alvarez Saez
 * @version 1.0
 */
public class GestorEntidades {

    /** Colección polimórfica que almacena todas las entidades registrables. */
    private ArrayList<Registrable> entidades;

    /**
     * Crea un gestor con la colección de entidades vacía.
     */
    public GestorEntidades() {
        this.entidades = new ArrayList<>();
    }

    /**
     * Agrega una nueva entidad a la colección.
     *
     * @param entidad objeto que implementa Registrable (guía, vehículo o
     *                colaborador externo)
     */
    public void agregarEntidad(Registrable entidad) {
        entidades.add(entidad);
    }

    /**
     * Muestra por consola el resumen de todas las entidades registradas.
     * Usa polimorfismo al invocar mostrarResumen() e instanceof para agregar
     * un detalle específico según el tipo concreto de cada entidad.
     */
    public void mostrarTodas() {
        System.out.println("=== Listado de entidades registradas ===");

        for (Registrable entidad : entidades) {
            entidad.mostrarResumen();

            if (entidad instanceof GuiaTuristico) {
                GuiaTuristico g = (GuiaTuristico) entidad;
                System.out.println("   -> Guía habilitado para tours en "
                        + g.getIdioma());
            } else if (entidad instanceof Vehiculo) {
                Vehiculo v = (Vehiculo) entidad;
                System.out.println("   -> Vehículo con capacidad para "
                        + v.getCapacidad() + " pasajeros");
            } else if (entidad instanceof ColaboradorExterno) {
                ColaboradorExterno c = (ColaboradorExterno) entidad;
                System.out.println("   -> Colaborador de la empresa "
                        + c.getEmpresa());
            }

            System.out.println("------------------------------------");
        }
    }

    /**
     * Obtiene la cantidad de entidades registradas.
     *
     * @return número total de entidades en la colección
     */
    public int getCantidad() {
        return entidades.size();
    }

    /**
     * Obtiene la colección completa de entidades.
     *
     * @return ArrayList con todas las entidades registrables
     */
    public ArrayList<Registrable> getEntidades() {
        return entidades;
    }

}
