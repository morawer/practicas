import java.util.LinkedList;
import java.util.Queue;

public class Cola {

    public static final int COLA_MAXIMO = 5; // Constante que marque el maximo de la cola.
    public Queue<Correo> cola = new LinkedList<>(); // Array FIFO donde se guardaran los correos.
    public int contador = 0; // Variable que albergará el numero de correos producidos.

    synchronized void addCorreo(Correo correo) {
        // if que permite que la produccion de correos siga si el tamaño de la cola es
        // menor que 5.
        // Ademas si el correo producido es para pikachu se desechará, sino se
        // introducidra en el ArrayList.
        if (cola.size() < COLA_MAXIMO) {
            if (correo.getDestinatario().equals("pikachu@gmail.com")) {
                System.out.println(
                        "Se deshecha email con ID: " + correo.getId() + " con destino " + correo.getDestinatario());
                contador++;

            } else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cola.offer(correo);
                contador++;
            }
        }
        // Si la cola llega a 5 de tamaño el productor debe esperar a que se reduzca.
        while (cola.size() == COLA_MAXIMO) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
    }

    public synchronized Correo getCorreo() {
        // El consumidor cosumira correos siempre que la cola no este vacia y el
        // contador se menor de 30 correos.
        Correo s = null;
        while (cola.isEmpty() && contador < 30) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        s = cola.poll();
        notify();
        return s;
    }
}
