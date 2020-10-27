public class Consumidor extends Thread {

    public String nombre;
    public Cola cola;

    public Consumidor(String nombre, Cola cola) {
        super();
        this.nombre = nombre;
        this.cola = cola;
    }

    public void run() {
        for (int i = 1; i <= 15; i++) {
            Correo correo = cola.getCorreo();
            System.out.println(nombre + " consume: " + correo);
        }
    }
}