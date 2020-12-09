package persistencia;

import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import entidad.Videojuego;

public class AccesoRest {
	
	private static final String IP = "http://localhost:8080/04-ServidorRest/rest/videojuegos";
	
	public String leerHTML() throws IOException{
		/*
		 * Aquí, estamos solicitando el servicio a través de una URL y 
		 * un objeto HttpURLConnection. La petición se envía a través 
		 * del método GET.
		 */
		URL objURL = new URL("http://localhost:8080/04-ServidorRest/rest/mensajeParametros/query?nombre=Fifa&company=EASport");
		HttpURLConnection conexion = (HttpURLConnection) objURL.openConnection();
		conexion.setRequestMethod("GET");
		
		//Realizamos la solicitud al servidor
		conexion.connect();
		
		/*
		 * Obtenemos el código HTTP de la petición y lo mostramos en pantalla.
		 * Salvo que ocurra algún error, el código será 200 (OK).
		 */
		int codigoHTTP = conexion.getResponseCode();
		System.out.println("Código: " + codigoHTTP);
		
		/*
		 * El método conexion.getInputStream() nos devuelve el flujo de datos 
		 * que necesitaremos para leer el mensaje del servidor. 
		 * Dicho flujo de datos se lo pasamos a un objeto Scanner, 
		 * que facilitará enormemente la lectura.
		 */
		Scanner lector = new Scanner(conexion.getInputStream());
		String respuesta = "";
		while (lector.hasNextLine()) {
			respuesta += lector.nextLine();
		}
		
		lector.close();
		
		return respuesta;
	}
	
	public List<Videojuego> listarVideojuegosCom(String company) throws Exception {
		List<Videojuego> listaVideojuegos;
		String url = IP + "?company=" + company;
		
		System.out.println("Peticion a: " + url);
		
		URL objURL = new URL(url);
		HttpURLConnection conexion = (HttpURLConnection) objURL.openConnection();
		conexion.setRequestMethod("GET");
		
		//Realizamos la solicitud al servidor
		conexion.connect();
		
		int codigoHTTP = conexion.getResponseCode();
		//Aqui suponemos que todo va a ir bien, pero podemos decidir
		//que hacemos con la respuesta en funcion del codigo de respuesta
		System.out.println("Código: " + codigoHTTP);
				
		Scanner lector = new Scanner (conexion.getInputStream());
		
		//leemos el json que me manda el servidor
		String jsonRespuesta = lector.nextLine();
		
		//convierto el json en una lista de objetos persona
		Gson gson = new Gson();
		listaVideojuegos = gson.fromJson(jsonRespuesta, new TypeToken<List<Videojuego>>(){}.getType());
		
		//muy importante cerrar la conexión
		conexion.disconnect();	
		lector.close();
		
		return listaVideojuegos;
	}
	
	public Videojuego obtenerVideojuego(int id) throws Exception{
		String url = IP + "/" + id;
		
		System.out.println("Peticion a: " + url);
		URL objURL = new URL(url);
		HttpURLConnection conexion = (HttpURLConnection) objURL.openConnection();
		conexion.setRequestMethod("GET");
		
		//Realizamos la solicitud al servidor
		conexion.connect();
		
		int codigoHTTP = conexion.getResponseCode();
		System.out.println("Código: " + codigoHTTP);
		
		Scanner lector = new Scanner (conexion.getInputStream());
		String respuesta = lector.nextLine();
		
		Gson gson = new Gson();
		Videojuego vRespuesta = gson.fromJson(respuesta, Videojuego.class);
		
		conexion.disconnect();
		lector.close();		
		
		return vRespuesta;
	}
	
	
	
	public Videojuego altaVideojuego(Videojuego v) throws Exception{
		System.out.println("Peticion a: " + IP);
		URL objURL = new URL(IP);
		
		HttpURLConnection conexion = (HttpURLConnection) objURL.openConnection();
		conexion.setRequestMethod("POST");
		//ponemos la cabecera Content-Type con valor application/json
		//ya que mi servidor solo "Consume" mensajes json
		conexion.setRequestProperty("Content-Type", "application/json");
		conexion.setDoOutput(true);//OJO! Permitimos mandar contenido en el body
				
		//Parseamos el videojuego a formato json para enviarlo
		Gson gson = new Gson();
		String jsonAEnviar = gson.toJson(v);
		System.out.println("Json a enviar: " + jsonAEnviar);
				
		//Usamos el objeto PrintStream para escribir en el body del HTTP Request
		PrintStream salida = new PrintStream(conexion.getOutputStream());
		salida.println(jsonAEnviar);
		
		//Realizamos la solicitud al servidor
		conexion.connect();
			
		//ahora leemos la respueta
		Scanner lector = new Scanner (conexion.getInputStream());
		
		int codigoHTTP = conexion.getResponseCode();
		System.out.println("Código: " + codigoHTTP);
		
		String jsonRespuesta = lector.nextLine();
		Videojuego vRespuesta = gson.fromJson(jsonRespuesta, Videojuego.class);
		
		lector.close();
		salida.close();
		conexion.disconnect();
	
		return vRespuesta;
	}
	
	public Videojuego modificarVideojuego(Videojuego v, int id) throws Exception{
		String url = IP + "/" + id;
		
		System.out.println("Peticion a: " + url);
		URL objURL = new URL(url);
		
		HttpURLConnection conexion = (HttpURLConnection) objURL.openConnection();
		conexion.setRequestMethod("PUT");
		conexion.setRequestProperty("Content-Type", "application/json");
		conexion.setDoOutput(true);//Permitimos mandar contenido en el body
				
		Gson gson = new Gson();
		String jsonAEnviar = gson.toJson(v);
		System.out.println("Json a enviar: " + jsonAEnviar);
				
		PrintStream salida = new PrintStream(conexion.getOutputStream());
		salida.println(jsonAEnviar);
		
		//Realizamos la solicitud al servidor
		conexion.connect();
				
		Scanner lector = new Scanner (conexion.getInputStream());
		
		int codigoHTTP = conexion.getResponseCode();
		System.out.println("Código: " + codigoHTTP);
		
		String jsonRespuesta = lector.nextLine();

		Videojuego vRespuesta = gson.fromJson(jsonRespuesta, Videojuego.class);
		
		lector.close();
		salida.close();
		conexion.disconnect();
	
		return vRespuesta;
	}
	
	//Esto es un copy/paste del obtenerVideojuego, pero en vez de un "GET" un "DELETE"
	public Videojuego borrarPersonas(int id) throws Exception{
		String url = IP + "/" + id;
		
		System.out.println("Peticion a: " + url);
		URL objURL = new URL(url);
		HttpURLConnection conexion = (HttpURLConnection) objURL.openConnection();
		conexion.setRequestMethod("DELETE");
		
		//Realizamos la solicitud al servidor
		conexion.connect();
		
		int codigoHTTP = conexion.getResponseCode();
		System.out.println("Código: " + codigoHTTP);
		
		Scanner lector = new Scanner (conexion.getInputStream());
		
		String respuesta = lector.nextLine();
		
		Gson gson = new Gson();
		Videojuego vRespuesta = gson.fromJson(respuesta, Videojuego.class);
		
		conexion.disconnect();
		lector.close();		
		
		return vRespuesta;
	}

}
