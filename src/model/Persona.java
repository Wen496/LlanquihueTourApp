package model;

/**
 * Clase base abstracta que representa a una persona relacionada con la
 * agencia Llanquihue Tour (guia turistico, colaborador externo, etc.).
 *
 * Agrupa los datos comunes que comparten estas entidades y sirve como
 * raiz de la jerarquia de personas del sistema. Al ser abstracta no
 * puede instanciarse directamente: siempre se trabaja a traves de una
 * de sus subclases concretas.
 *
 * @author Macarena Alvarez Saez
 */
public abstract class Persona {

    /** Nombre completo de la persona */
    protected String nombre;

    /** RUT chileno validado, sin puntos y con guion */
    protected String rut;

    /** Numero de contacto telefonico */
    protected String telefono;

    /**
     * Crea una persona con sus datos basicos de identificacion.
     *
     * @param nombre nombre completo de la persona
     * @param rut RUT chileno de la persona
     * @param telefono numero de contacto
     */
    public Persona(String nombre, String rut, String telefono) {
        this.nombre = nombre;
        this.rut = rut;
        this.telefono = telefono;
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return nombre completo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Actualiza el nombre de la persona.
     *
     * @param nombre nuevo nombre completo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el RUT de la persona.
     *
     * @return RUT chileno
     */
    public String getRut() {
        return rut;
    }

    /**
     * Actualiza el RUT de la persona.
     *
     * @param rut nuevo RUT chileno
     */
    public void setRut(String rut) {
        this.rut = rut;
    }

    /**
     * Obtiene el telefono de contacto.
     *
     * @return numero de telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Actualiza el telefono de contacto.
     *
     * @param telefono nuevo numero de contacto
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Representacion textual con los datos comunes de la persona.
     * Las subclases la extienden agregando sus atributos propios
     * mediante super.toString().
     *
     * @return cadena con nombre, RUT y telefono
     */
    @Override
    public String toString() {
        return nombre + " | RUT: " + rut + " | Telefono: " + telefono;
    }
}
