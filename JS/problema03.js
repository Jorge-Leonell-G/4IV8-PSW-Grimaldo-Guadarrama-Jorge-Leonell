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
     
 }