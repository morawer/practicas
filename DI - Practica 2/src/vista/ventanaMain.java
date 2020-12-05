package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import controlador.gestorEventos;

public class ventanaMain extends JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel etiquetaNum1, etiquetaNum2, etiquetaResultado, logo;
    private JTextField num1, num2, resultado;
    private JButton restarBoton, sumarBoton, multiplicarBoton, dividirBoton, raizCuadrada, raizCubica;

    public ventanaMain() {

        setSize(470, 700); // TamaÃ±o de la calculadora
        setLocationRelativeTo(null); // Con "null" hacemos que la calculadora aparezca en el centro de la pantalla
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Si clicamos en la "x" la calculadora se cierra.
        setResizable(false); // Impedimos poder redimensionar la calculadora.
        setTitle("CALCULADORA"); // Titulo de la calculadora.
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/vista/imagenes/Calculator-icon.png")); // Icono
                                                                                                      // calculadora.
        setLayout(null); // Desactivamos la colocoacion de los componentes automaticamente.
        inicializar(); // Funcion que contiene los componentes de la calculadora.
        setVisible(true);
    }

    private void inicializar() {

        getContentPane().setBackground(new Color(255, 255, 255));

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("fonts/Calculator.ttf"));
            // Creamos una caja de texto donde introducir los numeros.
            num1 = new JTextField();
            num1.setBounds(180, 245, 120, 60); // Posicionamos en la calculadora.
            num1.setFont(font.deriveFont(Font.PLAIN, 28f));
            num1.requestFocus();
            add(num1);
            num1.setBorder(null);

            // Creamos una caja de texto donde introducir los numeros.
            num2 = new JTextField();
            num2.setBounds(180, 325, 120, 60); // Posicionamos en la calculadora.
            num2.setFont(font.deriveFont(Font.PLAIN, 28f));
            add(num2);
            num2.setBorder(null);

            // Creamos el cajon de texto que mostrarÃ¡ el resultado.
            resultado = new JTextField();
            resultado.setBounds(180, 420, 160, 30); // Posicionamos en la calculadora.
            resultado.setBackground(null); // Desactivamos el fondo del cajÃ³n.
            resultado.setFont(font.deriveFont(Font.PLAIN, 36f));
            resultado.setBorder(null); // Desactivamos los bordes del cajÃ³n.
            add(resultado);

        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image logo1 = new ImageIcon("src/vista/imagenes/casio.png").getImage();
        logo = new JLabel(new ImageIcon(logo1.getScaledInstance(400, 150, Image.SCALE_SMOOTH)));
        logo.setBounds(80, 35, 310, 200);
        add(logo);

        try {
            Font font2 = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("fonts/LEDCalculator.ttf"));
            // Creamos una etiqueta y la posicionamos.
            etiquetaNum1 = new JLabel("Número 1: ");
            etiquetaNum1.setBounds(80, 260, 105, 30); // Posicionamos en la calculadora.
            etiquetaNum1.setFont(font2.deriveFont(Font.PLAIN, 16f));
            add(etiquetaNum1);

            // Creamos una etiqueta y la posicionamos.
            etiquetaNum2 = new JLabel("Número 2: ");
            etiquetaNum2.setBounds(80, 340, 105, 30); // Posicionamos en la calculadora.
            etiquetaNum2.setFont(font2.deriveFont(Font.PLAIN, 16f));
            add(etiquetaNum2);

            // Creamos el boton "Suma". Este boton se mantiene a la espera de ser clicado.
            sumarBoton = new JButton("+");
            sumarBoton.setBackground(new Color(255, 255, 255));
            sumarBoton.setBounds(350, 200, 50, 50); // Posicionamos en la calculadora.
            sumarBoton.setFont(font2.deriveFont(Font.PLAIN, 30f));
            sumarBoton.setBorder(null);
            add(sumarBoton);
            
            // Creamos el boton "Resta". Este boton se mantiene a la espera de ser clicado.
            restarBoton = new JButton("-");
            restarBoton.setBackground(new Color(255, 255, 255));
            restarBoton.setBounds(350, 260, 50, 50); // Posicionamos en la calculadora.
            restarBoton.setFont(font2.deriveFont(Font.PLAIN, 30f));
            restarBoton.setBorder(null);
            add(restarBoton);
            // Creamos el boton "Multiplicar". Este boton se mantiene a la espera de ser
            // clicado.
            multiplicarBoton = new JButton("x");
            multiplicarBoton.setBackground(new Color(255, 255, 255));
            multiplicarBoton.setBounds(350, 320, 50, 50); // Posicionamos en la calculadora.
            multiplicarBoton.setFont(font2.deriveFont(Font.PLAIN, 30f));
            multiplicarBoton.setBorder(null);
            add(multiplicarBoton);
            // Creamos el boton "Dividir". Este boton se mantiene a la espera de ser
            // clicado.
            dividirBoton = new JButton("/");
            dividirBoton.setBackground(new Color(255, 255, 255));
            dividirBoton.setBounds(350, 380, 50, 50); // Posicionamos en la calculadora.
            dividirBoton.setFont(font2.deriveFont(Font.PLAIN, 30f));
            dividirBoton.setBorder(null);
            add(dividirBoton);

            raizCuadrada = new JButton ("√");
            raizCuadrada.setBackground(new Color(255, 255, 255));
            raizCuadrada.setBounds(350, 440, 50, 50);
            raizCuadrada.setFont(font2.deriveFont(Font.PLAIN, 30f));
            raizCuadrada.setBorder(null);
            add(raizCuadrada);

            raizCubica = new JButton ("3√");
            raizCubica.setBackground(new Color(255, 255, 255));
            raizCubica.setBounds(350, 500, 50, 50);
            raizCubica.setFont(font2.deriveFont(Font.PLAIN, 30f));
            raizCubica.setBorder(null);
            add(raizCubica);

            // Creamos la etiqueta de resultado
            etiquetaResultado = new JLabel("=");
            etiquetaResultado.setBounds(110, 420, 50, 30); // Posicionamos en la calculadora.
            etiquetaResultado.setFont(font2.deriveFont(Font.PLAIN, 30f));
            add(etiquetaResultado);

        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metodo que aglutina los eventos.
    public void gestor(gestorEventos eventos) {
        sumarBoton.addActionListener(eventos);
        restarBoton.addActionListener(eventos);
        multiplicarBoton.addActionListener(eventos);
        dividirBoton.addActionListener(eventos);
        raizCuadrada.addActionListener(eventos);
        raizCubica.addActionListener(eventos);
    }

    // Getters y Setters de las etiquetas y cajas de texto.
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public JLabel getEtiquetaNum1() {
        return etiquetaNum1;
    }

    public void setEtiquetaNum1(JLabel etiquetaNum1) {
        this.etiquetaNum1 = etiquetaNum1;
    }

    public JLabel getEtiquetaNum2() {
        return etiquetaNum2;
    }

    public void setEtiquetaNum2(JLabel etiquetaNum2) {
        this.etiquetaNum2 = etiquetaNum2;
    }

    public JLabel getEtiquetaResultado() {
        return etiquetaResultado;
    }

    public void setEtiquetaResultado(JLabel etiquetaResultado) {
        this.etiquetaResultado = etiquetaResultado;
    }

    public JTextField getNum1() {
        return num1;
    }

    public void setNum1(JTextField num1) {
        this.num1 = num1;
    }

    public JTextField getNum2() {
        return num2;
    }

    public void setNum2(JTextField num2) {
        this.num2 = num2;
    }

    public JTextField getResultado() {
        return resultado;
    }

    public void setResultado(JTextField resultado) {
        this.resultado = resultado;
    }

    public JButton getRestarBoton() {
        return restarBoton;
    }

    public void setRestarBoton(JButton restarBoton) {
        this.restarBoton = restarBoton;
    }

    public JButton getSumarBoton() {
        return sumarBoton;
    }

    public void setSumarBoton(JButton sumarBoton) {
        this.sumarBoton = sumarBoton;
    }

    public JButton getMultiplicarBoton() {
        return multiplicarBoton;
    }

    public void setMultiplicarBoton(JButton multiplicarBoton) {
        this.multiplicarBoton = multiplicarBoton;
    }

    public JButton getDividirBoton() {
        return dividirBoton;
    }

    public void setDividirBoton(JButton dividirBoton) {
        this.dividirBoton = dividirBoton;
    }

    public JButton getRaizCuadrada() {
        return raizCuadrada;
    }

    public void setRaizCuadrada(JButton raizCuadrada) {
        this.raizCuadrada = raizCuadrada;
    }

    public JButton getRaizCubica() {
        return raizCubica;
    }

    public void setRaizCubica(JButton raizCubica) {
        this.raizCubica = raizCubica;
    }
}