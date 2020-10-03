public class numeroPrimo implements Runnable {

    private int numero;
    private double tiempo;

    public numeroPrimo(int numero) {
        this.setNumero(numero);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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
        boolean prime = true;

        for (int i = 2; i < numero; i++) {

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (numero % i == 0) {
                prime = false;           
                break;
            }
        }

        fin = System.currentTimeMillis();
        double tiempo = ((fin - inicio) / 1000);

        setTiempo(tiempo);

        if (prime) {

            System.out.println("El numero " + getNumero() + " es primo. EL HILO ES: " + Thread.currentThread().getName()
                    + " El tiempo fue de: " + getTiempo());
        } else {
            System.out.println("El numero " + getNumero() + " no es primo. EL HILO ES: " + Thread.currentThread().getName()
                    + " El tiempo fue de: " + getTiempo());
        }

    }

}
