/*
 * 
 * TRABAJO REALIZADO POR IGNACIO ARTIMEZ AYUELA
 * ACTIVIDAD 04 - DESARROLLO DE INTERFACES
 * 
 * */


package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRaiz extends JDialog {

	private final JPanel contentPanel = new JPanel();
	/**
	 * Create the dialog.
	 */
	public VentanaRaiz() {
		contentPanel.setBackground(new Color(51, 110, 141));
		setBounds(100, 100, 453, 142);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(51, 110, 141));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Funcionalidad no disponible");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBounds(136, 11, 160, 49);
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
			contentPanel.add(lblNewLabel);
		}
		{
			contentPanel.setBackground(new Color(51, 110, 141));
		}
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBounds(338, 69, 89, 23);
		contentPanel.add(btnNewButton);
	}
}
