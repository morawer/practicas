package controlador;

import vista.ventanaMain;

public class Main {
    public static void main(String[] args) throws Exception {
        ventanaMain calculadora = new ventanaMain();
        gestorEventos gestor = new gestorEventos(calculadora);
    }
}