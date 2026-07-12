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
 */
public class GestorEntidades {

    private ArrayList<Registrable> entidades;

    public GestorEntidades() {
        this.entidades = new ArrayList<>();
    }

    public void agregarEntidad(Registrable entidad) {
        entidades.add(entidad);
    }

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

            System.out.println("-------------------------------------");
        }
    }

    public int getCantidad() {
        return entidades.size();
    }

    public ArrayList<Registrable> getEntidades() {
        return entidades;
    }

}
