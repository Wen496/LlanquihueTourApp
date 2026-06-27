package model;

public class ExcursionCultural extends ServicioTuristico {

    // Atributo propio de esta subclase
    private String lugarHistorico;

    // Constructor: usa super(...) para los atributos heredados
    public ExcursionCultural(String nombre, int duracionHoras, String lugarHistorico) {
        super(nombre, duracionHoras);
        this.lugarHistorico = lugarHistorico;
    }

    public String getLugarHistorico() {
        return lugarHistorico;
    }

    public void setLugarHistorico(String lugarHistorico) {
        this.lugarHistorico = lugarHistorico;
    }

    // Sobrescribe toString() reutilizando el de la superclase con super.toString()
    @Override
    public String toString() {
        return "[Excursión Cultural] " + super.toString()
                + " | Lugar histórico: " + lugarHistorico;
    }
}
