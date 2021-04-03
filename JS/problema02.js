/*
Un vendedor recibe un sueldo base más un 10% extra por 
comisión de sus ventas, el vendedor desea saber cuánto dinero 
obtendrá por concepto de comisiones por las tres ventas que 
realiza en el mes y el total que recibirá en el mes tomando 
en cuenta su sueldo base y comisiones.
*/

//Cambiamos la expresion regular para que ahora solo pueda ingresar digitos del 1 al 3
//AUNQUE NO NOS SERVIRÁ DE MUCHO CON LA FUNCION IF 
function validar(e){
    var teclado = (document.all)?e.keyCode:e.which
    if(teclado == 8)return true;

    var patron = /[0-9\d ]/;

    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba)
}

function validarVenta(e){
    var teclado = (document.all)?e.keyCode:e.which
    if(teclado == 8)return true;

    var patron = /[0-9\d .]/;

    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba)
}

//Funcion para la ganancia contando sólo las comisiones
function comision(){
    //variables
    var puestos = parseInt(document.comisiones.opcion.value);
    var v1 = parseFloat(document.comisiones.venta1.value);
    var v2 = parseFloat(document.comisiones.venta2.value);
    var v3 = parseFloat(document.comisiones.venta3.value);

    //Condicionales
    if(puestos < 1 || puestos >3){
        alert("Error: Ingrese un número acorde a la tabla");
        document.comisiones.opcion.value = "";
        document.comisiones.venta1.value = "";
        document.comisiones.venta2.value = "";
        document.comisiones.venta3.value = "";
        document.comisiones.result.value = "";
        document.comisiones.resultplus.value = "";

    }else{
        if(v1 < 10.0 || v2 < 10.0 || v3 < 10.0){
            alert("Vaya, no tuviste mucha suerte verdad?\n
            Vuelva cuando una de sus ventas supere los $10.00");
            document.comisiones.opcion.value = "";
            document.comisiones.venta1.value = "";
            document.comisiones.venta2.value = "";
            document.comisiones.venta3.value = "";
            document.comisiones.result.value = "";
        }else{
            if(v1 > 10000.00 || v2 > 10000.00 || v3 > 10000.00){
                alert("Esas cantidades son demasiado!!!\nSólo se permiten cantidades de entre $10.00 a $10000.00");
                document.comisiones.opcion.value = "";
                document.comisiones.venta1.value = "";
                document.comisiones.venta2.value = "";
                document.comisiones.venta3.value = "";
                document.comisiones.result.value = "";
            }else{
                    var ganancia = (v1 + v2 + v3) * 0.10;

                    document.comisiones.result.value = +ganancia;
            }
        }
    }
}

//Funcion para la ganancia más el sueldo base

function comisionPlus(){
    var puestos = parseInt(document.comisiones.opcion.value);
    var v1 = parseFloat(document.comisiones.venta1.value);
    var v2 = parseFloat(document.comisiones.venta2.value);
    var v3 = parseFloat(document.comisiones.venta3.value);

    //Condicionales
    if(puestos < 1 || puestos >3){
        alert("Error: Ingrese un número acorde a la tabla");
        document.comisiones.opcion.value = "";
        document.comisiones.result.value = "";
        document.comisiones.resultplus.value = "";

    }else{
        if(v1 < 10.0 || v2 < 10.0 || v3 < 10.0){
            alert("Vaya, no tuviste mucha suerte verdad?\n
            Vuelva cuando una de sus ventas supere los $10.00");
            document.comisiones.opcion.value = "";
            document.comisiones.venta1.value = "";
            document.comisiones.venta2.value = "";
            document.comisiones.venta3.value = "";
            document.comisiones.result.value = "";
        }else{
            if(v1 > 10000.00 || v2 > 10000.00 || v3 > 10000.00){
                alert("Esas cantidades son demasiado!!!\nSólo se permiten cantidades de entre $10.00 a $10000.00");
                document.comisiones.opcion.value = "";
                document.comisiones.venta1.value = "";
                document.comisiones.venta2.value = "";
                document.comisiones.venta3.value = "";
                document.comisiones.result.value = "";
            }else{
                if(puestos == 1){
                    var ganancia1 = 500 + ((v1 + v2 + v3) * 0.10);
                    document.comisiones.resultplus.value = +ganancia1;
                }else{
                    if(puestos == 2){
                        var ganancia2 = 800.00 + ((v1 + v2 + v3) * 0.10);
                        document.comisiones.resultplus.value = +ganancia2;
                    }else{
                        if(puestos == 3){
                            var ganancia3 = 1200.00 + ((v1 + v2 + v3) * 0.10);
                            document.comisiones.resultplus.value = +ganancia3;
                        }
                    }
                }
            }
        }
    }
}

function borrar(){
    document.comisiones.opcion.value = "";
    document.comisiones.venta1.value = "";
    document.comisiones.venta2.value = "";
    document.comisiones.venta3.value = "";
    document.comisiones.result.value = "";
    document.comisiones.resultplus.value = "";
}