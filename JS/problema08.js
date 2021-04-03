/*
Leer tres números diferentes e imprimir el número mayor de los tres
*/

function validar(e){
    var teclado = (document.all)?e.keyCode:e.which
    if(teclado == 8)return true;

    var patron = /[0-9\d .]/;

    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba)
}

function imprimir(){
    n1 = parseFloat(document.numerosmayor.numero1.value);
    n2 = parseFloat(document.numerosmayor.numero2.value);
    n3 = parseFloat(document.numerosmayor.numero3.value);

    if(n1 > n2 && n1 > n3){
        document.numerosmayor.resultado.value = n1;
    }else{
        if(n2 > n1 && n2 > n3){
            document.numerosmayor.resultado.value = n2;
        }else{
            if(n3 > n1 && n3 > n2){
                document.numerosmayor.resultado.value = n3;
            }else{
                if(n1 == n2 || n2 == n3 || n3 == n1){
                    alert("Hay números iguales, procure colocar números distintos entre sí");
                }else{
                    alert("Error: No hay números para ser validados :(( bot triste");
                }
            }
        }
    }

}

function borrar(){
    document.numerosmayor.numero1.value = "";
    document.numerosmayor.numero2.value = "";
    document.numerosmayor.numero3.value = "";
    document.numerosmayor.resultado.value = "";
}