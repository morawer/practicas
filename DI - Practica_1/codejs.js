//Creación de variables.
var nombreItem;
var precioItem;
var unidadesItem;
var errorNombre;
var totalNombre;
var precioSuma = 0;
var expPrecio = /\d+(,\d+)?/;
listaItem = [];

function inicializar() {
	precioItem = document.formulario.precio;
	nombreItem = document.formulario.nombre;
	unidadesItem = document.formulario.unidades;
	errorNombre = document.getElementById("errorNombre");
	errorPrecio = document.getElementById("errorPrecio");
	artTotal = document.formulario.artCarro;
	addCarro = document.formulario.addCarro;
	precioTotal = document.formulario.precioCarro;
	tipoPago = document.formulario.tipoPago;
	tarjeta.style.display = "none";
	efectivo.style.display = "none";
	checkBox = document.formulario.condiciones;
	restablecer = document.formulario.restablecer;
	imprimir = document.formulario.imprimir;
}

//Funcion para imprimir con un "alert" la lista de productos y precio total
//o un "alert" de advertencia sino se ha seleccionado el tipo de pago.
function print() {
	if (tipoPago.value == "seleccion") {
		alert("Por favor, seleccione un tipo de pago.");
	} else {
		alert(
			"-Los productos añadidos al carro son: " +
				artTotal.value +
				".\n" +
				"-El precio total es: " +
				precioTotal.value +
				".\n" +
				"-La forma de pago es: " +
				tipoPago.value +
				"."
		);
	}
}
//Funcion para habilitar el boton "Imprimir" si es marcado el checkbox
//condiciones de compra.
function condicion() {
	if (checkBox.checked == true) {
		imprimir.disabled = false;
	} else {
		imprimir.disabled = true;
	}
}
//Funcion para mostrar u ocultar las diferentes "div" de tipo de pago
//según la selección.
function seleccionPago() {
	if (tipoPago.value == "seleccion") {
		tarjeta.style.display = "none";
		efectivo.style.display = "none";
	} else if (tipoPago.value == "visa") {
		tarjeta.style.display = "block";
		efectivo.style.display = "none";
	} else if (tipoPago.value == "efectivo") {
		tarjeta.style.display = "none";
		efectivo.style.display = "block";
	}
}
//Funcion para poner en blanco los diferentes "input text" y a 1 el
//"input number" la cual, es activada cuando es añadido un nuevo articulo.
function reset() {
	nombreItem.value = "";
	precioItem.value = "";
	unidadesItem.value = 1;
	errorNombre.innerHTML = "";
	errorPrecio.innerHTML = "";
}

//Funcion activada cuando es clicado el boton "Restablecer"
//pone en blanco los diferentes "input text", a 1 el "input number"
//y vacia el array "listaItem" y la variable precioSuma se iguala a 0.
function resetTotal() {
	nombreItem.value = "";
	precioItem.value = "";
	precioSuma = 0;
	unidadesItem.value = 1;
	errorNombre.innerHTML = "";
	errorPrecio.innerHTML = "";
	listaItem.length = 0;
	artTotal.value = "";
	precioTotal.value = "";
}

//Funcion que recoje en variable elprecio del item y lo
//multiplica por el numero de unidades.
function verPrecios() {
	precioSuma += precioItem.value * unidadesItem.value;
	precioTotal.value = precioSuma + " €";
}

//Funcion que recoje el nombre del los articulos y los
//introduce en el array "listaItem", a su vez imprime
//los articulos a traves de un "for" en y los muestra
//en "artTotal.value".
function verArticulos() {
	listaItem.push(nombreItem.value);

	for (var i = 0; i < listaItem.length; i++) {
		if (i == 0) {
			totalNombre = listaItem[i];
		} else {
			totalNombre += ", " + listaItem[i];
		}
	}
	artTotal.value = totalNombre;
}
//Funcion para la validacion de los datos introducidos.
//Si el usuario no introduce nombre de item aparecerá
//un mensaje de "Falta articulo".
function validacionNombre() {
	if (nombreItem.value == "") {
		errorNombre.innerHTML = "Falta artículo";
		errorNombre.style.color = "red";
		return true;
	}
}

//Funcion para validar que el precio introducido por
//el usuario es correcto. Si no introduce el precio
//aparecera el mensaje "Falta precio" y si introduce en el
//casillero "precioItem.value" letras o caracteres no permitidos
//aparecerá el mensaje "Tipo de daato incorrecto".
function validacionPrecio() {
	if (precioItem.value == "") {
		errorPrecio.innerHTML = "Falta precio.";
		errorPrecio.style.color = "red";
		return true;
	}
	if (!expPrecio.test(precioItem.value)) {
		errorPrecio.innerHTML = "Tipo de dato incorrecto.";
		errorPrecio.style.color = "red";
		return true;
	}
}

//Funcion que recopila los diferentes "AddEvenListener"
function eventos() {
	addCarro.addEventListener("click", addCarrito);
	tipoPago.addEventListener("change", seleccionPago);
	checkBox.addEventListener("change", condicion);
	restablecer.addEventListener("click", resetTotal);
	imprimir.addEventListener("click", print);
}

//Funcion que interrumpe la introduccion de articulos
//en el array y la acumulacion del precio en la
//sumaPrecio sino se cumplen las condiciones de
//validacion de nombre y precio.
function addCarrito() {
	validacionNombre();
	validacionPrecio();

	if (validacionPrecio() && validacionNombre()) {
		nombreItem.focus();
	} else if (validacionNombre()) {
		nombreItem.focus();
		errorPrecio.innerHTML = "";
	} else if (validacionPrecio()) {
		precioItem.focus();
		errorNombre.innerHTML = "";
	} else {
		verArticulos();
		verPrecios();
		reset();
	}
}

window.onload = function () {
	inicializar();
	eventos();
};
