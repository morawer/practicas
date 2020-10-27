import java.util.LinkedList;
import java.util.Queue;

public class Cola {

    public static final int COLA_MAXIMO = 5;

    private Queue<Correo> cola = new LinkedList<>();

    synchronized void addCorreo(Correo correo) {

        if (cola.size() < COLA_MAXIMO) {
            if (correo.getDestinatario().equals("pikachu@gmail.com")) {
                System.out.println("Se deshecha email con ID: " + correo.getId() + " con destino " + correo.getDestinatario());
            } else {
                cola.offer(correo);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

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
        Correo s = null;
        while (cola.size() == 0) {
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
