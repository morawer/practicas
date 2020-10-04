import java.io.FileWriter;
import java.io.IOException;

public class numeroPrimo implements Runnable {

    private int numero;
    private String guardar;
    private double tiempo;

    public numeroPrimo(int numero, String guardar) {
        this.setNumero(numero);
        this.setGuardar(guardar);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getGuardar() {
        return guardar;
    }

    public void setGuardar(String guardar) {
        this.guardar = guardar;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public void run() {

        double inicio = System.currentTimeMillis();
        double fin = 0;
        boolean primo = true;

        for (int i = 2; i < numero; i++) {

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (numero % i == 0) {
                primo = false;
                break;
            }
        }

        fin = System.currentTimeMillis();
        double tiempo = ((fin - inicio) / 1000);

        setTiempo(tiempo);

        System.out.println(ifPrimo(primo));

        if (getGuardar().equalsIgnoreCase("si")) {

            try {
                FileWriter archivo = new FileWriter(Thread.currentThread().getName() + ".txt", true);
                archivo.write(ifPrimo(primo));
                archivo.close();

            } catch (IOException e) {
                System.out.println("Ha ocurrido un error.");
                e.printStackTrace();
            }
        }
    }

    private String ifPrimo(boolean primo) {

        if (primo) {
            return "HILO: " + Thread.currentThread().getName() + " || TIEMPO: " + getTiempo() + " seg."
            + " || El numero " + getNumero() + " es primo.\n";
        } else {
            return "HILO: " + Thread.currentThread().getName() + " || TIEMPO: " + getTiempo() + " seg."
            + " || El numero " + getNumero() + " no es primo.\n";
        }
    }
}