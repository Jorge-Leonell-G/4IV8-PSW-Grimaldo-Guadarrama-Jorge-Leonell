/*
Un alumno desea saber cuál será su calificación final en la materia 
de Algoritmos. Dicha calificación se compone de los siguientes porcentajes:
<ul>
    <li>55% del promedio de sus tres calificaciones parciales</li>
    <li>30% de la calficación del exámen final.</li>
    <li>15% de la calificación de un trabajo final</li>
*/

function validarn(e){
    var teclado = (document.all)?e.keyCode:e.which
    if(teclado == 8)return true;
 
    var patron = /[0-9\d .]/;
 
    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba)
}

//Creamos una funcion para validar que solo se esrciban numeros del 1 al 10

/*
function validarc(calificaciones){
    if(calificaciones.parcial1.value < 0 && calificaciones.parcial1.value. > 10){
        alert("Ingrese una calificación válida de entre 0 a 10");
        calificaciones.parcial1.focus();
    return false;
    }
}
*/

function parciales{
    var calif1 = document.calificaciones.parcial1.value;
    var c1 = parseFloat(calif1);
    var calif2 = document.calificaciones.parcial2.value;
    var c2 = parseFloat(calif2);
    var calif3 = document.calificaciones.parcial3.value;
    var c3 = parseFloat(calif3);

    if(c1<0 && c1>10){
        alert("Error: Ingrese una nota válida de entre 0 a 10");
        document.calificaciones.parcial1.value = "";
        calificaciones.parcial1.focus();
    }else{
        if(c2<0 && c2>10){
            alert("Error: Ingrese una nota válida de entre 0 a 10");
            document.calificaciones.parcial2.value = "";
            calificaciones.parcial2.focus();
        }else{
            if(c3<0 && c3>10){
                alert("Error: Ingrese una nota válida de entre 0 a 10");
                document.calificaciones.parcial3.value = "";
                calificaciones.parcial3.focus();
            }

        }
    }else

    var promedio = (c1 + c2 + c3) / 3

    //document.calificaciones.
}

function examen{

}

function trabajo{

}

function borrar(){
    document.calificaciones.parcial1.value = "";
    document.calificaciones.parcial2.value = "";
    document.calificaciones.parcial3.value = "";
    document.calificaciones.testfinal.value = "";
    document.calificaciones.trabajofinal.value = "";
 }