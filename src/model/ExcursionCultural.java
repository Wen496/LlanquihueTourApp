package model;

/**
 * Representa una excursion cultural de la agencia Llanquihue Tour: una
 * visita guiada al patrimonio historico de la Region de Los Lagos
 * (iglesias, museos, casonas de la colonizacion alemana, etc.).
 *
 * Hereda de ServicioTuristico los datos comunes de toda la oferta y
 * agrega el lugar historico visitado, atributo que solo tiene sentido
 * en este tipo de servicio.
 *
 * @author Macarena Alvarez Saez
 */
public class ExcursionCultural extends ServicioTuristico {

    /** Lugar historico o patrimonial que se visita */
    private String lugarHistorico;

    /**
     * Crea una excursion cultural. Usa super(...) para inicializar los
     * atributos heredados de ServicioTuristico.
     *
     * @param nombre nombre comercial de la excursion
     * @param duracionHoras duracion estimada en horas
     * @param lugarHistorico lugar patrimonial visitado
     */
    public ExcursionCultural(String nombre, int duracionHoras, String lugarHistorico) {
        super(nombre, duracionHoras);
        this.lugarHistorico = lugarHistorico;
    }

    /**
     * Obtiene el lugar historico de la excursion.
     *
     * @return lugar patrimonial visitado
     */
    public String getLugarHistorico() {
        return lugarHistorico;
    }

    /**
     * Actualiza el lugar historico de la excursion.
     *
     * @param lugarHistorico nuevo lugar patrimonial
     */
    public void setLugarHistorico(String lugarHistorico) {
        this.lugarHistorico = lugarHistorico;
    }

    /**
     * Sobrescribe mostrarInformacion() con los datos especificos de la
     * excursion cultural.
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("[Excursion Cultural] " + getNombre()
                + " | Duracion: " + getDuracionHoras() + " horas"
                + " | Lugar historico: " + lugarHistorico);
    }

    /**
     * Sobrescribe toString() reutilizando el de la superclase con
     * super.toString() y agregando el atributo propio.
     *
     * @return cadena con los datos completos de la excursion
     */
    @Override
    public String toString() {
        return "[Excursion Cultural] " + super.toString()
                + " | Lugar historico: " + lugarHistorico;
    }
}
