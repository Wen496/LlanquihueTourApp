package data;

import java.util.ArrayList;
import java.util.List;
import model.ServicioTuristico;
import model.RutaGastronomica;
import model.PaseoLacustre;
import model.ExcursionCultural;

/**
 * Gestiona la coleccion de servicios turisticos ofrecidos por la agencia
 * Llanquihue Tour.
 *
 * La coleccion es polimorfica: almacena cualquier subclase de
 * ServicioTuristico (rutas gastronomicas, paseos lacustres y
 * excursiones culturales) bajo una misma referencia.
 *
 * @author Macarena Alvarez Saez
 */
public class GestorServicios {

    /** Coleccion polimorfica: puede almacenar cualquier subclase de ServicioTuristico */
    private List<ServicioTuristico> servicios;

    /**
     * Inicializa el gestor con una coleccion vacia.
     */
    public GestorServicios() {
        servicios = new ArrayList<>();
    }

    /**
     * Carga los servicios desde un archivo de texto plano ubicado en
     * la carpeta datos/ y los almacena en la coleccion del gestor.
     *
     * @param nombreArchivo nombre del archivo dentro de la carpeta datos
     * @return la lista de servicios cargados
     */
    public List<ServicioTuristico> cargarDesdeArchivo(String nombreArchivo) {
        servicios = LectorArchivos.cargarServicios(nombreArchivo);
        return servicios;
    }

    /**
     * Crea y carga en la lista al menos cinco objetos combinando las
     * distintas subclases. Se conserva como respaldo para pruebas
     * cuando no se dispone del archivo de datos.
     *
     * @return la lista de servicios de prueba
     */
    public List<ServicioTuristico> crearServiciosDePrueba() {

        servicios.add(new RutaGastronomica("Sabores de Frutillar", 4, 3));
        servicios.add(new RutaGastronomica("Cervecerias del Lago", 5, 4));

        servicios.add(new PaseoLacustre("Travesia Lago Llanquihue", 3, "Catamaran"));
        servicios.add(new PaseoLacustre("Atardecer en Puerto Varas", 2, "Lancha"));

        servicios.add(new ExcursionCultural("Ruta del Patrimonio Aleman", 6, "Iglesia de Frutillar"));
        servicios.add(new ExcursionCultural("Historia de Puerto Octay", 4, "Casona Niklitschek"));

        return servicios;
    }

    /**
     * Devuelve la coleccion completa de servicios administrados.
     *
     * @return lista de servicios turisticos
     */
    public List<ServicioTuristico> getServicios() {
        return servicios;
    }

    /**
     * Busca los servicios cuya duracion no supere las horas indicadas.
     *
     * @param maxHoras duracion maxima en horas
     * @return lista con los servicios que cumplen el criterio
     */
    public List<ServicioTuristico> filtrarPorDuracion(int maxHoras) {
        List<ServicioTuristico> resultado = new ArrayList<>();
        for (ServicioTuristico servicio : servicios) {
            if (servicio.getDuracionHoras() <= maxHoras) {
                resultado.add(servicio);
            }
        }
        return resultado;
    }

    /**
     * Recorre la coleccion y muestra la informacion de cada servicio
     * de forma polimorfica.
     */
    public void mostrarTodos() {
        for (ServicioTuristico servicio : servicios) {
            servicio.mostrarInformacion();
        }
    }
}
