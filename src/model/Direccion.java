package model;

public class Direccion {

    // Atributos privados (encapsulamiento)
    private String comuna;
    private String calle;

    // Constructor vacío
    public Direccion() {
    }

    // Constructor con parámetros
    public Direccion(String comuna, String calle) {
        this.comuna = comuna;
        this.calle = calle;
    }

    // Getters y setters
    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    // Método toString para mostrar la dirección como texto
    @Override
    public String toString() {
        return calle + ", " + comuna;
    }
}