var nombreItem;
var precioItem;
var unidadesItem;
var errorNombre;
var totalNombre;
var precioSuma = 0;
listaItem = [];

function inicializar() {
    precioItem = document.formulario.precio;
    nombreItem = document.formulario.nombre;
    unidadesItem = document.formulario.unidades;
    errorNombre = document.getElementById("errorNombre");
    errorPrecio = document.getElementById("errorPrecio");
    artTotal = document.formulario.artCarro;
    precioTotal = document.formulario.precioCarro;  
}

function reset(){
    nombreItem.value = "";
    precioItem.value = "";
    unidadesItem.value = 1;
    errorNombre.innerHTML = "";
    errorPrecio.innerHTML = "";
}

function verPrecios() {
    precioSuma +=(precioItem.value * unidadesItem.value);
    precioTotal.value = precioSuma;
}

function verArticulos() {
    listaItem.push(nombreItem.value);
    for (var i = 0; i < listaItem.length; i++) {
        if (i == 0) {
            totalNombre = listaItem[i];
        } else {
            totalNombre += " ," + listaItem[i];
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
}

function eventos() {
    document.formulario.addCarro.addEventListener("click", addCarrito);
}

function addCarrito() {
    
    validacionNombre();
    validacionPrecio();
    if (validacionPrecio()) {
        precioItem.focus();
        errorNombre.innerHTML = "";
    }else if (validacionNombre()){
        nombreItem.focus();
        errorPrecio.innerHTML = "";
    }else{
        verArticulos();
        verPrecios();
        reset();
    }
    
}

window.onload = function () {
    inicializar();
    eventos();
};
