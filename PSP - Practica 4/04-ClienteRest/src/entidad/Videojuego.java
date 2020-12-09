package entidad;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement	
public class Videojuego implements Serializable {
	
	private int id;
	private String nombre;
	private String company;
	private int nota;
	
	
	
	public Videojuego() {
		super();
	}


	public Videojuego(int id, String nombre, String company, int nota) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.company = company;
		this.nota = nota;
	}


	

	@XmlAttribute
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	


	public int getNota() {
		return nota;
	}


	public void setNota(int nota) {
		this.nota = nota;
	}


	@Override
	public String toString() {
		return "Videojuego [id=" + id + ", nombre=" + nombre + ", company=" + company + ", nota=" + nota + "]";
	}


	


	
	
	
	
	
	



}
