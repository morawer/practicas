import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.ArrayList;
import java.util.Scanner;

import javax.crypto.Cipher;

public class App {
    public static void main(String[] args) throws Exception {

        try {

            KeyPairGenerator generador = KeyPairGenerator.getInstance("RSA"); // En vez de KeyGenerator usamos
                                                                              // KeyPairGenerator.
            KeyPair claves = generador.generateKeyPair(); // Obtenemos el par de clavespublica y privada).
            
            Cipher cifrador = Cipher.getInstance("RSA");

            Scanner scMenu = new Scanner(System.in);
            Scanner sc = new Scanner(System.in);
            Scanner scCoche = new Scanner(System.in);

            int opcMenu;
            byte[] bytesMatricula;
            byte[] bytesMarca;
            byte[] bytesModelo;
            byte[] bytesPrecio;

            byte[] bytesMatriculaCifrado;
            byte[] bytesMarcaCifrado;
            byte[] bytesModeloCifrado;
            byte[] bytesPrecioCifrado;

            byte[] bytesMatriculaDescifrado;
            byte[] bytesMarcaDescifrado;
            byte[] bytesModeloDescifrado;
            byte[] bytesPrecioDescifrado;

            String matricula;
            String marca;
            String modelo;
            String precio;

            String matriculaCifrado;
            String marcaCifrado;
            String modeloCifrado;
            String precioCifrado;

            String matriculaDescifrado;
            String marcaDescifrado;
            String modeloDescifrado;
            String precioDescifrado;

            byte[] bytesMensajeOriginal = null;
            byte[] bytesMensajeDescifrado = null;
            byte[] bytesMensajeCifrado = null;
            String mensajeCifrado;
            ArrayList<Coches> cochesList = new ArrayList<Coches>();

            do {
                System.out.println(menu());

                opcMenu = scMenu.nextInt();

                switch (opcMenu) {
                    case 1:
                        cifrador.init(Cipher.ENCRYPT_MODE, claves.getPrivate());
                        String mensajeOriginal = sc.nextLine();
                        bytesMensajeOriginal = mensajeOriginal.getBytes();
                        bytesMensajeCifrado = cifrador.doFinal(bytesMensajeOriginal);
                        break;

                    case 2:
                        mensajeCifrado = new String(bytesMensajeCifrado);
                        System.out.println("Mensaje Cifrado: " + mensajeCifrado);
                        break;

                    case 3:
                        cifrador.init(Cipher.DECRYPT_MODE, claves.getPublic());
                        bytesMensajeDescifrado = cifrador.doFinal(bytesMensajeCifrado);
                        System.out.println("Mensaje Descifrado: " + new String(bytesMensajeDescifrado));
                        break;

                    case 4:

                        cifrador.init(Cipher.ENCRYPT_MODE, claves.getPrivate());
                        System.out.println("Introduzca la matricula: ");
                        matricula = scCoche.nextLine();
                        bytesMatricula = matricula.getBytes();
                        bytesMatriculaCifrado = cifrador.doFinal(bytesMatricula);
                        //matriculaCifrado = new String(bytesMatriculaCifrado);

                        cifrador.init(Cipher.ENCRYPT_MODE, claves.getPrivate());
                        System.out.println("Introduzca la marca: ");
                        marca = scCoche.nextLine();
                        bytesMarca = marca.getBytes();
                        bytesMarcaCifrado = cifrador.doFinal(bytesMarca);
                        //marcaCifrado = new String(bytesMarcaCifrado);

                        cifrador.init(Cipher.ENCRYPT_MODE, claves.getPrivate());
                        System.out.println("Introduzca el modelo: ");
                        modelo = scCoche.nextLine();
                        bytesModelo = modelo.getBytes();
                        bytesModeloCifrado = cifrador.doFinal(bytesModelo);
                        //modeloCifrado = new String(bytesModeloCifrado);

                        cifrador.init(Cipher.ENCRYPT_MODE, claves.getPrivate());
                        System.out.println("Introduzca el precio: ");
                        precio = scCoche.nextLine();
                        bytesPrecio = precio.getBytes();
                        bytesPrecioCifrado = cifrador.doFinal(bytesPrecio);
                        //precioCifrado = new String(bytesPrecioCifrado);

                        Coches coche = new Coches(bytesMatriculaCifrado, bytesMarcaCifrado, bytesModeloCifrado, bytesPrecioCifrado);
                        cochesList.add(coche);
                        System.out.println(coche.toString());
                        break;

                    case 5:
                        
                        for (Coches cocheFor : cochesList) {

                            cifrador.init(Cipher.DECRYPT_MODE, claves.getPublic());
                            bytesMatriculaCifrado = cocheFor.getMatricula();
                            bytesMatriculaDescifrado = cifrador.doFinal(bytesMatriculaCifrado);
                            matriculaDescifrado = new String(bytesMatriculaDescifrado);

                            cifrador.init(Cipher.DECRYPT_MODE, claves.getPublic());
                            bytesMarcaCifrado = cocheFor.getMarca();
                            bytesMarcaDescifrado = cifrador.doFinal(bytesMarcaCifrado);
                            marcaDescifrado = new String(bytesMarcaDescifrado);

                            cifrador.init(Cipher.DECRYPT_MODE, claves.getPublic());
                            bytesModeloCifrado = cocheFor.getModelo();
                            bytesModeloDescifrado = cifrador.doFinal(bytesModeloCifrado);
                            modeloDescifrado = new String(bytesModeloDescifrado);

                            cifrador.init(Cipher.DECRYPT_MODE, claves.getPublic()); 
                            bytesPrecioCifrado = cocheFor.getPrecio();
                            bytesPrecioDescifrado = cifrador.doFinal(bytesPrecioCifrado);
                            precioDescifrado = new String(bytesPrecioDescifrado);

                            System.out.println("Coches [matricula=" + matriculaDescifrado + ", marca=" + marcaDescifrado
                                    + ", modelo=" + modeloDescifrado + ", precio=" + precioDescifrado + "]");
                        }
                        break;

                    default:
                        break;
                }

            } while (opcMenu != 6);

            sc.close();
            scMenu.close();
            scCoche.close();

        } catch (GeneralSecurityException e) {
            System.out.println("Error al cifrar o descifrar el mensaje");
            System.out.println("Excepción de tipo: " + e.getClass().getName());
            System.out.println(e.getMessage());
        }
    }

    static String menu() {
        return "1. Encriptar frase.\n" + "2. Mostrar frase encriptada.\n" + "3. Desencriptar frase.\n"
                + "4. Encriptar coche.\n" + "5. Mostrar coche.\n" + "6. Salir del programa.\n";

    }
}
