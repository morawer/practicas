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

function print() {
    if (tipoPago.value == "seleccion") {
        alert("Por favor, seleccione un tipo de pago.");
    } else {
        alert("-Los productos añadidos al carro son: " + artTotal.value + ".\n" +
            "-El precio total es: " + precioTotal.value + ".\n" +
            "-La forma de pago es: " + tipoPago.value + ".");
    }
}

function condicion() {
    if (checkBox.checked == true) {
        imprimir.disabled = false;
    } else {
        imprimir.disabled = true;
    }
}

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

function reset() {
    nombreItem.value = "";
    precioItem.value = "";
    unidadesItem.value = 1;
    errorNombre.innerHTML = "";
    errorPrecio.innerHTML = "";
}

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

function verPrecios() {
    precioSuma += (precioItem.value * unidadesItem.value);
    precioTotal.value = precioSuma + " €";
}

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

function validacionNombre() {
    if (nombreItem.value == "") {
        errorNombre.innerHTML = "Falta artículo";
        errorNombre.style.color = "red";
        return true;
    }
}

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

function eventos() {
    addCarro.addEventListener("click", addCarrito);
    tipoPago.addEventListener("change", seleccionPago);
    checkBox.addEventListener("change", condicion);
    restablecer.addEventListener("click", resetTotal);
    imprimir.addEventListener("click", print);
}

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
}