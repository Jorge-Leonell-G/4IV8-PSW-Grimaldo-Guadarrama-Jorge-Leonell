/*
Una tienda ofrece un descuento del 15% sobre el total de la 
compra y un cliente desea saber cuánto deberá pagar finalmente 
por su compra.
*/

function validar(e){
     var teclado = (document.all)?e.keyCode:e.which
     if(teclado == 8)return true;
 
     var patron = /[0-9\d .]/;
 
     var prueba = String.fromCharCode(teclado);
     return patron.test(prueba)
 }
 
 function descuento(){
     var gasto = document.compra.costo.value;
     //Realizamos el debido parseo de nuestra var
     var p = parseFloat(gasto);
     //uso de condicional para definir un limite en la compra
     if(p > 10000.00){
         alert("WOW! Eso es mucho dinero!. La tienda no quiere cerrar aún :(.\n"
         +"Ingrese una cantidad que no sobrepase los $10000.00");
         document.compra.costo.value = "";
         document.compra.comprati.value = "";
         compra.costo.focus();
     }else{
        if(p < 1){
        alert("Solo se hacen descuentos con compras mayores o iguales a $1.00");
        document.compra.costo.value = "";
        document.compra.comprati.value = "";
        compra.costo.focus();
    }else{
        var desc = gasto * 0.15;
        var result = p - desc;
        document.compra.comprati.value = "$"+result;
        }
        
    }
}
 
 function borrar(){
    document.compra.comprati.value = "";
    document.compra.costo.value = "";
 }