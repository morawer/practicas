import java.util.Scanner;

import dao.DaoCoche;
import entidades.Coche;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int opc = 0;

        do {

            menu();

            System.out.println("Elige una opción: ");
            opc = sc.nextInt();

            DaoCoche daoCoche = new DaoCoche();

            switch (opc) {
                case 1:
                    sc.nextLine();
                    System.out.println("Escribe una matricula: ");
                    String matricula = sc.nextLine();

                    System.out.println("Escribe una marca: ");
                    String marca = sc.nextLine();

                    System.out.println("Escribe un modelo: ");
                    String modelo = sc.nextLine();

                    System.out.println("Escribe un color: ");
                    String color = sc.nextLine();

                    Coche coche = new Coche(matricula, marca, modelo, color);

                    daoCoche.addCoche(coche);

                    break;

                case 2:

                    System.out.println("Escriba un ID:");
                    int idBorrar = sc.nextInt();

                    daoCoche.borrarCoche(idBorrar);

                    break;

                case 3:

                    System.out.println("Escriba un ID:");
                    int idBuscar = sc.nextInt();

                    System.out.println(daoCoche.buscarCoche(idBuscar));

                    break;

                case 4:

                    System.out.println("Escribe el Id del coche que quiere modificar: ");
                    int id2 = sc.nextInt();

                    sc.nextLine();
                    System.out.println("Escribe una matricula: ");
                    String matricula2 = sc.nextLine();

                    System.out.println("Escribe una marca: ");
                    String marca2 = sc.nextLine();

                    System.out.println("Escribe un modelo: ");
                    String modelo2 = sc.nextLine();

                    System.out.println("Escribe un color: ");
                    String color2 = sc.nextLine();

                    daoCoche.modificarCoche(id2, matricula2, marca2, modelo2, color2);

                    break;

                case 5:

                    System.out.println(daoCoche.listarCoche());

                    break;

            }

        } while (opc != 6);
        sc.close();

    }

    private static void menu() {
        System.out.println("***************MENÚ****************");
        System.out.println("1. Añadir nuevo coche.");
        System.out.println("2. Borrar coche por ID.");
        System.out.println("3. Consultar coche por ID.");
        System.out.println("4. Modificar coche");
        System.out.println("5. Listar todos los coches.");
        System.out.println("6. Terminar el programa.");
    }
}
