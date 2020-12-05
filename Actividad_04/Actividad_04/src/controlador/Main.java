/*
 * 
 * TRABAJO REALIZADO POR IGNACIO ARTIMEZ AYUELA
 * ACTIVIDAD 04 - DESARROLLO DE INTERFACES
 * 
 * */

package controlador;

import vista.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {
		VentanaPrincipal miVentana = new VentanaPrincipal();
		ManejadorEventos manejador = new ManejadorEventos(miVentana);
		miVentana.establecerManejador(manejador);
	}

}
