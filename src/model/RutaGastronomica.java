package model;

public class RutaGastronomica extends ServicioTuristico {

    // Atributo propio de esta subclase
    private int numeroDeParadas;

    // Constructor: usa super(...) para los atributos heredados
    public RutaGastronomica(String nombre, int duracionHoras, int numeroDeParadas) {
        super(nombre, duracionHoras);
        this.numeroDeParadas = numeroDeParadas;
    }

    public int getNumeroDeParadas() {
        return numeroDeParadas;
    }

    public void setNumeroDeParadas(int numeroDeParadas) {
        this.numeroDeParadas = numeroDeParadas;
    }

    // Sobrescribe toString() reutilizando el de la superclase con super.toString()
    @Override
    public String toString() {
        return "[Ruta Gastronómica] " + super.toString()
                + " | Número de paradas: " + numeroDeParadas;
    }
}
