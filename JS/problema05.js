/*
Un maestro desea saber qué porcentaje de hombres y qué porcentaje
de mujeres hay en un grupo de estudiantes.
*/


//Podemos solo tener una funcion para validar, pero ya no quiero
//mover nada en esta parte nononono D:

//Así que asi se queda esto :)
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



function porcentajeCalcular(){
    var valor = parseInt(document.alumnos.numalumnos.value);
    var valorH = parseInt(document.alumnos.numhombres.value);
    var valorM = parseInt(document.alumnos.nummujeres.value);
    
    var perH = (valorH / valor) * 100;
    var perM = (valorM / valor) * 100;
//Funcion disyuntiva que analiza si la cifra de alumnos ingresada es un valor acorde a la situación
    if(valor > 90 || valor<10){
        alert("Ingrese un número válido de alumnos, más en específico, de entre 10 a 90 alumnos");
        document.alumnos.numalumnos.value = "";
        document.alumnos.numhombres.value = "";
        document.alumnos.nummujeres.value = "";
        document.alumnos.porcentajeH.value = "";
        document.alumnos.porcentajeM.value = "";
        alumnos.numalumnos.focus();
//Aquí vemos si la cifra de hombres es mayor a la cifra de alumnos en total
//Para las mujeres haremos lo mismo en otro else
    }else{
        if(valorH>valor){
            alert("Error: Hay más hombres que la cifra establecida de alumnos.\nVuelva a revisar e inténtelo otra vez");
            document.alumnos.numalumnos.value = "";
            document.alumnos.numhombres.value = "";
            document.alumnos.nummujeres.value = "";
            document.alumnos.porcentajeH.value = "";
            document.alumnos.porcentajeM.value = "";
            alumnos.numhombres.focus();
        }else{
            if(valorM>valor){
                alert("Error: Hay más mujeres que la cifra establecida de alumnos.\nVuelva a revisar e inténtelo otra vez");
                document.alumnos.numalumnos.value = "";
                document.alumnos.numhombres.value = "";
                document.alumnos.nummujeres.value = "";
                document.alumnos.porcentajeH.value = "";
                document.alumnos.porcentajeM.value = "";
                alumnos.nummujeres.focus();
                //Funcion que evalua si la suma de hombres y mujeres es igual a la cifra de alumnos en total
            }else{
                if(valorH + valorM != valor){
                    alert("Error: Las cifras no coinciden correctamente");
                    document.alumnos.numalumnos.value = "";
                    document.alumnos.numhombres.value = "";
                    document.alumnos.nummujeres.value = "";
                    document.alumnos.porcentajeH.value = "";
                    document.alumnos.porcentajeM.value = "";
                    alumnos.numhombres.focus();
                }else{ 
                document.alumnos.porcentajeH.value = "%"+perH;
                document.alumnos.porcentajeM.value = "%"+perM;

            }
        }
    }
  }
} 

function borrar(){
    document.alumnos.numalumnos.value = "";
    document.alumnos.numhombres.value = "";
    document.alumnos.nummujeres.value = "";
    document.alumnos.porcentajeH.value = "";
    document.alumnos.porcentajeM.value = "";
}