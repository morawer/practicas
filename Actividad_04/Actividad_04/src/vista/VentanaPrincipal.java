/*
 * 
 * TRABAJO REALIZADO POR IGNACIO ARTIMEZ AYUELA
 * ACTIVIDAD 04 - DESARROLLO DE INTERFACES
 * 
 * */

package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;

import controlador.ManejadorEventos;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Botones
	private JButton botonSumar;
	private JButton botonRestar;
	private JButton botonMultiplicar;
	private JButton botonDividir;
	private JButton botonRaiz;
	private JButton botonRaizC;


	// Label
	private JLabel eNum1, eNum2;
	private JLabel resultado;
	
	// Cajas
	private JTextField num1, num2;
	private JLabel img;

	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 500);
		setLocationRelativeTo(null);
		setLayout(null);
		inicializarComponentes();
		setTitle("Calculadora - Estilizada");
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/header.png"));  
		setVisible(true);
	}

	private void inicializarComponentes() {
		
		//Fuentes
		Font f1 = new Font(Font.DIALOG, Font.PLAIN, 15);
		Font f2 = new Font(Font.DIALOG, Font.BOLD, 15);

		//Label
		eNum1 = new JLabel("Numero 1:");
		eNum1.setFont(f1);
		eNum1.setForeground(Color.white);
		eNum1.setBounds(50, 20, 180, 30);
		num1 = new JTextField();
		num1.setBounds(140, 20, 200, 30);

		eNum2 = new JLabel("Numero 2:");
		eNum2.setFont(f1);
		eNum2.setForeground(Color.white);
		eNum2.setBounds(50, 55, 180, 30);
		num2 = new JTextField();
		num2.setBounds(140, 55, 200, 30);
				
		//Botones
		botonSumar = new JButton(new ImageIcon("images/sumar.png"));
		botonSumar.setBounds(70, 120, 100, 30);
		botonSumar.setEnabled(true);
		
		botonRestar = new JButton(new ImageIcon("images/restar.png"));
		botonRestar.setBounds(200, 120, 100, 30);
		botonRestar.setEnabled(true);
		
		botonMultiplicar = new JButton(new ImageIcon("images/multiplicar.png"));
		botonMultiplicar.setBounds(70, 180, 100, 30);
		botonMultiplicar.setEnabled(true);
		
		botonDividir = new JButton(new ImageIcon("images/dividir.png"));
		botonDividir.setBounds(200, 180, 100, 30);
		botonDividir.setEnabled(true);
		
		botonRaiz = new JButton(new ImageIcon("images/raiz.png"));
		botonRaiz.setBounds(70, 240, 100, 30);
		botonRaiz.setEnabled(true);
		
		botonRaizC = new JButton(new ImageIcon("images/raizC.png"));
		botonRaizC.setBounds(200, 240, 100, 30);
		botonRaizC.setEnabled(true);
		
		//Resultado
		resultado = new JLabel();
		resultado.setBounds(40, 280, 280, 80);
		resultado.setFont(f2);
		resultado.setForeground(Color.white);
		
		//Background
        JPanel panel=new JPanel();  
        panel.setBounds(0,0,400,500);    
        panel.setBackground(new Color(51, 110, 141)); 
        
        //Icon
        Image icon = new ImageIcon("images.jpg/esjgluxR_400x400.jpg").getImage();
        
        //Image
        img = new JLabel(new ImageIcon("images/header.png"));
        img.setBounds(0, 370, 400, 50);
        
		//Add
		add(eNum1);
		add(eNum2);
		add(num1);
		add(num2);
		add(botonSumar);
		add(botonRestar);
		add(botonMultiplicar);
		add(botonDividir);
		add(resultado);
		add(img);
		add(botonRaiz);
		add(botonRaizC);
		add(panel);
	}

	public void establecerManejador(ManejadorEventos manejador) {
		botonSumar.addActionListener(manejador);
		botonRestar.addActionListener(manejador);
		botonMultiplicar.addActionListener(manejador);
		botonDividir.addActionListener(manejador);
		botonRaiz.addActionListener(manejador);
		botonRaizC.addActionListener(manejador);
	}
	
	//GET
	public JTextField getNum1() {
		return num1;
	}
	
	public void setNum1(String numero1) {
		num1.setText(numero1);
	}
	
	public JTextField getNum2() {
		return num2;
	}
	
	public JButton getBotonSuma() {
		return botonSumar;
	}
	
	public JButton getBotonResta() {
		return botonRestar;
	}
	
	public JButton getBotonMult() {
		return botonMultiplicar;
	}
	
	public JButton getBotonDiv() {
		return botonDividir;
	}
	
	public JButton getBotonRaiz() {
		return botonRaiz;
	}
	
	public JButton getBotonRaizC() {
		return botonRaizC;
	}
	
	public JLabel getResultado() {
		return resultado;
	}
	
	public JLabel getImage() {
		return img;
	}

	
}
