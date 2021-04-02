/*
Un maestro desea saber qué porcentaje de hombres y qué porcentaje
de mujeres hay en un grupo de estudiantes.
*/

function validarAlumnos(e){
    var teclado = (document.all)?e.keyCode:e.which
    if(teclado == 8)return true;
 
    var patron = /[0-9\d]/;
 
    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba)
}

function validarH(e){
    var teclado = (document.all)?e.keyCode:e.which
    if(teclado == 8)return true;
 
    var patron = /[0-9\d .]/;
 
    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba)
}

function validarM(e){
    var teclado = (document.all)?e.keyCode:e.which
    if(teclado == 8)return true;
 
    var patron = /[0-9\d .]/;
 
    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba)
}

function porcentajeH{
    var valor = parseInt(document.alumnos.numalumnos.value);
    var valorH = parseInt(document.alumnos.numhombres.value);
    var valorM = parseInt(document.alumnos.nummujeres.value);
    
    var perH = (valorH / valor) * 100;
    var perM = (valorM / valor) * 100;

    document.alumnos.porcentajeH.value = "%"+perH;
    document.alumnos.porcentajeM.value = "%"+perM;
}