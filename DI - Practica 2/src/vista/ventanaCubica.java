package vista;

//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.IOException;

public class ventanaCubica extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField password;
    private JLabel labelPassword;
   // private JButton buttonPassword;

    public ventanaCubica() {

        setSize(400,300);
        setLocationRelativeTo(null); // Con "null" hacemos que la calculadora aparezca en el centro de la pantalla
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Si clicamos en la "x" la calculadora se cierra.
        setResizable(false); // Impedimos poder redimensionar la calculadora.
        setTitle("Escriba contraseña."); // Titulo de la calculadora.
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/vista/imagenes/Calculator-icon.png")); // Icono
                                                                                                      // calculadora.
        setLayout(null); // Desactivamos la colocoacion de los componentes automaticamente.
        setVisible(false);
        inicializar();
    }

    private void inicializar() {

        getContentPane().setBackground(new Color(255, 255, 255));

       
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("fonts/LEDCalculator.ttf"));

            password = new JTextField();
            password.setBounds(140, 110, 120, 30); // Posicionamos en la calculadora.
            password.setFont(font.deriveFont(Font.PLAIN, 14f));
            password.requestFocus();
            add(password);

        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
           
        
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("fonts/LEDCalculator.ttf"));
            
            labelPassword = new JLabel("Escriba la contraseña: ");
            labelPassword.setBounds(85, 50, 240, 60); // Posicionamos en la calculadora.
            labelPassword.setFont(font.deriveFont(Font.PLAIN, 16f));
            add(labelPassword);

        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // try {
        //    Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("fonts/LEDCalculator.ttf"));
        // } catch (FontFormatException e) {
        //     e.printStackTrace();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        //     buttonPassword = new JButton("Aceptar");
        //     buttonPassword.setBounds(140, 150, 100, 30); // Posicionamos en la calculadora.
        //     buttonPassword.setFont(font.deriveFont(Font.PLAIN, 14f));
        //     add(buttonPassword);

        
    }
    
}
