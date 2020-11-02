package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ventanaMain;

public class gestorEventos implements ActionListener {

    private ventanaMain ventana;

    public gestorEventos(ventanaMain ventana) {
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        float resul;

        if (e.getSource() == ventana.getSumarBoton()) {

            try {

                resul = Float.parseFloat(ventana.getNum1().getText()) + Float.parseFloat(ventana.getNum2().getText());
                ventana.getResultado().setText(Float.toString(resul));

                ventana.getNum1().setText("");
                ventana.getNum2().setText("");
                ventana.getNum1().requestFocus();

            } catch (Exception e2) {
            }

        } else if (e.getSource() == ventana.getRestarBoton()) {

            try {

                resul = Float.parseFloat(ventana.getNum1().getText()) - Float.parseFloat(ventana.getNum2().getText());
                ventana.getResultado().setText(Float.toString(resul));

                ventana.getNum1().setText("");
                ventana.getNum2().setText("");
                ventana.getNum1().requestFocus();

            } catch (Exception e2) {

            }

        }

    }

}
