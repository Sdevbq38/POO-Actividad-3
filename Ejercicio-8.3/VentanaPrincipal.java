package Figuras;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Esta clase denominada VentanaPrincipal define una interfaz gráfica
 * que permitirá consultar un menú principal con cinco figuras
 * geométricas (tres del libro y dos del ejercicio propuesto).
 * @version 1.2/2020
 */
public class VentanaPrincipal extends JFrame implements ActionListener {
    // Un contenedor de elementos gráficos
    private Container contenedor;
    // Botones para seleccionar una figura geométrica determinada
    private JButton cilindro, esfera, pirámide;
    // (Ejercicio propuesto) Botones para el cubo y el prisma
    private JButton cubo, prisma;
    /**
     * Constructor de la clase VentanaPrincipal
     */
    public VentanaPrincipal(){
        inicio();
        setTitle("Figuras"); // Establece el título de la ventana
        setSize(350,180); // Establece el tamaño de la ventana
        setLocationRelativeTo(null); /* La ventana se posiciona en el
            centro de la pantalla */
        // Establece que el botón de cerrar permitirá salir de la aplicación
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        // Establece el botón del cilindro
        cilindro = new JButton();
        cilindro.setText("Cilindro");
        cilindro.setBounds(20, 40, 90, 23); /* Establece la posición del
            botón del cilindro */
        /* Agrega al botón un ActionListener para que gestione eventos
            del botón */
        cilindro.addActionListener(this);
        // Establece el botón de la esfera
        esfera = new JButton();
        esfera.setText("Esfera");
        esfera.setBounds(125, 40, 90, 23); /* Establece la posición del
            botón de la esfera */
        /* Agrega al botón un ActionListener para que gestione eventos
            del botón */
        esfera.addActionListener(this);
        // Establece el botón de la pirámide
        pirámide = new JButton();
        pirámide.setText("Pirámide");
        pirámide.setBounds(230, 40, 95, 23); /* Establece la posición
            del botón de la pirámide */
        /* Agrega al botón un ActionListener para que gestione eventos
            del botón */
        pirámide.addActionListener(this);
        // (Ejercicio propuesto) Establece el botón del cubo
        cubo = new JButton();
        cubo.setText("Cubo");
        cubo.setBounds(70, 80, 90, 23); /* Establece la posición del
            botón del cubo */
        cubo.addActionListener(this);
        // (Ejercicio propuesto) Establece el botón del prisma
        prisma = new JButton();
        prisma.setText("Prisma");
        prisma.setBounds(180, 80, 90, 23); /* Establece la posición del
            botón del prisma */
        prisma.addActionListener(this);
        // Se añade cada componente gráfico al contenedor de la ventana
        contenedor.add(cilindro);
        contenedor.add(esfera);
        contenedor.add(pirámide);
        contenedor.add(cubo);
        contenedor.add(prisma);
    }
    /**
     * Método que gestiona los eventos generados en la ventana principal
     */
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == esfera) { // Si se pulsa el botón esfera
            VentanaEsfera esfera = new VentanaEsfera(); /* Crea la
                ventana de la esfera */
            esfera.setVisible(true); /* Establece que se visualice la ventana
                de la esfera */
        }
        if (evento.getSource() == cilindro) { /* Si se pulsa el botón
            cilindro */
            VentanaCilindro cilindro = new VentanaCilindro(); /* Crea la
                ventana del cilindro */
            cilindro.setVisible(true); /* Establece que se visualice la
                ventana del cilindro */
        }
        if (evento.getSource() == pirámide) { /* Si se pulsa el botón
            pirámide */
            VentanaPirámide pirámide = new VentanaPirámide(); /* Crea
                la ventana de la pirámide */
            pirámide.setVisible(true); /* Establece que se visualice la
                ventana de la pirámide */
        }
        if (evento.getSource() == cubo) { // (Propuesto) Si se pulsa el botón cubo
            VentanaCubo cubo = new VentanaCubo(); // Crea la ventana del cubo
            cubo.setVisible(true); // Se visualiza la ventana del cubo
        }
        if (evento.getSource() == prisma) { // (Propuesto) Si se pulsa el botón prisma
            VentanaPrisma prisma = new VentanaPrisma(); // Crea la ventana del prisma
            prisma.setVisible(true); // Se visualiza la ventana del prisma
        }
    }
}
