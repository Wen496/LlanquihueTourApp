package model;

/**
 * Clase base que representa un servicio turistico ofrecido por la
 * agencia Llanquihue Tour.
 *
 * Agrupa los atributos comunes a toda la oferta (nombre y duracion) y
 * define el metodo mostrarInformacion(), que las subclases sobrescriben
 * para exhibir sus datos especificos. Gracias a esto, una coleccion
 * declarada como List de ServicioTuristico puede contener rutas
 * gastronomicas, paseos lacustres y excursiones culturales, y cada
 * objeto responde con su propia version del metodo.
 *
 * @author Macarena Alvarez Saez
 */
public class ServicioTuristico {

    /** Nombre comercial del servicio */
    private String nombre;

    /** Duracion estimada del servicio en horas */
    private int duracionHoras;

    /**
     * Crea un servicio turistico con sus datos comunes.
     *
     * @param nombre nombre comercial del servicio
     * @param duracionHoras duracion estimada en horas
     */
    public ServicioTuristico(String nombre, int duracionHoras) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
    }

    /**
     * Obtiene el nombre del servicio.
     *
     * @return nombre comercial
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Actualiza el nombre del servicio.
     *
     * @param nombre nuevo nombre comercial
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la duracion del servicio.
     *
     * @return duracion estimada en horas
     */
    public int getDuracionHoras() {
        return duracionHoras;
    }

    /**
     * Actualiza la duracion del servicio.
     *
     * @param duracionHoras nueva duracion en horas
     */
    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    /**
     * Muestra por consola la informacion del servicio.
     *
     * Metodo polimorfico: esta es la implementacion base. Las subclases
     * lo sobrescriben para mostrar su informacion especifica, de modo
     * que la version ejecutada depende del objeto real y no del tipo
     * de la referencia.
     */
    public void mostrarInformacion() {
        System.out.println("Servicio: " + nombre + " | Duracion: " + duracionHoras + " horas");
    }

    /**
     * Representacion textual base del servicio. Las subclases la
     * extienden agregando sus atributos propios mediante
     * super.toString().
     *
     * @return cadena con el nombre y la duracion del servicio
     */
    @Override
    public String toString() {
        return "Servicio: " + nombre + " | Duracion: " + duracionHoras + " horas";
    }
}
