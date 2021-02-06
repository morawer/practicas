import java.util.Scanner;

import dao.DaoCoche;
import dao.DaoPersona;
import entidades.Coche;
import entidades.Persona;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int opc = 0;
        int opcPersona = 0;

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

                case 6:

                    do {
                        menuPersona();

                        System.out.println("Elige una opción: ");
                        opcPersona = sc.nextInt();

                        DaoPersona daoPersona = new DaoPersona();

                        switch (opcPersona) {
                            case 1:

                                sc.nextLine();
                                System.out.println("Escriba un nombre: ");
                                String nombre = sc.nextLine();

                                System.out.println("Escriba la edad: ");
                                int edad = sc.nextInt();

                                System.out.println("Escriba el peso en kilogramos: ");
                                double peso = sc.nextDouble();

                                Persona persona = new Persona(nombre, edad, peso);

                                daoPersona.addPersona(persona);

                                break;

                            case 2:

                                System.out.println("Escriba un ID: ");
                                int idBorrarPersona = sc.nextInt();

                                daoPersona.borrarPersona(idBorrarPersona);

                                break;

                            case 3:

                                System.out.println("Escriba un ID: ");
                                int idBuscarPersona = sc.nextInt();

                                System.out.println(daoPersona.buscarPersona(idBuscarPersona));

                                break;

                            case 4:

                                System.out.println(daoPersona.listarPersona());

                                break;

                            case 5:

                                System.out.println("Escriba el ID de la persona: ");
                                int idPersonaAsignar = sc.nextInt();

                                System.out.println("Escriba el ID del coche en el que quiere asignar el pasajero: ");
                                int idCocheAsignar = sc.nextInt();

                                daoPersona.addPersonaCoche(idPersonaAsignar, idCocheAsignar);

                                break;

                            case 6:

                                System.out.println("Escriba el Id de la persona: ");
                                int idPersonaBorrar = sc.nextInt();

                                daoPersona.borrarPersonaCoche(idPersonaBorrar);

                                break;

                            case 7:

                                System.out.println("Escriba el ID del coche: ");
                                int idCocheListar = sc.nextInt();

                                System.out.println(daoPersona.listarPersonaCoche(idCocheListar));

                                break;
                        }

                    } while (opcPersona != 8);
            }

        } while (opc != 7);
        sc.close();
    }

    private static void menu() {
        System.out.println("***************MENÚ****************");
        System.out.println("1. Añadir nuevo coche.");
        System.out.println("2. Borrar coche por ID.");
        System.out.println("3. Consultar coche por ID.");
        System.out.println("4. Modificar coche");
        System.out.println("5. Listar todos los coches.");
        System.out.println("6. Entrar en menú Pasajero.");
        System.out.println("7. Terminar el programa.");
    }

    private static void menuPersona() {
        System.out.println("***************MENÚ****************");
        System.out.println("1. Añadir nuevo pasajero.");
        System.out.println("2. Borrar pasajero por ID.");
        System.out.println("3. Consultar pasajero por ID.");
        System.out.println("4. Listar todos los pasajeros. ");
        System.out.println("5. Asignar pasajero a un coche.");
        System.out.println("6. Eliminar pasajero de un coche.");
        System.out.println("7. Listar pasajeros de un coche.");
        System.out.println("8. Atras");
    }
}
