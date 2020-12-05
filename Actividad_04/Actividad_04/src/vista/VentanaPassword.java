/*
 * 
 * TRABAJO REALIZADO POR IGNACIO ARTIMEZ AYUELA
 * ACTIVIDAD 04 - DESARROLLO DE INTERFACES
 * 
 * */

package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import controlador.ManejadorEventos;

public class VentanaPassword extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JPasswordField passwordField;
	public JTextField txtContraseaIncorrecta;
	private Boolean activar = false;
	private ManejadorEventos controlador;
	private Boolean ok = false;
	JButton okButton = new JButton("Aceptar");
	JButton cancelButton = new JButton("Cancel");

	/**
	 * Create the dialog.
	 */
	public VentanaPassword(ManejadorEventos controlador) {
		 
		this.controlador = controlador;
		
		contentPanel.setBackground(new Color(51, 110, 141));
		setBounds(100, 100, 450, 191);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			passwordField = new JPasswordField();
			passwordField.setBounds(128, 38, 285, 26);
			contentPanel.add(passwordField);
		}
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(22, 26, 96, 46);
		contentPanel.add(lblNewLabel);
		
		txtContraseaIncorrecta = new JTextField();
		txtContraseaIncorrecta.setForeground(Color.RED);
		txtContraseaIncorrecta.setBackground(new Color(51, 110, 141));
		txtContraseaIncorrecta.setText("Contrase\u00F1a incorrecta");
		txtContraseaIncorrecta.setVisible(ok);
		txtContraseaIncorrecta.setBounds(128, 88, 137, 20);
		contentPanel.add(txtContraseaIncorrecta);
		txtContraseaIncorrecta.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(51, 110, 141));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton.addActionListener(controlador);
				//okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				//getRootPane().setDefaultButton(okButton);
			}
		}
		
	}
	
	public JPasswordField getPassword() {
		return passwordField;
	}
	
	public JButton getAceptar() {
		return okButton;
	}
	
	public JButton getCancel() {
		return cancelButton;
	}
	
	public Boolean getActivar() {
		return activar;
	}
	
	public JTextField getError() {
		return txtContraseaIncorrecta;
	}
	
	public void setError(Boolean ok) {
		this.ok = ok;
	}
	
}
