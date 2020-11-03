package vista;

import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.gestorEventos;

public class ventanaMain extends JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel etiquetaNum1, etiquetaNum2, etiquetaResultado;
    private JTextField num1, num2, resultado;
    private JButton restarBoton, sumarBoton, multiplicarBoton, dividirBoton;

    public ventanaMain() {

        setSize(470, 500); // Tamaño de la calculadora
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
        // Creamos una etiqueta y la posicionamos.
        etiquetaNum1 = new JLabel("Número 1: ");
        etiquetaNum1.setBounds(100, 60, 80, 30); // Posicionamos en la calculadora.
        add(etiquetaNum1);
        // Creamos una caja de texto donde introducir los numeros.
        num1 = new JTextField();
        num1.setBounds(200, 45, 120, 60); // Posicionamos en la calculadora.
        add(num1);
        num1.setBorder(null);
        // Creamos una etiqueta y la posicionamos.
        etiquetaNum2 = new JLabel("Número 2: ");
        etiquetaNum2.setBounds(100, 140, 80, 30); // Posicionamos en la calculadora.
        add(etiquetaNum2);
        // Creamos una caja de texto donde introducir los numeros.
        num2 = new JTextField();
        num2.setBounds(200, 125, 120, 60); // Posicionamos en la calculadora.
        add(num2);
        num2.setBorder(null);
        // Creamos el boton "Suma". Este boton se mantiene a la espera de ser clicado.
        sumarBoton = new JButton("Sumar");
        sumarBoton.setBounds(100, 225, 120, 60); // Posicionamos en la calculadora.
        add(sumarBoton);
        sumarBoton.addActionListener(new gestorEventos(this));
        // Creamos el boton "Resta". Este boton se mantiene a la espera de ser clicado.
        restarBoton = new JButton("Restar");
        restarBoton.setBounds(240, 225, 120, 60); // Posicionamos en la calculadora.
        add(restarBoton);
        restarBoton.addActionListener(new gestorEventos(this));
        // Creamos el boton "Multiplicar". Este boton se mantiene a la espera de ser
        // clicado.
        multiplicarBoton = new JButton("Multiplicar");
        multiplicarBoton.setBounds(100, 300, 120, 60); // Posicionamos en la calculadora.
        add(multiplicarBoton);
        multiplicarBoton.addActionListener(new gestorEventos(this));
        // Creamos el boton "Dividir". Este boton se mantiene a la espera de ser
        // clicado.
        dividirBoton = new JButton("Dividir");
        dividirBoton.setBounds(240, 300, 120, 60); // Posicionamos en la calculadora.
        add(dividirBoton);
        dividirBoton.addActionListener(new gestorEventos(this));
        // Creamos la etiqueta de resultado
        etiquetaResultado = new JLabel("Resultado: ");
        etiquetaResultado.setBounds(100, 375, 80, 30); // Posicionamos en la calculadora.
        add(etiquetaResultado);
        // Creamos el cajon de texto que mostrará el resultado.
        resultado = new JTextField();
        resultado.setBounds(200, 375, 160, 30); // Posicionamos en la calculadora.
        resultado.setBackground(null); // Desactivamos el fondo del cajón.
        resultado.setBorder(null); // Desactivamos los bordes del cajón.
        add(resultado);
    }
    //Metodo que aglutina los eventos.
    public void gestor(gestorEventos eventos) {
        sumarBoton.addActionListener(eventos);
        restarBoton.addActionListener(eventos);
        multiplicarBoton.addActionListener(eventos);
        dividirBoton.addActionListener(eventos);
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
}