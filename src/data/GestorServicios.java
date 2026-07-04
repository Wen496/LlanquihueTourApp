package data;

import java.util.ArrayList;
import java.util.List;
import model.ServicioTuristico;
import model.RutaGastronomica;
import model.PaseoLacustre;
import model.ExcursionCultural;

public class GestorServicios {

    // Colección polimórfica: puede almacenar cualquier subclase de ServicioTuristico
    private List<ServicioTuristico> servicios;

    public GestorServicios() {
        servicios = new ArrayList<>();
    }

    // Crea y carga en la lista al menos cinco objetos combinando las distintas subclases
    public List<ServicioTuristico> crearServiciosDePrueba() {

        servicios.add(new RutaGastronomica("Sabores de Frutillar", 4, 3));
        servicios.add(new RutaGastronomica("Cervecerías del Lago", 5, 4));

        servicios.add(new PaseoLacustre("Travesía Lago Llanquihue", 3, "Catamarán"));
        servicios.add(new PaseoLacustre("Atardecer en Puerto Varas", 2, "Lancha"));

        servicios.add(new ExcursionCultural("Ruta del Patrimonio Alemán", 6, "Iglesia de Frutillar"));
        servicios.add(new ExcursionCultural("Historia de Puerto Octay", 4, "Casona Niklitschek"));

        return servicios;
    }

    // Recorre la colección y muestra la información de cada servicio de forma polimórfica
    public void mostrarTodos() {
        for (ServicioTuristico servicio : servicios) {
            servicio.mostrarInformacion();
        }
    }
}