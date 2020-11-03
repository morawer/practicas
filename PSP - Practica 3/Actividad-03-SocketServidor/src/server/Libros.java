package server;

public class Libros {

	private String ISBN;
	private String titulo;
	private String autor;
	private String autor1;
	private float precio;

	public Libros(String iSBN, String titulo, String autor, String autor1, float precio) {
		ISBN = iSBN;
		this.titulo = titulo;
		this.autor = autor;
		this.autor1 = autor1;
		this.precio = precio;
	}

	public Libros(String iSBN, String titulo, String autor, float precio) {
		ISBN = iSBN;
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getAutor1() {
		return autor1;
	}

	public void setAutor1(String autor1) {
		this.autor1 = autor1;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Libros [ISBN=" + ISBN + ", autor=" + autor + ", autor1=" + autor1 + ", precio=" + precio + ", titulo="
				+ titulo + "]";
	}
	
	

	
	
	
	
	

	
	
	



	
	
	
	
}
