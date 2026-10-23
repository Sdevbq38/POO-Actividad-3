package Figuras;
/**
 * (Ejercicio propuesto) Esta clase denominada Cubo es una subclase de
 * FiguraGeométrica que cuenta con un lado (arista).
 */
public class Cubo extends FiguraGeométrica {
    private double lado; // Atributo que identifica el lado de un cubo
    /**
     * Constructor de la clase Cubo
     * @param lado Parámetro que define el lado de un cubo
     */
    public Cubo(double lado) {
        this.lado = lado;
        this.setVolumen(calcularVolumen()); /* Calcula el volumen y
            establece su atributo */
        this.setSuperficie(calcularSuperficie()); /* Calcula la superficie y
            establece su atributo */
    }
    /**
     * Método para calcular el volumen de un cubo
     * @return El volumen de un cubo
     */
    public double calcularVolumen() {
        double volumen = Math.pow(lado, 3.0); // lado al cubo
        return volumen;
    }
    /**
     * Método para calcular la superficie de un cubo
     * @return La superficie de un cubo
     */
    public double calcularSuperficie() {
        double superficie = 6.0 * Math.pow(lado, 2.0); // 6 caras cuadradas
        return superficie;
    }
}
