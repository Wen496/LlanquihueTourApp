package model;

/**
 * Representa a un colaborador externo que presta servicios puntuales
 * a la agencia Llanquihue Tour (por ejemplo, proveedores de transporte,
 * alojamiento o gastronomia).
 *
 * Hereda los datos comunes de Persona e implementa Registrable, lo que
 * permite gestionarlo junto a los guias bajo una misma referencia
 * polimorfica aunque su naturaleza sea distinta.
 *
 * @author Macarena Alvarez Saez
 */
public class ColaboradorExterno extends Persona implements Registrable {

    /** Nombre de la empresa a la que pertenece el colaborador */
    private String empresa;

    /** Tipo de servicio que presta a la agencia */
    private String tipoServicio;

    /**
     * Crea un colaborador externo con sus datos personales y comerciales.
     *
     * @param nombre nombre completo del colaborador
     * @param rut RUT chileno del colaborador
     * @param telefono numero de contacto
     * @param empresa empresa a la que pertenece
     * @param tipoServicio servicio que presta a la agencia
     */
    public ColaboradorExterno(String nombre, String rut, String telefono,
            String empresa, String tipoServicio) {
        super(nombre, rut, telefono);
        this.empresa = empresa;
        this.tipoServicio = tipoServicio;
    }

    /**
     * Obtiene la empresa del colaborador.
     *
     * @return nombre de la empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * Actualiza la empresa del colaborador.
     *
     * @param empresa nuevo nombre de la empresa
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * Obtiene el tipo de servicio que presta el colaborador.
     *
     * @return tipo de servicio
     */
    public String getTipoServicio() {
        return tipoServicio;
    }

    /**
     * Actualiza el tipo de servicio que presta el colaborador.
     *
     * @param tipoServicio nuevo tipo de servicio
     */
    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    /**
     * Muestra por consola el resumen del colaborador externo.
     * Implementacion propia del contrato definido en Registrable.
     */
    @Override
    public void mostrarResumen() {
        System.out.println(obtenerResumen());
    }

    /**
     * Devuelve el resumen del colaborador como texto, para mostrarlo
     * en la interfaz grafica.
     *
     * @return descripcion breve del colaborador externo
     */
    @Override
    public String obtenerResumen() {
        return "Colaborador externo: " + nombre
                + " | RUT: " + rut
                + " | Empresa: " + empresa
                + " | Servicio: " + tipoServicio;
    }

    /**
     * Representacion textual del colaborador, reutilizando el toString()
     * de la superclase con super.toString() y agregando los atributos
     * propios de esta subclase.
     *
     * @return cadena con los datos completos del colaborador
     */
    @Override
    public String toString() {
        return "[Colaborador Externo] " + super.toString()
                + " | Empresa: " + empresa
                + " | Servicio: " + tipoServicio;
    }
}
