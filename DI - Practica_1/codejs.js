var nombreItem;
var precioItem;
var errorNombre;

function inicializar(){
    
    precioItem = document.formulario.precio;
    nombreItem = document.formulario.nombre;
    errorNombre = document.getElementById("errorNombre");
    errorPrecio = document.getElementById("errorPrecio");
}

function validacionNombre(){
    if (nombreItem.value == ""){
        errorNombre.innerHTML = "Falta artículo";
        errorNombre.style.color = "red";
    }
}

function validacionPrecio() {
    if (precioItem.value == ""){
        errorPrecio.innerHTML = "Falta precio.";
        errorPrecio.style.color = "red";
    }else if (precioItem.value == NaN){
        errorPrecio.innerHTML = "Deben ser números.";
        errorPrecio.style.color = "red";
    }
}

function eventos() {
    document.formulario.addCarro.addEventListener('click', addCarrito);
}

function addCarrito() {
    validacionNombre();
    validacionPrecio();
}

window.onload = function() {
    inicializar();
    eventos();
}
