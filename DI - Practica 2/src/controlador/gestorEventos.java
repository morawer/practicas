package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.ventanaMain;

public class gestorEventos implements ActionListener {

    private ventanaMain ventana;

    public gestorEventos(ventanaMain ventana) {
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        float resul; // Variable que alberga el resultado.
        // Si se clica en el boton "Suma" hace la suma de los numeros escritos en las
        // dos cajas de texto.
        if (e.getSource() == ventana.getSumarBoton()) {

            try {
                resul = Float.parseFloat(ventana.getNum1().getText()) + Float.parseFloat(ventana.getNum2().getText());
                ventana.getResultado().setText(Float.toString(resul));
                // Al terminar el calculo vacia las cojas de texto y hace focus en la primera
                // caja.
                ventana.getNum1().setText("");
                ventana.getNum2().setText("");
                ventana.getNum1().requestFocus();
                // Sino se meten numeros o se deja las cajas vacias se imprime el mensaje y se
                // vacian las cajas y se hace focus en la primera caja.
            } catch (Exception e2) {
                System.out.println("Debe introducir numeros.");
                ventana.getNum1().setText("");
                ventana.getNum2().setText("");
                ventana.getNum1().requestFocus();
            }
            // Si se clica en el boton "Resta" hace la resta de los numeros escritos en las
            // dos cajas de texto.
        } else if (e.getSource() == ventana.getRestarBoton()) {

            try {
                resul = Float.parseFloat(ventana.getNum1().getText()) - Float.parseFloat(ventana.getNum2().getText());
                ventana.getResultado().setText(Float.toString(resul));
                // Al terminar el calculo vacia las cojas de texto y hace focus en la primera
                // caja.
                ventana.getNum1().setText("");
                ventana.getNum2().setText("");
                ventana.getNum1().requestFocus();
                // Sino se meten numeros o se deja las cajas vacias se imprime el mensaje y se
                // vacian las cajas y se hace focus en la primera caja.
            } catch (Exception e2) {
                System.out.println("Debe introducir numeros.");
                ventana.getNum1().setText("");
                ventana.getNum2().setText("");
                ventana.getNum1().requestFocus();
            }
            // Si se clica en el boton "Multiplicación" hace la multiplicación de los
            // numeros escritos en las dos cajas de texto.
        } else if (e.getSource() == ventana.getMultiplicarBoton()) {

            try {
                resul = Float.parseFloat(ventana.getNum1().getText()) * Float.parseFloat(ventana.getNum2().getText());
                ventana.getResultado().setText(Float.toString(resul));
                // Al terminar el calculo vacia las cojas de texto y hace focus en la primera
                // caja.
                ventana.getNum1().setText("");
                ventana.getNum2().setText("");
                ventana.getNum1().requestFocus();
                // Sino se meten numeros o se deja las cajas vacias se imprime el mensaje y se
                // vacian las cajas y se hace focus en la primera caja.
            } catch (Exception e2) {
                System.out.println("Debe introducir numeros.");
                ventana.getNum1().setText("");
                ventana.getNum2().setText("");
                ventana.getNum1().requestFocus();
            }
            // Si se clica en el boton "División" hace la división de los números escritos
            // en las dos cajas de texto.
        } else if (e.getSource() == ventana.getDividirBoton()) {

            try {
                resul = Float.parseFloat(ventana.getNum1().getText()) / Float.parseFloat(ventana.getNum2().getText());
                ventana.getResultado().setText(Float.toString(resul));
                // Al terminar el calculo vacia las cojas de texto y hace focus en la primera
                // caja.
                ventana.getNum1().setText("");
                ventana.getNum2().setText("");
                ventana.getNum1().requestFocus();
                // Sino se meten numeros o se deja las cajas vacias se imprime el mensaje y se
                // vacian las cajas y se hace focus en la primera caja.
            } catch (Exception e2) {
                System.out.println("Debe introducir numeros.");
                ventana.getNum1().setText("");
                ventana.getNum2().setText("");
                ventana.getNum1().requestFocus();
            }
        }
    }
}