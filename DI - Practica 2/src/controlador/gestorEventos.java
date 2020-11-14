package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

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
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(new File("src/vista/sounds/sound.wav")));
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                System.out.println("Error al reproducir el sonido.");
            }

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
            } catch (Exception e1) {
                calculadora.getNum1().setText("");
                calculadora.getNum2().setText("");
                calculadora.getNum1().requestFocus();
            }
            // Si se clica en el boton "Resta" hace la resta de los numeros escritos en las
            // dos cajas de texto.
        } else if (e.getSource() == calculadora.getRestarBoton()) {

            try {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(new File("src/vista/sounds/sound.wav")));
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                System.out.println("Error al reproducir el sonido.");
            }

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
                calculadora.getNum1().setText("");
                calculadora.getNum2().setText("");
                calculadora.getNum1().requestFocus();
            }
            // Si se clica en el boton "Multiplicación" hace la multiplicación de los
            // numeros escritos en las dos cajas de texto.
        } else if (e.getSource() == calculadora.getMultiplicarBoton()) {

            try {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(new File("src/vista/sounds/sound.wav")));
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                System.out.println("Error al reproducir el sonido.");
            }

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
            } catch (Exception e3) {
                calculadora.getNum1().setText("");
                calculadora.getNum2().setText("");
                calculadora.getNum1().requestFocus();
            }
            // Si se clica en el boton "División" hace la división de los números escritos
            // en las dos cajas de texto.
        } else if (e.getSource() == calculadora.getDividirBoton()) {

            try {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(new File("src/vista/sounds/sound.wav")));
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                System.out.println("Error al reproducir el sonido.");
            }

            try {
                resul = Float.parseFloat(calculadora.getNum1().getText())
                        / Float.parseFloat(calculadora.getNum2().getText());
                calculadora.getResultado().setText(Float.toString(resul));
                // Al terminar el calculo vacia las cajas de texto y hace focus en la primera
                // caja.
                calculadora.getNum1().setText("");
                calculadora.getNum2().setText("");
                calculadora.getNum1().requestFocus();
                // Sino se meten numeros o se deja las cajas vacias se imprime el mensaje y se
                // vacian las cajas y se hace focus en la primera caja.
            } catch (Exception e4) {
                calculadora.getNum1().setText("");
                calculadora.getNum2().setText("");
                calculadora.getNum1().requestFocus();
            }
        }
    }
}