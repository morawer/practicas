public class Main {
	public static void main(String[] args) {
		Cola cola = new Cola();

		// Se crean los objetos productor y consumidor.
		Productor p1 = new Productor("Producto 1", cola);
		Productor p2 = new Productor("Producto 2", cola);
		Productor p3 = new Productor("Producto 3", cola);

		Consumidor c1 = new Consumidor("Consumidor 1", cola);
		Consumidor c2 = new Consumidor("Consumidor 2", cola);

		// creo una prioridad a cada hilo de producion, a veces me ocurria que al
		// ejecutar el programa dos productores me creaban un correo con el mismo Id. De
		// este modo ya no entran de golpe y lo hacen de manera escalonada.
		p1.setPriority(10);
		p1.start();
		p2.setPriority(5);
		p2.start();
		p3.setPriority(1);
		p3.start();

		c1.start();
		c2.start();

	}
}