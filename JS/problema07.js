/*
Leer dos números; si son iguales que los multiplique, 
si el primero es mayor que el segundo, que los reste, y 
si no que los sume
*/

function validar(e){
    var teclado = (document.all)?e.keyCode:e.which
    if(teclado == 8)return true;

    var patron = /[0-9\d .]/;

    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba)
}

function calcular(){
    var n1 = parseFloat(document.numeros.numero1.value);
    var n2 = parseFloat(document.numeros.numero2.value);

    if(n1 == n2){
        resultadoM = n1 * n2;
        document.numeros.resultado.value = resultadoM;
    }else{
        if(n1 > n2){
            resultadoR = n1 - n2;
            document.numeros.resultado.value = resultadoR;
        }else{
            resultadoS = n1 + n2;
            document.numeros.resultado.value = resultadoS;
        }
    }

}

function borrar(){
    document.numeros.numero1.value = "";
    document.numeros.numero2.value = "";
    document.numeros.resultado.value = "";
}