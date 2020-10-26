import java.util.LinkedList;
import java.util.Queue;

public class Cola {

    public static final int COLA_MAXIMO = 5;

    private Queue <Correo> cola = new LinkedList<>();

    private synchronized void addMensaje(Correo correo) {

        while (cola.size() == COLA_MAXIMO){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            wait();
        }
        cola.offer(correo);
        notify();
    } 
}
