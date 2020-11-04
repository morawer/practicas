
public class Consumidor extends Thread {

    public String nombre;
    public Cola cola;

    public Consumidor(String nombre, Cola cola) {
        super();
        this.nombre = nombre;
        this.cola = cola;
    }

    // Cada consumidor consumira 15 correos cada uno. Si el contador de correos
    // llega a 30 y la cola esta vacia, hace break y rompe el for, esto lo hago
    // porque como hay correos que se deshechan, a veces no hay 15 correos para cada
    // consumidor y necesito romper el for de consumir correos para que no se quede
    // el programa sin terminar.
    public void run() {
        for (int i = 1; i <= 15; i++) {
            Correo correo = cola.getCorreo();
            System.out.println(nombre + " consume: " + correo);
            if (cola.contador == 30 && cola.cola.isEmpty()) {
                break;
            }
        }
        System.out.println("***El consumidor "  +Thread.currentThread() + " ha terminado.***");
    }
}