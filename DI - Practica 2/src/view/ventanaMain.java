package view;

import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.gestorEventos;

public class ventanaMain extends JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel etiquetaNum1, etiquetaNum2, etiquetaResultado;
    private JTextField num1, num2, resultado;
    private JButton restarBoton, sumarBoton, multiplicarBoton, dividirBoton;

    public ventanaMain() {

        setSize(470, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("CALCULADORA");
        setIconImage(Toolkit.getDefaultToolkit().getImage("Calculator-icon.png"));
        setLayout(null);
        inicializar();
        setVisible(true);
    }

    private void inicializar() {

        etiquetaNum1 = new JLabel("Número 1: ");
        etiquetaNum1.setBounds(100, 60, 80, 30);
        add(etiquetaNum1);

        num1 = new JTextField();
        num1.setBounds(200, 45, 120, 60);
        add(num1);

        etiquetaNum2 = new JLabel("Número 2: ");
        etiquetaNum2.setBounds(100, 140, 80, 30);
        add(etiquetaNum2);

        num2 = new JTextField();
        num2.setBounds(200, 125, 120, 60);
        add(num2);

        sumarBoton = new JButton("Sumar");
        sumarBoton.setBounds(100, 225, 120, 60);
        add(sumarBoton);
        sumarBoton.addActionListener(new gestorEventos(this));

        restarBoton = new JButton("Restar");
        restarBoton.setBounds(240, 225, 120, 60);
        add(restarBoton);
        restarBoton.addActionListener(new gestorEventos(this));


        multiplicarBoton = new JButton("Multiplicar");
        multiplicarBoton.setBounds(100, 300, 120, 60);
        add(multiplicarBoton);

        dividirBoton = new JButton("Dividir");
        dividirBoton.setBounds(240, 300, 120, 60);
        add(dividirBoton);

        etiquetaResultado = new JLabel("Resultado: ");
        etiquetaResultado.setBounds(100, 375, 80, 30);
        add(etiquetaResultado);

        resultado = new JTextField();
        resultado.setBounds(200, 375, 160, 30);
        resultado.setBackground(null);
        resultado.setBorder(null);
        add(resultado);



            
        }

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


