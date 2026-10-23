package Figuras;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * (Ejercicio propuesto) Esta clase denominada VentanaPrisma define una
 * ventana para ingresar los datos de un prisma rectangular y calcular su
 * volumen y superficie. Sigue la misma estructura de VentanaPirámide.
 */
public class VentanaPrisma extends JFrame implements ActionListener {
    // Un contenedor de elementos gráficos
    private Container contenedor;
    /* Etiquetas estáticas para identificar los campos de texto a ingresar
        y calcular */
    private JLabel largo, ancho, altura, volumen, superficie;
    // Etiqueta que muestra la imagen del prisma
    private JLabel imagen;
    // Campos de texto a ingresar
    private JTextField campoLargo, campoAncho, campoAltura;
    // Botón para realizar los cálculos numéricos
    private JButton calcular;
    /**
     * Constructor de la clase VentanaPrisma
     */
    public VentanaPrisma() {
        inicio();
        setTitle("Prisma"); // Establece el título de la ventana
        setSize(440,240); // Establece el tamaño de la ventana
        setLocationRelativeTo(null); /* La ventana se posiciona en el
            centro de la pantalla */
        setResizable(false); /* Establece que el tamaño de la ventana
            no se puede cambiar */
    }
    /**
     * Método que crea la ventana con sus diferentes componentes
     * gráficos
     */
    private void inicio() {
        contenedor = getContentPane(); /* Obtiene el panel de
            contenidos de la ventana */
        contenedor.setLayout(null); /* Establece que el contenedor no
            tiene un layout */
        // Establece la etiqueta y campo de texto para el largo del prisma
        largo = new JLabel();
        largo.setText("Largo (cms):");
        largo.setBounds(20, 20, 135, 23);
        campoLargo = new JTextField();
        campoLargo.setBounds(120, 20, 135, 23);
        // Establece la etiqueta y campo de texto para el ancho del prisma
        ancho = new JLabel();
        ancho.setText("Ancho (cms):");
        ancho.setBounds(20, 50, 135, 23);
        campoAncho = new JTextField();
        campoAncho.setBounds(120, 50, 135, 23);
        // Establece la etiqueta y campo de texto para la altura del prisma
        altura = new JLabel();
        altura.setText("Altura (cms):");
        altura.setBounds(20, 80, 135, 23);
        campoAltura = new JTextField();
        campoAltura.setBounds(120, 80, 135, 23);
        // Establece el botón para calcular volumen y superficie del prisma
        calcular = new JButton();
        calcular.setText("Calcular");
        calcular.setBounds(120, 110, 135, 23); /* Establece la posición
            del botón calcular */
        /* Agrega al botón un ActionListener para que gestione eventos
            del botón */
        calcular.addActionListener(this);
        // Establece la etiqueta y el valor del volumen del prisma
        volumen = new JLabel();
        volumen.setText("Volumen (cm3):");
        volumen.setBounds(20, 140, 200, 23);
        // Establece la etiqueta y el valor de la superficie del prisma
        superficie = new JLabel();
        superficie.setText("Superficie (cm2):");
        superficie.setBounds(20, 170, 200, 23);
        // Establece la imagen del prisma (archivo prisma.png del paquete Figuras)
        imagen = new JLabel(new ImageIcon(getClass().getResource("prisma.png")));
        imagen.setBounds(280, 30, 130, 130); // Posición de la imagen
        // Se añade cada componente gráfico al contenedor de la ventana
        contenedor.add(largo);
        contenedor.add(campoLargo);
        contenedor.add(ancho);
        contenedor.add(campoAncho);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
        contenedor.add(imagen);
    }
    /**
     * Método que gestiona los eventos generados en la ventana del
     * prisma throws Exception Excepción al ingresar un campo nulo o
     * error en formato de número
     */
    public void actionPerformed(ActionEvent event) {
        Prisma prisma;
        boolean error = false;
        double largo = 0;
        double ancho = 0;
        double altura = 0;
        try {
            // Se obtiene y convierte el valor numérico del largo
            largo = Double.parseDouble(campoLargo.getText());
            // Se obtiene y convierte el valor numérico del ancho
            ancho = Double.parseDouble(campoAncho.getText());
            // Se obtiene y convierte el valor numérico de la altura
            altura = Double.parseDouble(campoAltura.getText());
            // Se crea un objeto Prisma
            prisma = new Prisma(largo, ancho, altura);
            // Se muestra el volumen
            volumen.setText("Volumen (cm3): " + String.format("%.2f",
                prisma.calcularVolumen()));
            // Se muestra la superficie
            superficie.setText("Superficie (cm2): " + String.format("%.2f",
                prisma.calcularSuperficie()));
        } catch (Exception e) {
            error = true; // Si ocurre una excepción
        } finally {
            if (error) { /* Si ocurre una excepción, se muestra un mensaje
                de error */
                JOptionPane.showMessageDialog(null, "Campo nulo o error en formato de número",
                    "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
