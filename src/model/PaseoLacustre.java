package model;

/**
 * Representa un paseo lacustre de la agencia Llanquihue Tour: una
 * navegacion por el lago Llanquihue u otros cuerpos de agua de la
 * region.
 *
 * Hereda de ServicioTuristico los datos comunes de toda la oferta y
 * agrega el tipo de embarcacion, atributo que solo tiene sentido en
 * este tipo de servicio.
 *
 * @author Macarena Alvarez Saez
 */
public class PaseoLacustre extends ServicioTuristico {

    /** Tipo de embarcacion utilizada (catamaran, lancha, kayak, etc.) */
    private String tipoEmbarcacion;

    /**
     * Crea un paseo lacustre. Usa super(...) para inicializar los
     * atributos heredados de ServicioTuristico.
     *
     * @param nombre nombre comercial del paseo
     * @param duracionHoras duracion estimada en horas
     * @param tipoEmbarcacion embarcacion utilizada en el recorrido
     */
    public PaseoLacustre(String nombre, int duracionHoras, String tipoEmbarcacion) {
        super(nombre, duracionHoras);
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    /**
     * Obtiene el tipo de embarcacion del paseo.
     *
     * @return embarcacion utilizada
     */
    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }

    /**
     * Actualiza el tipo de embarcacion del paseo.
     *
     * @param tipoEmbarcacion nueva embarcacion
     */
    public void setTipoEmbarcacion(String tipoEmbarcacion) {
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    /**
     * Sobrescribe mostrarInformacion() con los datos especificos del
     * paseo lacustre.
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("[Paseo Lacustre] " + getNombre()
                + " | Duracion: " + getDuracionHoras() + " horas"
                + " | Tipo de embarcacion: " + tipoEmbarcacion);
    }

    /**
     * Sobrescribe toString() reutilizando el de la superclase con
     * super.toString() y agregando el atributo propio.
     *
     * @return cadena con los datos completos del paseo
     */
    @Override
    public String toString() {
        return "[Paseo Lacustre] " + super.toString()
                + " | Tipo de embarcacion: " + tipoEmbarcacion;
    }
}
