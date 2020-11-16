package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class HiloEscuchador implements Runnable {
	// Clase Hilo la cual, albergara en nombre y numero de hilo.
	// Atributos de la clase.
	private Thread hilo;
	private static int numCliente = 0;
	private Socket enchufeCliente;

	// constructor de la clase HiloEscuchador.
	public HiloEscuchador(Socket cliente) {

		numCliente++;
		hilo = new Thread(this, "Cliente_" + numCliente);
		this.enchufeCliente = cliente;
		hilo.start();
	}

	// Metodo del menu().
	private String menu() {

		return "Por favor elija una opcion \n \n" + "1. Consultar libro por ISBN \n"
				+ "2. Consultar libro por titulo \n" + "3. Consultar libro por autor \n" + "4. Añadir libro \n"
				+ "5. Salir de la aplicacion \n";
	}

	@Override
	public void run() {
		// Creamos un ArrayList para albergar los libros creados.
		ArrayList<Libros> listaLibros = new ArrayList<Libros>();
		listaLibros.add(new Libros("1", "La mentira", "Fede", "10.50"));
		listaLibros.add(new Libros("2", "La Verdad", "Juan", "15.40"));
		listaLibros.add(new Libros("3", "El amor", "Jose", "Pepe", "19.99"));
		listaLibros.add(new Libros("4", "El odio", "Adolfo", "20.50"));
		listaLibros.add(new Libros("5", "La confianza", "Julia", "10.80"));

		System.out.println("Estableciendo comunicación con " + hilo.getName());
		DataOutputStream salida = null;
		DataInputStream entrada = null;

		try {
			// Creamos el tipo de conexcion con cliente.
			salida = new DataOutputStream(enchufeCliente.getOutputStream());
			entrada = new DataInputStream(enchufeCliente.getInputStream());

			boolean continuar = true;

			while (continuar) {
				// Variables.
				String opcion = "";
				String isbn = "";
				String titulo = "";
				String autor = "";
				String dosAutores = "";
				String nuevoIsbn = "";
				String nuevoTitulo = "";
				String nuevoAutor = "";
				String nuevoAutor2 = "";
				String nuevoPrecio = "";

				// Se crea el funcionamiento para moverte por el menu pulsando numeros.
				opcion = entrada.readUTF();
				if (opcion.equalsIgnoreCase("1") || opcion.equalsIgnoreCase("2") || opcion.equalsIgnoreCase("3")
						|| opcion.equalsIgnoreCase("4") || opcion.equalsIgnoreCase("5")) {

					if (opcion.equalsIgnoreCase("5")) {

						salida.writeUTF("Hasta pronto, gracias por establecer conexión");
						System.out.println(hilo.getName() + " ha cerrado la comunicación");

						continuar = false;
						// Para buscar un libro por ISBN recorremos un "for" haciendo un "equals" del
						// número e imprimiendo el libro por consola.
					} else if (opcion.equalsIgnoreCase("1")) {
						salida.writeUTF("Por favor selecciona un ISBN: (Escriba 'Volver' para ir al menu) \n");
						System.out.println("El " + hilo.getName() + " quiere consultar libro por ISBN ");
						do {
							isbn = entrada.readUTF();
							boolean sinLibro = true;
							for (Libros libro : listaLibros) {
								if (isbn.equalsIgnoreCase(libro.getIsbn())) {
									salida.writeUTF(libro.toString());
									sinLibro = false;
								}
							}
							if ((sinLibro) && (!isbn.equalsIgnoreCase("volver"))) {
								salida.writeUTF("Libro no encontrado");
							}

						} while (!isbn.equalsIgnoreCase("volver"));

						salida.writeUTF(menu());

						// Para buscar un libro por titulo recorremos un "for" haciendo un "equals" del
						// titulo e imprimiendo el libro por consola.
					} else if (opcion.trim().equalsIgnoreCase("2")) {
						salida.writeUTF(
								"Por favor escriba el nombre del titulo: (Escriba 'Volver' para ir al menu) \n");
						System.out.println("El " + hilo.getName() + " quiere consultar libro por titulo ");

						do {

							titulo = entrada.readUTF();
							boolean sinLibro = true;

							for (Libros libro : listaLibros) {

								if (titulo.trim().equalsIgnoreCase(libro.getTitulo())) {
									salida.writeUTF(libro.toString());
									sinLibro = false;
								}
							}
							if ((sinLibro) && (!titulo.equalsIgnoreCase("volver"))) {
								salida.writeUTF("Libro no encontrado");
							}

						} while (!titulo.equalsIgnoreCase("volver"));

						salida.writeUTF(menu());

						// Para buscar un libro por autor recorremos un "for" haciendo un "equals" del
						// autor e imprimiendo el libro por consola.
					} else if (opcion.equalsIgnoreCase("3")) {
						salida.writeUTF("Por favor escriba el nombre del autor: (Escriba 'Volver' para ir al menu) \n");
						System.out.println("El " + hilo.getName() + " quiere consultar libro por autor ");

						do {

							autor = entrada.readUTF();
							boolean sinLibro = true;

							for (Libros libro : listaLibros) {
								if (autor.equalsIgnoreCase(libro.getAutor())
										|| autor.equalsIgnoreCase(libro.getAutor2())) {
									salida.writeUTF(libro.toString());
									sinLibro = false;
								}
							}
							if ((sinLibro) && (!autor.equalsIgnoreCase("volver"))) {
								salida.writeUTF("Libro no encontrado");
							}

						} while (!autor.equalsIgnoreCase("volver"));

						salida.writeUTF(menu());
						
						// Para añadir un libro primero damos a elegir al cliente si quiere añadir un
						// libro con dos o un autor haciendo un "if". despues se recojen los datos y se
						// introducen al arrayList por medio de un constructor Libro.
					} else if (opcion.equalsIgnoreCase("4")) {
						do {
							salida.writeUTF(
									"¿Desea añadir un libro de dos autores? (Escriba 'Volver' para ir al menu)");
							dosAutores = entrada.readUTF();
						} while (!dosAutores.equalsIgnoreCase("si") && !dosAutores.equalsIgnoreCase("no")
								&& !dosAutores.equalsIgnoreCase("volver"));

						if (dosAutores.equalsIgnoreCase("si") && !dosAutores.equalsIgnoreCase("volver")) {
							System.out.println("El " + hilo.getName() + " quiere añadir un libro con dos autores.");

							salida.writeUTF("Escriba un numero ISBN: ");
							nuevoIsbn = entrada.readUTF();

							salida.writeUTF("Escriba el titulo del libro: ");
							nuevoTitulo = entrada.readUTF();

							salida.writeUTF("Escriba el nombre del primer autor: ");
							nuevoAutor = entrada.readUTF();

							salida.writeUTF("Escriba el nombre del segundo autor: ");
							nuevoAutor2 = entrada.readUTF();

							salida.writeUTF("Escriba el precio del libro: ");
							nuevoPrecio = entrada.readUTF();

							listaLibros.add(new Libros(nuevoIsbn, nuevoTitulo, nuevoAutor, nuevoAutor2, nuevoPrecio));

							salida.writeUTF("Libro añadido correctamente. \n" + menu());
							System.out.println("El " + hilo.getName() + " ha añadido un nuevo libro con dos autores.");

						} else if (dosAutores.equalsIgnoreCase("no") && !dosAutores.equalsIgnoreCase("volver")) {

							System.out.println("El " + hilo.getName() + " quiere añadir un libro.");

							salida.writeUTF("Escriba un numero ISBN: ");
							nuevoIsbn = entrada.readUTF();

							salida.writeUTF("Escriba el titulo del libro: ");
							nuevoTitulo = entrada.readUTF();

							salida.writeUTF("Escriba el nombre del primer autor: ");
							nuevoAutor = entrada.readUTF();

							salida.writeUTF("Escriba el precio del libro: ");
							nuevoPrecio = entrada.readUTF();

							listaLibros.add(new Libros(nuevoIsbn, nuevoTitulo, nuevoAutor, nuevoPrecio));

							salida.writeUTF("\n Libro añadido correctamente. \n" + menu());
							System.out.println("El " + hilo.getName() + " ha añadido un nuevo libro.");
						}
					}
				} else {
					salida.writeUTF("Por favor escriba una opcion correcta.");
				}
			}
		} catch (IOException e) {
			System.err.println("run -> " + e.getMessage());
		} finally {

			try {
				if (salida != null && entrada != null) {
					salida.close();
					entrada.close();
					enchufeCliente.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}