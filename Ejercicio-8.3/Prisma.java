package Figuras;
/**
 * (Ejercicio propuesto) Esta clase denominada Prisma es una subclase de
 * FiguraGeométrica que modela un prisma rectangular con un largo, un
 * ancho y una altura.
 */
public class Prisma extends FiguraGeométrica {
    private double largo; // Atributo que identifica el largo del prisma
    private double ancho; // Atributo que identifica el ancho del prisma
    private double altura; // Atributo que identifica la altura del prisma
    /**
     * Constructor de la clase Prisma
     * @param largo Parámetro que define el largo de un prisma
     * @param ancho Parámetro que define el ancho de un prisma
     * @param altura Parámetro que define la altura de un prisma
     */
    public Prisma(double largo, double ancho, double altura) {
        this.largo = largo;
        this.ancho = ancho;
        this.altura = altura;
        this.setVolumen(calcularVolumen()); /* Calcula el volumen y
            establece su atributo */
        this.setSuperficie(calcularSuperficie()); /* Calcula la superficie y
            establece su atributo */
    }
    /**
     * Método para calcular el volumen de un prisma rectangular
     * @return El volumen de un prisma rectangular
     */
    public double calcularVolumen() {
        double volumen = largo * ancho * altura;
        return volumen;
    }
    /**
     * Método para calcular la superficie de un prisma rectangular
     * @return La superficie de un prisma rectangular
     */
    public double calcularSuperficie() {
        // Suma de las áreas de las 6 caras (3 pares de caras iguales)
        double superficie = 2.0 * (largo * ancho + largo * altura
            + ancho * altura);
        return superficie;
    }
}
