/*
 * 
 * TRABAJO REALIZADO POR IGNACIO ARTIMEZ AYUELA
 * ACTIVIDAD 04 - DESARROLLO DE INTERFACES
 * 
 * */

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import vista.*;

public class ManejadorEventos implements ActionListener {
	private VentanaPrincipal ventana;
	private VentanaPassword ventana2;

	public ManejadorEventos(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JTextField box1 = ventana.getNum1();
		JTextField box2 = ventana.getNum2();
		Boolean div = false;
		Boolean raiz = false;
		Boolean raizC = false;
		Boolean Ctrue = false;

		try {

			double resultado = 0;
			double numero1 = Double.parseDouble(ventana.getNum1().getText());
			double numero2 = Double.parseDouble(ventana.getNum2().getText());

			if (e.getSource() == ventana.getBotonSuma()) {
				resultado = numero1 + numero2;
			} else if (e.getSource() == ventana.getBotonResta()) {
				resultado = numero1 - numero2;
			} else if (e.getSource() == ventana.getBotonMult()) {
				resultado = numero1 * numero2;
			} else if (e.getSource() == ventana.getBotonDiv()) {
				if (numero2 == 0) {
					System.out.println("Division por 0");
					div = true;
				} else {
					resultado = numero1 / numero2;
				}
			} else if (e.getSource() == ventana.getBotonRaiz()) {

				System.out.println("Ventana Raiz Cuadrada");
				VentanaRaiz ventana1 = new VentanaRaiz();
				ventana1.setVisible(true);
				raiz = true;

			} else if (e.getSource() == ventana.getBotonRaizC()) {

				System.out.println("Ventana Raiz Password Cubica");

				raizC = true;
			    JPasswordField pwd = new JPasswordField(10);
			    JOptionPane.showConfirmDialog(null, pwd,"Enter Password",JOptionPane.OK_CANCEL_OPTION);
			    String password = new String(pwd.getPassword());
			    String correctPass = "secret";
				
			    
				if(password.equals(correctPass)) {
					System.out.println("Contraseña Correcta");
					Ctrue = true;
					resultado = Math.pow(numero1, (double) 1 / 3);
				}else {
					JOptionPane.showMessageDialog(null,"Contraseña incorrecta", "Error", JOptionPane.WARNING_MESSAGE);
				}
				System.out.println(resultado);

			}

			DecimalFormat format = new DecimalFormat("0.#");
			String r = String.valueOf(format.format(resultado));
			
			//Sacamos por pantalla es función de la opción
			if (div == true) {
				ventana.getResultado().setText("Division por 0 no posible");
			} else if (div == true) {
				ventana.getResultado().setText("Division por 0");
			} else if (raiz == true) {
				ventana.getResultado().setText("");
			} else if (raizC == true) {
				if(Ctrue == true) {
					ventana.getResultado().setText("La raiz cúbica de " + numero1 + " es: " + r);
				}else {
					ventana.getResultado().setText("Contraseña incorrecta");
				}
			}else {
				ventana.getResultado().setText("EL RESULTADO ES: " + r);
			}

			// Resultado
			System.out.println(r);

			
			
		// Capturamos las exceptions
		} catch (NumberFormatException b) {
			if (box1.getText().equals("") && box2.getText().equals("")) {
				System.out.println("Rellene ambos campos");
				ventana.getResultado().setText("Rellene ambos campos");
			} else if (box1.getText().equals("")) {
				System.out.println("Inserte numero 1");
				ventana.getResultado().setText("Inserte numero 1");
			} else {
				System.out.println("Inserte numero 2");
				ventana.getResultado().setText("Inserte numero 2");
			}

		} catch (Exception b) {
			System.out.println("Algo ha salido mal");
		}

	}

	public VentanaPassword getVentana2() {
		return ventana2;
	}

	public void setVentana2(VentanaPassword ventana2) {
		this.ventana2 = ventana2;
	}

}
