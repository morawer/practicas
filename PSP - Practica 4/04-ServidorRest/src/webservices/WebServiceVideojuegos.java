package webservices;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import javax.ws.rs.core.Response;

import entidades.Videojuego;
import persistencia.AccesoVideojuego;

@Path("videojuegos")
public class WebServiceVideojuegos {
 
	AccesoVideojuego accesoVideojuego = new AccesoVideojuego();
	
	//http://localhost:8080/04-ServidorRest/rest/videojuegos
	
	//Método GET por el cual nos devuelve un videojuego por compañia o si no ponemos nada nos da la lista de videojuegos.
	//Ejemplo:(GET) http://localhost:8080/04-ServidorRest/rest/videojuegos?company=konami
	@GET
	@Produces({"application/json"})
	public List<Videojuego> listarVideojuegos(@QueryParam("company") String company) {
		System.out.println("Buscando videojuego por compañia " + company);
		if(company==null) {
			return accesoVideojuego.list();
		}else {
			return accesoVideojuego.getByCompany(company);
		}
		
			
	}
	//Método GET por el cual obtenemos un videojuego por ID.
	//Ejemplo: (GET) http://localhost:8080/04-ServidorRest/rest/videojuegos/1
	@GET
	@Path("/{id}")
	@Produces({"application/json"})
	
	public Videojuego getVideojuego(@PathParam("id") int id) {
		System.out.println("Buscando videojuego con id: " + id);
		Videojuego v = accesoVideojuego.get(id);
		return v;	
	}

	//Método POST por el cual damos de alta un videojuego.
	@POST	
	@Consumes({"application/json"})
	@Produces({"application/json","application/xml"})
	public Response altaVideojuego(Videojuego v) {
		System.out.println("altaVideojuego: objeto videojuego: " + v);
		accesoVideojuego.add(v);
		
		return Response.status(Response.Status.CREATED).entity(v).build();
	}
	//Método DELETE por el cual borramos un videojuego por ID.
	//Ejemplo:(DELETE) http://localhost:8080/04-ServidorRest/rest/videojuegos/1 
	@DELETE
	@Path("/{id}")
	@Produces({"application/json"})
	public Videojuego borrarVideojuego(@PathParam("id") int id) {
		System.out.println("ID a borrar: " + id);
		Videojuego v = accesoVideojuego.delete(id);
		return v;
	}
	//Método PUT por el cual modificamos un videojuego
	@PUT
	@Path("/{id}")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	
	public Videojuego modiVideojuego(@PathParam("id") int id, Videojuego v) {
		System.out.println("ID a modificar: " + id);
		System.out.println("Datos a modificar: " + v);
		v.setId(id);
		v = accesoVideojuego.update(v);
		return v;	
	}
}
