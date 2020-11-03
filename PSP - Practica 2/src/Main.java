public class Main {
        public static void main(String[] args) {
		Cola cola = new Cola();
		
		Productor p1 = new Productor("Producto 1",cola);
		Productor p2 = new Productor("Producto 2",cola);
		Productor p3 = new Productor("Producto 3",cola);
		
		Consumidor c1 = new Consumidor("Consumidor 1",cola);
		Consumidor c2 = new Consumidor("Consumidor 2",cola);
		
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