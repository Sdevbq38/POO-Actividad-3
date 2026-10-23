package Figuras;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * (Ejercicio propuesto) Esta clase denominada VentanaCubo define una
 * ventana para ingresar el lado de un cubo y calcular su volumen y
 * superficie. Sigue la misma estructura de VentanaEsfera.
 */
public class VentanaCubo extends JFrame implements ActionListener {
    // Un contenedor de elementos gráficos
    private Container contenedor;
    /* Etiquetas estáticas para identificar los campos de texto a ingresar
        y calcular */
    private JLabel lado, volumen, superficie;
    // Etiqueta que muestra la imagen del cubo
    private JLabel imagen;
    private JTextField campoLado; // Campo de texto a ingresar
    private JButton calcular; /* Botón para realizar los cálculos
        numéricos */
    /**
     * Constructor de la clase VentanaCubo
     */
    public VentanaCubo() {
        inicio();
        setTitle("Cubo"); // Establece el título de la ventana
        setSize(420,200); // Establece el tamaño de la ventana
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
        // Establece la etiqueta y campo de texto para el lado del cubo
        lado = new JLabel();
        lado.setText("Lado (cms):");
        lado.setBounds(20, 20, 135, 23); /* Establece la posición de la
            etiqueta del lado del cubo */
        campoLado = new JTextField();
        // Establece la posición del campo de texto del lado del cubo
        campoLado.setBounds(100, 20, 135, 23);
        // Establece el botón para calcular el volumen y superficie del cubo
        calcular = new JButton();
        calcular.setText("Calcular");
        calcular.setBounds(100, 50, 135, 23); /* Establece la posición
            del botón calcular */
        /* Agrega al botón un ActionListener para que gestione eventos
            del botón */
        calcular.addActionListener(this);
        // Establece la etiqueta y el valor del volumen del cubo
        volumen = new JLabel();
        volumen.setText("Volumen (cm3):");
        volumen.setBounds(20, 90, 200, 23);
        // Establece la etiqueta y el valor de la superficie del cubo
        superficie = new JLabel();
        superficie.setText("Superficie (cm2):");
        superficie.setBounds(20, 120, 200, 23);
        // Establece la imagen del cubo (archivo cubo.png del paquete Figuras)
        imagen = new JLabel(new ImageIcon(getClass().getResource("cubo.png")));
        imagen.setBounds(260, 15, 130, 130); // Posición de la imagen
        // Se añade cada componente gráfico al contenedor de la ventana
        contenedor.add(lado);
        contenedor.add(campoLado);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
        contenedor.add(imagen);
    }
    /**
     * Método que gestiona los eventos generados en la ventana del
     * cubo throws Exception Excepción al ingresar un campo nulo o
     * error en formato de número
     */
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) { /* Si se pulsa el botón
            Calcular */
            boolean error = false;
            try {
                // Se obtiene y convierte el valor numérico del lado
                double lado = Double.parseDouble(campoLado.getText());
                Cubo cubo = new Cubo(lado); // Se crea un objeto Cubo
                // Se muestra el volumen
                volumen.setText("Volumen (cm3): " + String.format("%.2f",
                    cubo.calcularVolumen()));
                // Se muestra la superficie
                superficie.setText("Superficie (cm2): " + String.format("%.2f",
                    cubo.calcularSuperficie()));
            } catch (Exception e) {
                error = true; // Si ocurre una excepción
            } finally {
                if(error) { /* Si ocurre una excepción, se muestra un
                    mensaje de error */
                    JOptionPane.showMessageDialog(null,"Campo nulo o error en formato de número",
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
