/*
vamos a crear una función que se encargue que
que a partir de una expresión regular se valide la entrada
de únicamente números
*/

function validarn(e){
   var teclado = (document.all)?e.keyCode:e.which
    if(teclado == 8)return true;

    var patron = /[0-9\d .]/;

    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba)
}

function interes(){
    var valor = document.formulario.cantidad.value;
    //nuestro valor lo obtenemos como una cadena
    //procedemos a nuestro parseo de cadena a int
    var result = parseInt(valor);
    var interes = result * 0.02;
    var total = result+interes;

    document.formulario.sueldoti.value = "$"+total;
}

function borrar(){
    document.formulario.sueldoti.value = "";
    document.formulario.cantidad.value = "";
}