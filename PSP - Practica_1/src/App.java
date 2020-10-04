import java.util.Scanner;

public class App {
    
    /** 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        //creamos las preguntas al usuario y las variables donde se almacenaran sun respuestas.

        Scanner sc = new Scanner(System.in);

        System.out.println("¿Quieres guardar los resultados en un fichero .txt? (Si/No)");
        String lector = sc.nextLine();

        System.out.println("Introduce 4 numeros: ");

        //Creamos los objetos, en los cuales meteremos como atributos los datos var y lector.
        int var;
        var = sc.nextInt();
        Thread numThread1 = new Thread(new numeroPrimo(var,lector));

        var = sc.nextInt();
        Thread numThread2 = new Thread(new numeroPrimo(var, lector));

        var = sc.nextInt();
        Thread numThread3 = new Thread(new numeroPrimo(var, lector));

        var = sc.nextInt();
        Thread numThread4 = new Thread(new numeroPrimo(var, lector));

        //Ejecutamos los hilos.

        numThread1.start();
        numThread2.start();
        numThread3.start();
        numThread4.start();

        sc.close();

    }
}