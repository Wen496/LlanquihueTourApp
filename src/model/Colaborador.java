package model;

/**
 * Representa a un colaborador de la agencia Llanquihue Tour en su forma
 * mas basica, identificado por su rol dentro de la operacion (guia,
 * operador o proveedor).
 *
 * Esta clase ejemplifica el principio de composicion: un Colaborador
 * "tiene una" Direccion como parte de sus atributos, en lugar de
 * heredar de ella. La direccion no tiene sentido por si sola dentro
 * del sistema, existe siempre asociada a un colaborador.
 *
 * @author Macarena Alvarez Saez
 */
public class Colaborador {

    /** Nombre completo del colaborador */
    private String nombre;

    /** RUT chileno del colaborador */
    private String rut;

    /** Rol que cumple: guia, operador o proveedor */
    private String rol;

    /** COMPOSICION: un Colaborador tiene una Direccion adentro */
    private Direccion direccion;

    /**
     * Crea un colaborador vacio. Los datos se asignan luego mediante
     * los metodos set correspondientes.
     */
    public Colaborador() {
    }

    /**
     * Crea un colaborador con todos sus datos, incluida su direccion.
     *
     * @param nombre nombre completo del colaborador
     * @param rut RUT chileno del colaborador
     * @param rol rol que cumple en la agencia
     * @param direccion direccion fisica del colaborador
     */
    public Colaborador(String nombre, String rut, String rol, Direccion direccion) {
        this.nombre = nombre;
        this.rut = rut;
        this.rol = rol;
        this.direccion = direccion;
    }

    /**
     * Obtiene el nombre del colaborador.
     *
     * @return nombre completo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Actualiza el nombre del colaborador.
     *
     * @param nombre nuevo nombre completo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el RUT del colaborador.
     *
     * @return RUT chileno
     */
    public String getRut() {
        return rut;
    }

    /**
     * Actualiza el RUT del colaborador.
     *
     * @param rut nuevo RUT chileno
     */
    public void setRut(String rut) {
        this.rut = rut;
    }

    /**
     * Obtiene el rol del colaborador.
     *
     * @return rol dentro de la agencia
     */
    public String getRol() {
        return rol;
    }

    /**
     * Actualiza el rol del colaborador.
     *
     * @param rol nuevo rol dentro de la agencia
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * Obtiene la direccion del colaborador.
     *
     * @return objeto Direccion asociado
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * Actualiza la direccion del colaborador.
     *
     * @param direccion nueva direccion asociada
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * Representacion textual del colaborador. Reutiliza el toString()
     * de Direccion al concatenarla, demostrando la composicion.
     *
     * @return cadena con los datos del colaborador y su direccion
     */
    @Override
    public String toString() {
        return "Colaborador: " + nombre
                + " | RUT: " + rut
                + " | Rol: " + rol
                + " | Direccion: " + direccion;
    }
}
