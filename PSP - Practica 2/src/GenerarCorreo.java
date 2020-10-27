import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GenerarCorreo {

	public Correo generarCorreo() {
		Correo correo = new Correo(generarDestinatario(), generarRemitente(), generarAsunto(), generarCuerpo());
		return correo;
	}

	/*
	 * public int generarId() { numeroId++; return numeroId; }
	 */

	public String generarDestinatario() {
		List<String> listaDestinatario = new ArrayList<String>();
		listaDestinatario.add("pikachu@gmail.com");
		listaDestinatario.add("charmander@gmail.com");
		listaDestinatario.add("goku@gmail.com");
		listaDestinatario.add("vegetta@gmail.com");
		listaDestinatario.add("chicho@gmail.com");
		listaDestinatario.add("oliver@gmail.com");
		listaDestinatario.add("benji@gmail.com");
		listaDestinatario.add("gijoe@gmail.com");
		listaDestinatario.add("luckyluck@gmail.com");
		listaDestinatario.add("hnosdalton@gmail.com");

		int numero = ThreadLocalRandom.current().nextInt(0, 9);

		return listaDestinatario.get(numero);
	}

	public String generarRemitente() {
		List<String> listaRemitente = new ArrayList<String>();
		listaRemitente.add("papuchi@hotmail.com");
		listaRemitente.add("pepelu@hotmail.com");
		listaRemitente.add("chiquito@eljefe.com");
		listaRemitente.add("pacoporras@gmail.es");
		listaRemitente.add("tamara@gmail.es");
		listaRemitente.add("lolialvarez@gmail.es");
		listaRemitente.add("arlequin@aol.es");
		listaRemitente.add("paxpax@terra.es");
		listaRemitente.add("tonigenil@yahoo.es");
		listaRemitente.add("elrisitas@hotmail.com");

		int numero = ThreadLocalRandom.current().nextInt(0, 9);

		return listaRemitente.get(numero);
	}

	public String generarAsunto() {

		List<String> listaAsunto = new ArrayList<String>();
		listaAsunto.add("asdwqesdads");
		listaAsunto.add("safdsgffdgd");
		listaAsunto.add("Vivamus.");
		listaAsunto.add("Nullam mollis.");
		listaAsunto.add("Nulla egestas");
		listaAsunto.add("In ultricies");
		listaAsunto.add("Ut et tortor");
		listaAsunto.add("Proin congue");
		listaAsunto.add("Pellentesque");
		listaAsunto.add("Donec auctor");

		int numero = ThreadLocalRandom.current().nextInt(0, 9);

		return listaAsunto.get(numero);
	}

	public String generarCuerpo() {

		List<String> listaAsunto = new ArrayList<String>();
		listaAsunto.add("Morbi venenatis");
		listaAsunto.add("Vivamus lectus");
		listaAsunto.add("Cras sed arcu");
		listaAsunto.add("Suspendisse");
		listaAsunto.add("Nunc sit amet");
		listaAsunto.add("Class aptent");
		listaAsunto.add("Nulla nisi massa");
		listaAsunto.add("Nullam sed");
		listaAsunto.add("Nullam risus");
		listaAsunto.add("Pellentesque");

		int numero = ThreadLocalRandom.current().nextInt(0, 9);

		return listaAsunto.get(numero);
	}

	public GenerarCorreo() {
	}

}
