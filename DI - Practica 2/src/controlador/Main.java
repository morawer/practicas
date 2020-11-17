package controlador;

import vista.ventanaCubica;
import vista.ventanaMain;

public class Main {
    public static void main(String[] args) throws Exception {

        ventanaMain calculadora = new ventanaMain();
        ventanaCubica cubica = new ventanaCubica();
        gestorEventos gestorEv = new gestorEventos(calculadora);
        gestorEventos gestorEv1 = new gestorEventos(cubica);
        calculadora.gestor(gestorEv);
        cubica.gestorCubica(gestorEv1);
    }
}