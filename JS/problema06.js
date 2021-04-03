/*
Realizar un algoritmo que calcule la edad de una persona.
*/

function validar(e){
    var teclado = (document.all)?e.keyCode:e.which
    if(teclado == 8)return true;

    var patron = /[0-9\d ]/;

    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba)
}

function calculoEdad(){
    var aa = parseInt(document.edad.actual.value);
    var an = parseInt(document.edad.nacimiento.value);

    if(aa == an){
        alert("¡¿Acaso eso es posible :o?! Tenemos a un viajero del tiempo\nSólo bromeaba, sea sincero e ingrese correctamente los datos ;)");
        document.edad.actual.value = "";
        document.edad.nacimiento.value = "";
        document.edad.edadT.value = "";
    }else{
        if(aa - an > 110){
            alert("... No sé si creerle o no... Pero aquí está su resultado");
            edadP = aa - an;
            document.edad.edadT.value = edadP + " años";
        }else{
            edadP = aa - an;
            document.edad.edadT.value = edadP + " años";
        }
    }

}


function borrar(){
    document.edad.actual.value = "";
    document.edad.nacimiento.value = "";
    document.edad.edadT.value = "";
}