package data;

import model.ServicioTuristico;
import model.RutaGastronomica;
import model.PaseoLacustre;
import model.ExcursionCultural;

public class GestorServicios {

    // Crea y devuelve un arreglo con al menos dos objetos de cada subclase
    public ServicioTuristico[] crearServiciosDePrueba() {

        ServicioTuristico[] servicios = {
            // Dos rutas gastronómicas
            new RutaGastronomica("Sabores de Frutillar", 4, 3),
            new RutaGastronomica("Cervecerías del Lago", 5, 4),

            // Dos paseos lacustres
            new PaseoLacustre("Travesía Lago Llanquihue", 3, "Catamarán"),
            new PaseoLacustre("Atardecer en Puerto Varas", 2, "Lancha"),

            // Dos excursiones culturales
            new ExcursionCultural("Ruta del Patrimonio Alemán", 6, "Iglesia de Frutillar"),
            new ExcursionCultural("Historia de Puerto Octay", 4, "Casona Niklitschek")
        };

        return servicios;
    }
}
