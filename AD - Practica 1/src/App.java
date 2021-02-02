import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

                int id = lector.readInt();
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

        Scanner sc = new Scanner(System.in);
        int opc = 0;

        do {

            int opc = 0;
            menu();

            System.out.println("Elige una opción: ");
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    addCoche(coches, sc);
                    break;

                case 2:
                    borrarCoche(coches, sc);
                    break;

                case 3:
                    buscarCoche(coches, sc);
                    break;

                case 4:
                    listarCoches(coches);
                    break;

                case 5:
                    crearTxt(coches);
                    break;

                case 6:
                    crearDat(coches);
                    break;
            }
        } while (opc != 6);
        sc.close();
    }

    private static void crearDat(ArrayList<Coche> coches) throws FileNotFoundException, IOException {
        FileOutputStream archivoDat;
        DataOutputStream escritor;

        archivoDat = new FileOutputStream("coches.dat", false);
        escritor = new DataOutputStream(archivoDat);

        for (Coche c : coches) {
            escritor.writeInt(c.getId());
            escritor.writeUTF(c.getMatricula());
            escritor.writeUTF(c.getMarca());
            escritor.writeUTF(c.getModelo());
            escritor.writeUTF(c.getColor());
        }
        escritor.close();
        archivoDat.close();
    }

    private static void crearTxt(ArrayList<Coche> coches) {
        try {
            FileWriter archivoTxt = new FileWriter("fichajes.txt", false);
            for (Coche c : coches) {
                archivoTxt.write(c.toString());
            }
            archivoTxt.close();

        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al escribir el archivo de texto.");
            e.printStackTrace();
        }
    }

    private static void buscarCoche(ArrayList<Coche> coches, Scanner sc) {
        System.out.print("Introduce un ID: ");
        int idBuscador = sc.nextInt();
        boolean noEncontrado = true;

        for (Coche c : coches) {
            if (c.getId() == idBuscador) {
                System.out.println(c);
                noEncontrado = false;
            }
        }
        if (noEncontrado == true) {
            System.out.println("Coche no encontrado.");
        }
    }

    private static void borrarCoche(ArrayList<Coche> coches, Scanner sc) {
        System.out.print("Introduce un ID: ");
        int idBorrador = sc.nextInt();
        boolean noEncontrado = true;

        for (Coche c : coches) {
            if (c.getId() == idBorrador) {
                System.out.println(
                        "El coche con ID: " + c.getId() + " y matricula: " + c.getMatricula() + " sera borrado.");
                coches.remove(c);
                noEncontrado = false;
                break;
            }
        }
        if (noEncontrado == true) {
            System.out.println("Coche no encontrado.");
        }
    }

    private static void addCoche(ArrayList<Coche> coches, Scanner sc) {
        System.out.println("ID: ");
        int id = sc.nextInt();

        System.out.println("Matricula: ");
        String matricula = sc.next();

        System.out.println("Marca: ");
        String marca = sc.next();

        System.out.println("Modelo: ");
        String modelo = sc.next();

        System.out.println("Color: ");
        String color = sc.next();

        Coche coche = new Coche(id, matricula, marca, modelo, color);

        coches.add(coche);
    }

    private static void listarCoches(ArrayList<Coche> coches) {
        for (Coche c : coches) {
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
