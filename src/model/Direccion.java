package model;

/**
 * Representa la direccion fisica de un colaborador de la agencia
 * Llanquihue Tour dentro de la Region de Los Lagos.
 *
 * Es una clase de apoyo: no vive por si sola dentro del sistema, sino
 * que forma parte de otras entidades mediante composicion. Un
 * Colaborador contiene una Direccion como uno de sus atributos.
 *
 * @author Macarena Alvarez Saez
 */
public class Direccion {

    /** Comuna donde se ubica la direccion */
    private String comuna;

    /** Calle y numeracion */
    private String calle;

    /**
     * Crea una direccion vacia. Los datos se asignan luego mediante
     * los metodos set correspondientes.
     */
    public Direccion() {
    }

    /**
     * Crea una direccion con sus datos completos.
     *
     * @param comuna comuna donde se ubica
     * @param calle calle y numeracion
     */
    public Direccion(String comuna, String calle) {
        this.comuna = comuna;
        this.calle = calle;
    }

    /**
     * Obtiene la comuna de la direccion.
     *
     * @return nombre de la comuna
     */
    public String getComuna() {
        return comuna;
    }

    /**
     * Actualiza la comuna de la direccion.
     *
     * @param comuna nueva comuna
     */
    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    /**
     * Obtiene la calle de la direccion.
     *
     * @return calle y numeracion
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Actualiza la calle de la direccion.
     *
     * @param calle nueva calle y numeracion
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Representacion textual de la direccion en formato calle, comuna.
     *
     * @return cadena con la direccion completa
     */
    @Override
    public String toString() {
        return calle + ", " + comuna;
    }
}
