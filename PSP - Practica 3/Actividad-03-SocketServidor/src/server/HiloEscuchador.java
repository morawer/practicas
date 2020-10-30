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
		listaLibros.add(new Libros("1", "Sin ti nada", "Federico", (float) 10.50));
		listaLibros.add(new Libros("2", "Sin ti todo", "Pepe", (float) 15.40));
		listaLibros.add(new Libros("3", "Hola Don Pepito", "Pepe", "Jose", (float) 19.99));
		listaLibros.add(new Libros("4", "La verdad", "Adolfo", (float) 20.50));
		listaLibros.add(new Libros("5", "La mentira", "Julia", (float) 10.80));

		System.out.println("Estableciendo comunicación con " + hilo.getName());
		PrintStream salida = null;
		InputStreamReader entrada = null;
		BufferedReader entradaBuffer = null;

		try {

			salida = new PrintStream(enchufeCliente.getOutputStream());
			entrada = new InputStreamReader(enchufeCliente.getInputStream());
			entradaBuffer = new BufferedReader(entrada);

			String opcion = "";
			String ISBN = "";
			String titulo = "";

			boolean continuar = true;

			while (continuar) {
				opcion = entradaBuffer.readLine();
				if (opcion.trim().equalsIgnoreCase("3")) {

					salida.println("Hasta pronto, gracias por establecer conexión");
					System.out.println(hilo.getName() + " ha cerrado la comunicación");
					continuar = false;
				} else if (opcion.trim().equalsIgnoreCase("1")) {

					salida.println("Por favor selecciona un ISBN del 1 al 5(escriba 'volver' para ir al menu)");
					System.out.println("El cliente quiere consultar libro por ISBN ");

					do {
						ISBN = entradaBuffer.readLine();
						for (Libros libros : listaLibros) {
							if (ISBN.equals(libros.getISBN())) {
								salida.println(libros.toString());
								break;						
							} else {
								salida.println("Libro con ISBN: " + ISBN + ". No encontrado.");
							}
						}
					} while (!ISBN.equals("volver"));

				} else if (opcion.trim().equalsIgnoreCase("2")) {

					salida.println("Por favor escriba el nombre del titulo(escriba volver para ir al menu)");
					System.out.println("El cliente quiere consultar libro por autor");

					do {
						titulo = entradaBuffer.readLine();
						for (Libros libros : listaLibros) {
							if (titulo.equalsIgnoreCase(libros.getTitulo())) {
								salida.println(libros.toString());
							} else {
								salida.println("Libro con el título: " + titulo + ". No encontrado.");
							}
						}
					} while (!titulo.equals("volver"));
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
