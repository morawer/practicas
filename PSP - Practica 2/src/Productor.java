public class Productor extends Thread {

    public String nombre;
	public Cola cola;
	public Productor(String nombre, Cola cola){
		super();
		this.nombre = nombre;
		this.cola = cola;
	}
	//For para que cada productor cree 10 correos cada uno.
	public void run(){
		GenerarCorreo gc = new GenerarCorreo();
		for (int i = 1; i <= 10; i++) {
			Correo correo = gc.generarCorreo();
			System.out.println(nombre + " produce: " + correo.getId());
			cola.addCorreo(correo);
		}
		System.out.println("+++El productor " + Thread.currentThread() + " ha terminado.+++"); 
	}
    
}
