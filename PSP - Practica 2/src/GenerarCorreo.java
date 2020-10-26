import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GenerarCorreo {

	private int numeroId = 0;

	public Correo generarCorreo() {
		Correo correo = new Correo();
		correo.setId(generarId());
		correo.setDestinatario(generarDestinatario());
		correo.setRemitente(generarRemitente());
		correo.setAsunto(generarAsunto());
		correo.setCuerpo(generarCuerpo());
		return correo;
	}

	public int generarId() {
		numeroId++;
		return numeroId;
	}

	public String generarDestinatario() {
		List<String> listaDestinatario = new ArrayList<String>();
		listaDestinatario.add("pikachu@gmail.com");
		listaDestinatario.add("charmander@gmail.com");
		listaDestinatario.add("goku@gmail.com");
		listaDestinatario.add("vegetta@gmail.com");
		listaDestinatario.add("chichoterremoto@gmail.com");
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
		listaRemitente.add("pacoporras@lacaspa.es");
		listaRemitente.add("tamaralamala@lacaspa.es");
		listaRemitente.add("lolialvarez@lacaspa.es");
		listaRemitente.add("arlequin@lacaspa.es");
		listaRemitente.add("tamaralamadre@lacaspa.es");
		listaRemitente.add("tonigenil@lacaspa.es");
		listaRemitente.add("elrisitas@hotmail.com");

		int numero = ThreadLocalRandom.current().nextInt(0, 9);

		return listaRemitente.get(numero);
	}

	public String generarAsunto() {

		List<String> listaAsunto = new ArrayList<String>();
		listaAsunto.add("Tenemos una reunion a las 11.");
		listaAsunto.add("No olvides comprar pan");
		listaAsunto.add("Vivamus sollicitudin nisl id nisi.");
		listaAsunto.add("Nullam mollis sodales arcu, nec.");
		listaAsunto.add("Nulla egestas malesuada eleifend. Pellentesque.");
		listaAsunto.add("In ultricies iaculis lectus sit");
		listaAsunto.add("Ut et tortor pretium, auctor.");
		listaAsunto.add("Proin congue justo diam, eget");
		listaAsunto.add("Pellentesque pharetra massa elit, vitae.");
		listaAsunto.add("Donec auctor mi et ultricies.");

		int numero = ThreadLocalRandom.current().nextInt(0, 9);

		return listaAsunto.get(numero);
	}

	public String generarCuerpo() {

		List<String> listaAsunto = new ArrayList<String>();
		listaAsunto.add("Morbi venenatis condimentum ipsum, ac venenatis risus posuere nec. Nulla");
		listaAsunto.add("Vivamus lectus magna, consectetur vel pharetra sed, hendrerit quis lorem.");
		listaAsunto.add("Cras sed arcu venenatis, vulputate ex eget, consectetur elit. Donec.");
		listaAsunto.add("Suspendisse in nisi ut mauris lobortis vestibulum non aliquet nibh.");
		listaAsunto.add("Nunc sit amet orci quam. Vivamus quis efficitur urna, nec.");
		listaAsunto.add("Class aptent taciti sociosqu ad litora torquent per conubia nostra");
		listaAsunto.add("Nulla nisi massa, ornare id sem eget, aliquam feugiat sem.");
		listaAsunto.add("Nullam sed dolor neque. Donec ex sem, sagittis non leo.");
		listaAsunto.add("Nullam risus elit, dignissim sed molestie at, vestibulum at tellus.");
		listaAsunto.add("Pellentesque interdum erat cursus pharetra aliquam. Donec et maximus neque.");

		int numero = ThreadLocalRandom.current().nextInt(0, 9);

		return listaAsunto.get(numero);
	}

}
