package model;

/**
 * Representa a un guia turistico de la agencia Llanquihue Tour.
 *
 * Hereda los datos comunes de Persona e implementa Registrable para
 * poder ser gestionado junto a otras entidades del sistema bajo una
 * misma referencia polimorfica.
 *
 * @author Macarena Alvarez Saez
 */
public class GuiaTuristico extends Persona implements Registrable {

    /** Idioma en que el guia puede conducir un tour */
    private String idioma;

    /** Anios de experiencia acumulados en la agencia */
    private int aniosExperiencia;

    /**
     * Crea un guia turistico con sus datos personales y profesionales.
     *
     * @param nombre nombre completo del guia
     * @param rut RUT chileno del guia
     * @param telefono numero de contacto
     * @param idioma idioma en que conduce los tours
     * @param aniosExperiencia anios de experiencia acumulados
     */
    public GuiaTuristico(String nombre, String rut, String telefono,
            String idioma, int aniosExperiencia) {
        super(nombre, rut, telefono);
        this.idioma = idioma;
        this.aniosExperiencia = aniosExperiencia;
    }

    /**
     * Obtiene el idioma del guia.
     *
     * @return idioma en que conduce los tours
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * Actualiza el idioma del guia.
     *
     * @param idioma nuevo idioma
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    /**
     * Obtiene los anios de experiencia del guia.
     *
     * @return cantidad de anios de experiencia
     */
    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    /**
     * Actualiza los anios de experiencia del guia.
     *
     * @param aniosExperiencia nueva cantidad de anios
     */
    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    /**
     * Muestra por consola el resumen del guia turistico.
     * Implementacion propia del contrato definido en Registrable.
     */
    @Override
    public void mostrarResumen() {
        System.out.println(obtenerResumen());
    }

    /**
     * Devuelve el resumen del guia como texto, para mostrarlo en la
     * interfaz grafica.
     *
     * @return descripcion breve del guia turistico
     */
    @Override
    public String obtenerResumen() {
        return "Guia turistico: " + nombre
                + " | RUT: " + rut
                + " | Idioma: " + idioma
                + " | Experiencia: " + aniosExperiencia + " anios";
    }

    /**
     * Representacion textual del guia, reutilizando el toString() de
     * la superclase con super.toString() y agregando los atributos
     * propios de esta subclase.
     *
     * @return cadena con los datos completos del guia
     */
    @Override
    public String toString() {
        return "[Guia Turistico] " + super.toString()
                + " | Idioma: " + idioma
                + " | Experiencia: " + aniosExperiencia + " anios";
    }
}
