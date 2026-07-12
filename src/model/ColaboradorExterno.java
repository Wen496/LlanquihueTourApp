package model;

/**
 * Representa a un colaborador externo que presta servicios puntuales
 * a la agencia Llanquihue Tour (por ejemplo, proveedores o freelance).
 */
public class ColaboradorExterno extends Persona implements Registrable {

    private String empresa;
    private String tipoServicio;

    public ColaboradorExterno(String nombre, String rut, String telefono,
                               String empresa, String tipoServicio) {
        super(nombre, rut, telefono);
        this.empresa = empresa;
        this.tipoServicio = tipoServicio;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("Colaborador externo: " + nombre
                + " | RUT: " + rut
                + " | Empresa: " + empresa
                + " | Servicio: " + tipoServicio);
    }

    @Override
    public String obtenerResumen() {
        return "Colaborador externo: " + nombre
                + " | RUT: " + rut
                + " | Empresa: " + empresa
                + " | Servicio: " + tipoServicio;
    }

}