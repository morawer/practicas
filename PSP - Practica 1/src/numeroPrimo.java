import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Se crea una clase llamada numeroPrimo y sus atributos.

public class numeroPrimo implements Runnable {

    // Atributo "numero" alberga el numero del q averiguaremos si es un numero primo
    // o no.
    // Atributo "guardar" alberga la contestacion del usuario de guardar los
    // resultados en un fichero .txt
    // Atributo "tiempo" alberga el tiempo de duracion del proceso de inicio a fin
    // del programa.
    // Atributo "date" recojemos la hora del momento de creacion del objeto.
    // Atributo "fecha" alberga ya la fecha del momento de la creacion del objeto ya
    // formateada.

    private int numero;
    private String guardar;
    private double tiempo;
    private LocalDateTime date = LocalDateTime.now();
    DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    private String fecha = date.format(formatoFecha);

    // Creamos un contructor para el objeto de la clase numeroPrimo
    // Para crear el objeto necesitaremos un numero y la contestacion
    // a guardar el resultado en un fichero. Ademas, tambien alberga el momento en
    // el que el objeto es creado.

    public numeroPrimo(int numero, String guardar) {
        this.setNumero(numero);
        this.setGuardar(guardar);
        this.date = LocalDateTime.now();
    }
    // Getter y Setter de los atributos.

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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    // Metodo run, el cual sera ejecutado por el metodo Start de la clase Thread en
    // el Main.

    @Override
    public void run() {

        // Creamos el algoritmo para obtener si un numero es primo o no.
        // Ademas con System.currentTimeMillis() recojemos el tiempo en el que se inicia
        // el proceso.

        double inicio = System.currentTimeMillis();
        double fin = 0;
        boolean primo = true;

        for (int i = 2; i < numero; i++) {

            // Con Thread.sleep() hacemos una parada de 1 milisegundo a cada iteracion del
            // for.
            // Asi provocaremos algo mas de tiempo en el proceso para poder contabilizarlo
            // dentro del atributo tiempo.
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

        // Con este System.currentTimeMillis() recojemos el tiempo en el que se termina
        // el proceso.
        // Hacemos la resta del tiempo final y el inicio y lo dicidimos entre 1000 para
        // hallar
        // el tiempo del proceso en segundos.

        fin = System.currentTimeMillis();
        double tiempo = ((fin - inicio) / 1000);

        // Introducimos el tiempo en el atributo Tiempo.
        setTiempo(tiempo);

        // LLamada al metodo el cual imprime en pantalla los resultados de hilo, tiempo,
        // primo si, primo no y fecha.
        System.out.println(ifPrimo(primo));

        // con este if se compara la respuesta del resultado de guardar fichero. si es
        // positiva se guarda
        // creando un fichero .txt con la clase FileWriter, ademas el fichero sera
        // guardado segun el nombre del hilo.
        // Con el argumento "true" la calse revisa si el archivo existe, sino existe
        // crea uno nuevo, si existe añade los datos.

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

    // Metodo con el cual a partir del resultado obtenido imprime si es o no primo.
    // Tuve que crear este metodo porque sino no conseguia escribir los datos con
    // archivo.write()
    // ya que me pedia que no fuera un void asi que hice que me retornara un String.
    private String ifPrimo(boolean primo) {

        if (primo) {
            return "HILO: " + Thread.currentThread().getName() + " || TIEMPO: " + getTiempo() + " seg. \n"
                    + "El numero " + getNumero() + " es primo. || FECHA: " + getFecha() + "\n"
                    + "*************************************************************\n";
        } else {
            return "HILO: " + Thread.currentThread().getName() + " || TIEMPO: " + getTiempo() + " seg. \n"
                    + "El numero " + getNumero() + " no es primo. || FECHA: " + getFecha() + "\n"
                    + "*************************************************************\n";
        }
    }
}