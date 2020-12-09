package persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.tagext.TryCatchFinally;

import entidades.Videojuego;
import javassist.bytecode.stackmap.BasicBlock.Catch;

public class AccesoVideojuego {
	
	
		public static List<Videojuego> listaVideojuego;
		public static int contador;
		
		
		static {
			listaVideojuego = new ArrayList<Videojuego>();
			contador = 0;
			Videojuego v1 = new Videojuego(contador++,"Fifa", "EA", 83);
			Videojuego v2 = new Videojuego(contador++,"Pes", "Konami", 91);
			Videojuego v3 = new Videojuego(contador++,"Lol", "Riot", 99);
			Videojuego v4 = new Videojuego(contador++,"Wow", "Blizzard", 95);
			Videojuego v5 = new Videojuego(contador++,"Cod", "Activision", 92);
			listaVideojuego.add(v1);
			listaVideojuego.add(v2);
			listaVideojuego.add(v3);
			listaVideojuego.add(v4);
			listaVideojuego.add(v5);
		}
		
		//Devuelve un videojuego por ID.
		
		public Videojuego get(int id) {
			
			return listaVideojuego.get(id);
		}
		
		//Este metodo de aquí devueve toda la lista de Videojuegos
		public List<Videojuego> list() {
			return listaVideojuego;
		}
		
		//Este metodo da de alta un videojuego en nuestra lista.
		public void add(Videojuego v) {
			v.setId(contador++);
			listaVideojuego.add(v);
		}
		
		//Borra un videojuego por ID.
		public Videojuego delete(int id) {
			return listaVideojuego.remove(id);
		}
		
		//Modifica un videojuego a partir de un ID
		public Videojuego update(Videojuego v) {
			Videojuego vAux = listaVideojuego.get(v.getId());
			if(vAux != null) {
				vAux.setNombre(v.getNombre());
				vAux.setCompany(v.getCompany());
				vAux.setNota(v.getNota());
			}
			return vAux;
		}
		
		//Buscamos un videojuego por compania.
		public List<Videojuego> getByCompany(String company){
			List<Videojuego> lisVideojuegosAux = new ArrayList<Videojuego>();
			for(Videojuego v : listaVideojuego) {
				if(v.getCompany().equalsIgnoreCase(company)) {
					lisVideojuegosAux.add(v);
				}
			}
			return lisVideojuegosAux;
		}
		
		
		
		
		

}
