package server;

public class Libros {

	private String ISBN;
	private String titulo;
	private String autor;
	private float precio;
	
	public Libros(String ISBN, String titulo, String autor, float precio) {
		this.ISBN= ISBN;
		this.titulo=titulo;
		this.autor=autor;
		this.precio=precio;
	}
	public Libros(String ISBN, String titulo, String autor, String autor1, float precio) {
		this.ISBN= ISBN;
		this.titulo=titulo;
		this.autor=autor;
		this.autor=autor1;
		this.precio=precio;
	}
	

	public Libros() {
		super();
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



	public float getPrecio() {
		return precio;
	}



	public void setPrecio(float precio) {
		this.precio = precio;
	}



	public String mostrarMenu() {
	   	
		System.out.println("Por favor elija una opci�n \n" );		
		System.out.println("1. Consultar libro por ISBN");
		System.out.println("2. Consultar libro por t�tulo");
		System.out.println("3. Salir de la aplicaci�n");
		
		return mostrarMenu();
		
		
		
		
		
	}



	@Override
	public String toString() {
		return "Libros [ISBN=" + ISBN + ", titulo=" + titulo + ", autor=" + autor + ", precio=" + precio + "]";
	}
	
	
}
