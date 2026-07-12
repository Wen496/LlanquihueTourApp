package model;

/**
 * Representa a un guía turístico de la agencia Llanquihue Tour.
 * Hereda los datos comunes de Persona e implementa Registrable
 * para poder ser gestionado junto a otras entidades del sistema.
 */
public class GuiaTuristico extends Persona implements Registrable {

    private String idioma;
    private int aniosExperiencia;

    public GuiaTuristico(String nombre, String rut, String telefono,
                          String idioma, int aniosExperiencia) {
        super(nombre, rut, telefono);
        this.idioma = idioma;
        this.aniosExperiencia = aniosExperiencia;
    }

    public String getIdioma() {
        return idioma;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("Guía turístico: " + nombre
                + " | RUT: " + rut
                + " | Idioma: " + idioma
                + " | Experiencia: " + aniosExperiencia + " años");
    }

    @Override
    public String obtenerResumen() {
        return "Guía turístico: " + nombre
                + " | RUT: " + rut
                + " | Idioma: " + idioma
                + " | Experiencia: " + aniosExperiencia + " años";
    }

}