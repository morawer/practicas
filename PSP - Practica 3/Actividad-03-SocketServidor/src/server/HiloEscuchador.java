package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import java.util.ArrayList;

public class HiloEscuchador implements Runnable {

	private Thread hilo;
	private static int numCliente = 0;
	private Socket enchufeCliente;

	public HiloEscuchador(Socket cliente) {

		numCliente++;
		hilo = new Thread(this, "Cliente_" + numCliente);
		this.enchufeCliente = cliente;
		hilo.start();
	}

	@Override
	public void run() {

		ArrayList<Libros> listaLibros = new ArrayList<Libros>();
		listaLibros.add(new Libros("1", "Mentira", "Federico", (float) 10.50));
		listaLibros.add(new Libros("2", "Verdad", "Pepe", (float) 15.40));
		listaLibros.add(new Libros("3", "Amor", "Pepe", "Jose", (float) 19.99));
		listaLibros.add(new Libros("4", "Odio", "Adolfo", (float) 20.50));
		listaLibros.add(new Libros("5", "Confianza", "Julia", (float) 10.80));

		System.out.println("Estableciendo comunicación con " + hilo.getName());
		PrintStream salida = null;
		InputStreamReader entrada = null;
		BufferedReader entradaBuffer = null;

		try {

			salida = new PrintStream(enchufeCliente.getOutputStream());
			entrada = new InputStreamReader(enchufeCliente.getInputStream());
			entradaBuffer = new BufferedReader(entrada);

			String opcion = "";
			String isbn = "";
			String titulo = "";
			String autor = "";

			boolean continuar = true;

			while (continuar) {
				opcion = entradaBuffer.readLine();
				if (opcion.trim().equalsIgnoreCase("4")) {

					salida.println("Hasta pronto, gracias por establecer conexión");
					System.out.println(hilo.getName() + " ha cerrado la comunicación");
					continuar = false;
				} else if (opcion.trim().equalsIgnoreCase("1")) {

					salida.println("Por favor selecciona un ISBN del 1 al 5(escriba volver para ir al menu)");
					System.out.println("El cliente quiere consultar libro por ISBN ");

					do {
						isbn = entradaBuffer.readLine();
						boolean sinLibro = true;
						for (Libros libro : listaLibros) {
							if (libro.getISBN().equals(isbn)) {
								salida.println(libro.toString());
								sinLibro = false;
							}
						}

						if ((sinLibro) && (!isbn.equalsIgnoreCase("volver"))) {
							salida.println("Libro no encontrado");
						}

					} while (!isbn.equalsIgnoreCase("volver"));

					if (isbn.equals("volver")) {
						salida.println();
					}

				} else if (opcion.trim().equalsIgnoreCase("2")) {

					salida.println("Por favor escriba el nombre del titulo(escriba volver para ir al menu)");
					System.out.println("El cliente quiere consultar libro por titulo");

					do {

						boolean sinTitulo = true;
						titulo = entradaBuffer.readLine();
						for (Libros libro : listaLibros) {
							if (libro.getTitulo().trim().equalsIgnoreCase(titulo)) {
								salida.println(libro.toString());
								sinTitulo = false;
							}
						}
						if ((sinTitulo) && (!titulo.equalsIgnoreCase("volver"))) {
							salida.println("Libro no encontrado");
						}

					} while (!titulo.equals("volver"));

					if (titulo.equals("volver")) {
						salida.println();
					}

				}

				else if (opcion.trim().equalsIgnoreCase("3")) {

					salida.println("Por favor escriba el nombre del autor(escriba volver para ir al menu)");
					System.out.println("El cliente quiere consultar libro por autor");

					do {

						boolean sinAutor = true;
						autor = entradaBuffer.readLine();
						for (Libros libro : listaLibros) {
							if (libro.getAutor().trim().equalsIgnoreCase(autor)){
								salida.println("LIBRO: " + libro.toString());
								sinAutor = false;
							}

						}
						if ((sinAutor) && (!autor.equalsIgnoreCase("volver"))) {
							salida.println("Libro no encontrado");
						}

					} while (!autor.equals("volver"));

					if (autor.equals("volver")) {
						salida.println();
					}

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
