function problema1(){

    var p1_input = document.querySelector('#p1-input').value;
    //Identificar como dividir el texto escrito por espacios
    var p1_array = p1_input.split('').reverse();
    //habla  albah

    //construir la nueva cadena invertida
    var p1_res = '';

    p1_array.forEach(function(palabra, i){
        //si es el principio o es el final de la cadena
        //asi mismo tenemos que saber que no agregamos espacios en blanco
        if(i != 0 || i != p1_array.length) p1_res += ' ';
        p1_res += palabra;
    });
    //imprimir el resultado
    document.querySelector('#p1-output').textContent = p1_res;
}

function problema2(){

    var p2_x1 = document.querySelector('#p2-x1').value;
    var p2_x2 = document.querySelector('#p2-x2').value;
    var p2_x3 = document.querySelector('#p2-x3').value;
    var p2_x4 = document.querySelector('#p2-x4').value;
    var p2_x5 = document.querySelector('#p2-x5').value;

    var p2_y1 = document.querySelector('#p2-y1').value;
    var p2_y2 = document.querySelector('#p2-y2').value;
    var p2_y3 = document.querySelector('#p2-y3').value;
    var p2_y4 = document.querySelector('#p2-y4').value;
    var p2_y5 = document.querySelector('#p2-y5').value;

    //construir los vectores

    var v1 = [p2_x1, p2_x2, p2_x3, p2_x4, p2_x5];
    var v2 = [p2_y1, p2_y2, p2_y3, p2_y4, p2_y5];

    //ordenar los vectores

    v1 = v1.sort(function (a, b){
        return b-a;
    });

    v2 = v2.sort(function (a, b){
        return b-a;
    });

    //invertir el segundo vector

    v2 = v2.reverse();

    //producto escalar
    var p2_producto = 0;

    for(var i = 0; i < v1.length; i++){
        p2_producto += v1[i] * v2[i];
    }

    document.querySelector('#p2-output').textContent =
    'Producto Escalar Minimo : '+ p2_producto;
}

/*
function problema3(){
    //tarea aaaaaaa
    //Bien, comenzemos utilizando querySelector
    let car = document.querySelector('#p3-input').value;
    //breve definicion de split
    let word = car.split(",");
    let large = " ";

    for(let p of word){
        if(p.length > large.length){
            large = p;

            var p_num = large.split("");
            var num = p_num.length;
        }
    }
    //document.querySelector('#p3-output').textContent = 'La palabra con más caracteres es: ' + large + ' ' + num + ' (' + car + ')' ;
    document.querySelector('#p3-output').textContent = 'La palabra con más caracteres es : '+
    large + 'Número de caracteres en la palabra: ' + num;
}
*/


function problema3(){
    //Comenzamos añadiendo un querySelector para obtener el valor de nuestro id
    let car = document.querySelector('#p3-input').value;
    //definimos que simbolo va entre el espaciado de cada caracter
    let space = car.split(",");
    let resultadoP = " ";

    //ciclo for por cada palabra de nuestro espaciado
    for(let word of space){
        if(word.length > resultadoP.length){
        resultadoP = word;
        //creamos a p, que define la palabra final sin comas después de cada caracter
        var p = resultadoP.split("");
        //le asignamos su largo a la variable num
        var num = p.length;
        //variable que define la palabra mayor escrita en mayusculas
        var resultadoPM = resultadoP.toUpperCase();
        }
    }
    //imprimimos el resultado (output)
    document.querySelector('#p3-output').textContent = 
    'La palabra con más caracteres es: ' + resultadoPM + 
    ' = '  + num +' ('+ p + ')';
}


//Funcion para la validacion de datos ingresados
function validar(e){
    key = e.keyCode || e.which;
    tecla = String.fromCharCode(key).toString();
    //incluimos coma, el abecedario en mayúsculas y con acentos
    letras = ",ABCDEFGHIJKLMNOPQRSTUVWXYZÁÉÍÓÚabcdefghijklmnopqrstuvwxyzáéíóú";
    
    //expresion regular para las teclas especiales
    spec = [8,13];
    tecla_spec = false
    for(var i in spec) {
        if(key == spec[i]){
        tecla_spec = true;
        break;
    }
}

    if(letras.indexOf(tecla) == -1 && !tecla_spec){
        alert("Nope, no vayas por esas teclas :)\nSólo está permitido el uso de MAYÚSCULAS y comas :)");
        return false;
    }
}

