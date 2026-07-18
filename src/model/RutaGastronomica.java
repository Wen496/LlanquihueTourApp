package model;

/**
 * Representa una ruta gastronomica de la agencia Llanquihue Tour: un
 * recorrido por distintos locales o productores de la zona (cervecerias
 * artesanales, cocinerias, reposterias alemanas de Frutillar, etc.).
 *
 * Hereda de ServicioTuristico los datos comunes de toda la oferta y
 * agrega el numero de paradas, atributo que solo tiene sentido en este
 * tipo de recorrido.
 *
 * @author Macarena Alvarez Saez
 */
public class RutaGastronomica extends ServicioTuristico {

    /** Cantidad de locales o productores que incluye el recorrido */
    private int numeroDeParadas;

    /**
     * Crea una ruta gastronomica. Usa super(...) para inicializar los
     * atributos heredados de ServicioTuristico.
     *
     * @param nombre nombre comercial de la ruta
     * @param duracionHoras duracion estimada en horas
     * @param numeroDeParadas cantidad de paradas del recorrido
     */
    public RutaGastronomica(String nombre, int duracionHoras, int numeroDeParadas) {
        super(nombre, duracionHoras);
        this.numeroDeParadas = numeroDeParadas;
    }

    /**
     * Obtiene el numero de paradas de la ruta.
     *
     * @return cantidad de paradas
     */
    public int getNumeroDeParadas() {
        return numeroDeParadas;
    }

    /**
     * Actualiza el numero de paradas de la ruta.
     *
     * @param numeroDeParadas nueva cantidad de paradas
     */
    public void setNumeroDeParadas(int numeroDeParadas) {
        this.numeroDeParadas = numeroDeParadas;
    }

    /**
     * Sobrescribe mostrarInformacion() con los datos especificos de la
     * ruta gastronomica.
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("[Ruta Gastronomica] " + getNombre()
                + " | Duracion: " + getDuracionHoras() + " horas"
                + " | Numero de paradas: " + numeroDeParadas);
    }

    /**
     * Sobrescribe toString() reutilizando el de la superclase con
     * super.toString() y agregando el atributo propio.
     *
     * @return cadena con los datos completos de la ruta
     */
    @Override
    public String toString() {
        return "[Ruta Gastronomica] " + super.toString()
                + " | Numero de paradas: " + numeroDeParadas;
    }
}
