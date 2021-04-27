function validarCadena(e){

}

function validarNumero(e){
    var teclado = (document.all)?e.keyCode:e.which
    if(teclado == 8)return true;

    var patron = /[0-9\d ]/;

    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba)
}

function validarCorreo(e){
    var teclado = (document.all)?e.keyCode:e.which
    if(teclado == 8)return true;

    var email = /^[^@\s]+@[^@\.\s]+(\.[^@\.\s]+)+$/;

    var prueba = String.fromCharCode(teclado);
    return email.test(prueba)
}

function validarAlertas(){
    dnom = //bla bla code code
    dappat = document.formulario.appat.value;
    dapmat = document.formulario.apmat.value;
    dedad = parseInt(document.formulario.edad.value);

}