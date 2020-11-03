package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.ventanaMain;

public class gestorEventos implements ActionListener {

    private ventanaMain calculadora;

    public gestorEventos(ventanaMain calculadora) {
        this.calculadora = calculadora;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        float resul; // Variable que alberga el resultado.
        // Si se clica en el boton "Suma" hace la suma de los numeros escritos en las
        // dos cajas de texto.
        if (e.getSource() == calculadora.getSumarBoton()) {

            try {
                resul = Float.parseFloat(calculadora.getNum1().getText())
                        + Float.parseFloat(calculadora.getNum2().getText());
                calculadora.getResultado().setText(Float.toString(resul));
                // Al terminar el calculo vacia las cojas de texto y hace focus en la primera
                // caja.
                calculadora.getNum1().setText("");
                calculadora.getNum2().setText("");
                calculadora.getNum1().requestFocus();
                // Sino se meten numeros o se deja las cajas vacias se imprime el mensaje y se
                // vacian las cajas y se hace focus en la primera caja.
            } catch (Exception e2) {
                System.out.println("Debe introducir numeros.");
                calculadora.getNum1().setText("");
                calculadora.getNum2().setText("");
                calculadora.getNum1().requestFocus();
            }
            // Si se clica en el boton "Resta" hace la resta de los numeros escritos en las
            // dos cajas de texto.
        } else if (e.getSource() == calculadora.getRestarBoton()) {

            try {
                resul = Float.parseFloat(calculadora.getNum1().getText())
                        - Float.parseFloat(calculadora.getNum2().getText());
                calculadora.getResultado().setText(Float.toString(resul));
                // Al terminar el calculo vacia las cojas de texto y hace focus en la primera
                // caja.
                calculadora.getNum1().setText("");
                calculadora.getNum2().setText("");
                calculadora.getNum1().requestFocus();
                // Sino se meten numeros o se deja las cajas vacias se imprime el mensaje y se
                // vacian las cajas y se hace focus en la primera caja.
            } catch (Exception e2) {
                System.out.println("Debe introducir numeros.");
                calculadora.getNum1().setText("");
                calculadora.getNum2().setText("");
                calculadora.getNum1().requestFocus();
            }
            // Si se clica en el boton "Multiplicación" hace la multiplicación de los
            // numeros escritos en las dos cajas de texto.
        } else if (e.getSource() == calculadora.getMultiplicarBoton()) {

            try {
                resul = Float.parseFloat(calculadora.getNum1().getText())
                        * Float.parseFloat(calculadora.getNum2().getText());
                calculadora.getResultado().setText(Float.toString(resul));
                // Al terminar el calculo vacia las cojas de texto y hace focus en la primera
                // caja.
                calculadora.getNum1().setText("");
                calculadora.getNum2().setText("");
                calculadora.getNum1().requestFocus();
                // Sino se meten numeros o se deja las cajas vacias se imprime el mensaje y se
                // vacian las cajas y se hace focus en la primera caja.
            } catch (Exception e2) {
                System.out.println("Debe introducir numeros.");
                calculadora.getNum1().setText("");
                calculadora.getNum2().setText("");
                calculadora.getNum1().requestFocus();
            }
            // Si se clica en el boton "División" hace la división de los números escritos
            // en las dos cajas de texto.
        } else if (e.getSource() == calculadora.getDividirBoton()) {

            try {
                resul = Float.parseFloat(calculadora.getNum1().getText())
                        / Float.parseFloat(calculadora.getNum2().getText());
                calculadora.getResultado().setText(Float.toString(resul));
                // Al terminar el calculo vacia las cojas de texto y hace focus en la primera
                // caja.
                calculadora.getNum1().setText("");
                calculadora.getNum2().setText("");
                calculadora.getNum1().requestFocus();
                // Sino se meten numeros o se deja las cajas vacias se imprime el mensaje y se
                // vacian las cajas y se hace focus en la primera caja.
            } catch (Exception e2) {
                System.out.println("Debe introducir numeros.");
                calculadora.getNum1().setText("");
                calculadora.getNum2().setText("");
                calculadora.getNum1().requestFocus();
            }
        }
    }
}