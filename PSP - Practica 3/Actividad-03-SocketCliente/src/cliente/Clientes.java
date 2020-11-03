package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Clientes {

	// IP y Puerto al que conectaremos.

	public static final int PUERTO = 2017;
	public static final String IP_SERVER = "localhost";

	public static void main(String[] args) {

		System.out.println("       BIENVENIDO A LA BLIBLIOTECA");
		System.out.println("-------------------------------------------");

		Socket clientes = null;

		InputStreamReader entrada = null;
		PrintStream salida = null;

		InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);

		Scanner sc = new Scanner(System.in);

		try {

			clientes = new Socket();
			clientes.connect(direccionServidor);
			System.out.println("Conexion establecida... a " + IP_SERVER + " por el puerto " + PUERTO + "\n");

			entrada = new InputStreamReader(clientes.getInputStream());
			salida = new PrintStream(clientes.getOutputStream());
			BufferedReader bf = new BufferedReader(entrada);

			System.out.println("Por favor elija una opci�n \n");
			System.out.println("1. Consultar libro por ISBN");
			System.out.println("2. Consultar libro por t�tulo");
			System.out.println("3. Consultar libro por autor");
			System.out.println("4. Salir de la aplicaci�n");

			String num = "";

			while (!num.equals("4")) {

				while (!num.equalsIgnoreCase("fin")) {

					num = sc.next();
					salida.println(num);
					String respuesta = bf.readLine();
					System.out.println(respuesta);

					if (num.equalsIgnoreCase("volver")) {

						System.out.println("Por favor elija una opci�n \n");
						System.out.println("1. Consultar libro por ISBN");
						System.out.println("2. Consultar libro por t�tulo");
						System.out.println("3. Consultar libro por autor");
						System.out.println("4. Salir de la aplicaci�n");
					}

				}

			}

		} catch (UnknownHostException e) {
			System.out.println("No se puede establecer comunicaci�n con el servidor");
			System.out.println(e.getMessage());
		} catch (IOException e) {

		} finally {

			try {
				if (salida != null && entrada != null) {

					salida.close();
					entrada.close();
					clientes.close();

				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		sc.close();
		System.out.println("Se acabo la comunicaci�n");

	}
}