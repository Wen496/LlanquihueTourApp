package model;

public class PaseoLacustre extends ServicioTuristico {

    // Atributo propio de esta subclase
    private String tipoEmbarcacion;

    // Constructor: usa super(...) para los atributos heredados
    public PaseoLacustre(String nombre, int duracionHoras, String tipoEmbarcacion) {
        super(nombre, duracionHoras);
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }

    public void setTipoEmbarcacion(String tipoEmbarcacion) {
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    // Sobrescribe toString() reutilizando el de la superclase con super.toString()
    @Override
    public String toString() {
        return "[Paseo Lacustre] " + super.toString()
                + " | Tipo de embarcación: " + tipoEmbarcacion;
    }
}
