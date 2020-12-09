package main;

import java.util.List;
import java.util.Scanner;

import entidad.Videojuego;
import persistencia.AccesoRest;

public class Main {

    public static void main(String[] args) throws Exception {

        String opc;

        Scanner sc = new Scanner(System.in);
        menu();
        opc = sc.nextLine();
        
        //Iniciamos un bucle que recorrerá el menu.
        while (!opc.equalsIgnoreCase("4")) {
        	

                if (opc.equalsIgnoreCase("1")) {
                	AccesoRest accesoRest = new AccesoRest();
                	
                	do {
                		try {
                    		//En la opción 1 ponemos un ID de un videojuego y nos muestra la información del videojuego.
                    		System.out.println("Por favor escriba el Id de un videojuego(Escriba volver para ir al menú)");
                    		
                    		Videojuego v = accesoRest.obtenerVideojuego(sc.nextInt());
                    		
                    		System.out.println(v);
    					} catch (Exception e) {
    						
    						System.out.println("Id no encontrado");

    					}
                	}while(!sc.nextLine().equalsIgnoreCase("volver"));
                	menu();
                	opc = sc.nextLine();
                   
                } else if (opc.equalsIgnoreCase("2")) {
                	AccesoRest accesoRest = new AccesoRest();
                	do {
                		try {
                			//Al igual que con el ID pero esta vez poniendo el nombre de la compañia.
                			System.out.println("Escriba el nombre de la compañia(Escriba volver para ir al menu)");
                    		List<Videojuego> listaVideojuegos=accesoRest.listarVideojuegosCom(sc.nextLine());
                    		
                            System.out.println(listaVideojuegos);
                            
						} catch (Exception e) {
							System.out.println("Compañia no encontrada");
						}
                		
                	}while(!sc.nextLine().equalsIgnoreCase("volver"));
                    menu();
                    opc = sc.nextLine();
                } else if (opc.equalsIgnoreCase("3")) {
                	AccesoRest accesoRest = new AccesoRest();
                	
                	//Añadimos un videojuego preguntando al cliente por los datos.
                    Videojuego v = new Videojuego();

                    System.out.println("Escriba la compañia del Videojuego: ");
                    
                    v.setCompany(sc.nextLine());

                    System.out.println("Escriba el nombre del Videojuego: ");
                    
                    v.setNombre(sc.nextLine());

                    System.out.println("Escriba la puntuación del Videojuego: ");
                    
                    v.setNota(sc.nextInt());

                    Videojuego vResultado = accesoRest.altaVideojuego(v);
                    System.out.println("Videojuego dado de alta: " + vResultado);
                    System.out.println("¿Desea salir al menu?");
                    sc.nextLine();
                    if(sc.nextLine().equalsIgnoreCase("si")) {
                    	menu();
                        opc = sc.nextLine();
                    }
                    
                }
               
            
        }
        System.out.println("Programa finalizado");
        sc.close();
    }
    

    private static void menu() {
        System.out.println("Elija una opción:");
        System.out.println("************************************");
        System.out.println("1 - Consultar videojuego por id.");
        System.out.println("2 - Consultar videojuegos por compañía.");
        System.out.println("3 - Alta de videojuego");
        System.out.println("4 - Salir");
    }

    

}
