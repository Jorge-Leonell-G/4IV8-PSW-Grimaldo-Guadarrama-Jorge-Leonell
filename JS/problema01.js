/*
vamos a crear una función que se encargue que
que a partir de una expresión regular se valide la entrada
de únicamente números

Un individuo desea invertir su capital en un banco y 
desea saber cuánto dinero ganará después de un mes si el 
banco paga a razón de 2% mensual.
*/

function validarn(e){
   var teclado = (document.all)?e.keyCode:e.which
    if(teclado == 8)return true;

    var patron = /[0-9\d .]/;

    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba)
}

function validarmeses(e){
    var number = (document.all)?e.keyCode:e.which
    if(number == 8)return true;

    var patron = /[0-9\d]/;

    var prueba = String.fromCharCode(number);
    return patron.test(prueba)
}

function interes(){
    var valor = document.formulario.cantidad.value;
    var month = document.formulario.mes.value;
    //nuestro valor lo obtenemos como una cadena
    //procedemos a nuestro parseo de cadena a int
    var result = parseInt(valor);
    var mensual = parseInt(month)
    //En nuestra condición if, colocamos "48" que son los numeros de meses 
    //donde ya hay presencia de intereses fijos
    if(mensual > 48){
        alert("Error, ingrese una cantidad de meses válida de entre 1 a 48");
        document.formulario.sueldoti.value = "";
    }else{
        var interes = result * (mensual * 0.02);
        var total = result+interes;

        document.formulario.sueldoti.value = "$"+total;
    }
}

function borrar(){
    document.formulario.sueldoti.value = "";
    document.formulario.cantidad.value = "";
    document.formulario.mes.value = "";
}