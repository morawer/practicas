import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {


        ArrayList<Coche> coches = new ArrayList<>();


        FileInputStream fichero;
        DataInputStream lector;

        FileOutputStream archivoDat1;

        archivoDat1 = new FileOutputStream("coches.dat", true);

        fichero = new FileInputStream("coches.dat");
        lector = new DataInputStream(fichero);

        boolean eof = false;

        while (!eof) {
            try {

                String id = lector.readUTF();
                String matricula = lector.readUTF();
                String marca = lector.readUTF();
                String modelo = lector.readUTF();
                String color = lector.readUTF();
                Coche coche = new Coche(id, matricula, marca, modelo, color);
                coches.add(coche);

            } catch (EOFException e1) {
                eof = true;
            } catch (IOException e2) {
                System.out.println("Ha ocurrido un error al leer los registros");
                System.out.println(e2.getMessage());
                break;
            }
        }

        try {
            lector.close();
            fichero.close();
            archivoDat1.close();
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al cerrar el fichero");
            System.out.println(e.getMessage());
        }

        String opc = "";

        do {
            menu();
            Scanner sc = new Scanner(System.in);

            System.out.println("Elige una opción: ");
            opc = sc.next();
            

            switch (opc) {
                case "1":
                    Scanner sc2 = new Scanner(System.in);

                    System.out.println("ID: ");
                    String id = sc2.next();

                    System.out.println("Matricula: ");
                    String matricula = sc2.next();

                    System.out.println("Marca: ");
                    String marca = sc2.next();

                    System.out.println("Modelo: ");
                    String modelo = sc2.next();

                    System.out.println("Color: ");
                    String color = sc2.next();

                    Coche coche = new Coche(id, matricula, marca, modelo, color);

                    coches.add(coche);

                    sc2.close();
                    
                    break;

                case "2":

                    Scanner sc3 = new Scanner(System.in);
                    System.out.print("Introduce un ID: ");
                    String idBorrador = sc3.next();

                    for (Coche c : coches) {
                        if (c.getId() == idBorrador) {
                            System.out.println("El coche con ID: " + c.getId() + " y matricula: " + c.getMatricula()
                                    + " sera borrado.");
                            coches.remove(c);
                        } else {
                            System.out.println("Coche no encontrado.");
                        }
                    }
                    sc3.close();
                    break;

                case "3":

                    Scanner sc4 = new Scanner(System.in);
                    System.out.print("Introduce un ID: ");
                    String idBuscador = sc4.next();

                    for (Coche c : coches) {
                        if (c.getId() == idBuscador) {
                            System.out.println(c);
                        } else {
                            System.out.println("Coche no encontrado.");
                        }
                    }
                    sc4.close();

                    break;

                case "4":

                    listarCoches(coches);
                    break;

                case "5":

                    try {
                        FileWriter archivoTxt = new FileWriter("fichajes.txt", true);
                        for (Coche c : coches) {
                            archivoTxt.write(c.toString());
                        }
                        archivoTxt.close();

                    } catch (IOException e) {
                        System.out.println("Ha ocurrido un error al escribir el archivo de texto.");
                        e.printStackTrace();
                    }
                    break;

                case "6":

                    FileOutputStream archivoDat;
                    DataOutputStream escritor;

                    archivoDat = new FileOutputStream("coches.dat", false);
                    escritor = new DataOutputStream(archivoDat);

                    for (Coche c : coches) {
                        escritor.writeUTF(c.getId());
                        escritor.writeUTF(c.getMatricula());
                        escritor.writeUTF(c.getMarca());
                        escritor.writeUTF(c.getModelo());
                        escritor.writeUTF(c.getColor());

                    }

                    escritor.close();
                    archivoDat.close();
                    break;
                }
            

                sc.close(); 

        } while (!opc.equals("6"));
        
        



    }

    private static void listarCoches(ArrayList<Coche> coches) {
        for (Coche c : coches) {
            System.out.println();
            System.out.println(c);
            System.out.println();
        }
    }

    private static void menu() {
        System.out.println("***************MENÚ****************");
        System.out.println("1. Añadir nuevo coche.");
        System.out.println("2. Borrar coche por ID.");
        System.out.println("3. Consultar coche por ID.");
        System.out.println("4. Listado de coches");
        System.out.println("5. Exportar coches a archivo de texto.");
        System.out.println("6. Terminar el programa.");
    }
}
