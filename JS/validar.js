function validar (formulario) {
    /*
    queremos validar que se escriban más de 5 caracteres 
    en el campo nombre
    */ 

    if(formulario.nombre.value.length < 5){
        alert("Por favor ingrese más de 5 caracteres en el campo nombre");
        formulario.nombre.focus();
    return false;
    }

    if(formulario.edad.value > 100){
        alert("Ingrese una edad válida de entre 0 a 100 años")
        formulario.edad.focus();
    return false;
    }

    /*
    validar que acepte unicamente letras 
    */

    var checkOk = "QWERTYUIOPASDFGHJKLÑZXCVBNM" 
    + "qwertyuiopasdfghjklñzxcvbnm";

    var checkStr = formulario.nombre.value;

    var allValid = true;

    for(var i = 0; i<checkStr.length; i++){
        var ch = checkStr.charAt(i);
        for(var j = 0; j<checkOk.length; j++)
        if(ch == checkOk.charAt(j))
            break;

        if(j == checkOk.length){
            allValid = false;
            break;
        }

    }

    if(!allValid){
        alert("Escribe solo letras en el campo nombre")
        formulario.nombre.focus();
        return false;
    }

    /*
    ahora vamos a validar solo numeros
    */

    var checkOk = "0123456789";

    var checkStr = formulario.edad.value;

    var allValid = true;

    for(var i = 0; i<checkStr.length; i++){
        var ch = checkStr.charAt(i);
        for(var j = 0; j<checkOk.length; j++)
        if(ch == checkOk.charAt(j))
            break;

        if(j == checkOk.length){
            allValid = false;
            break;
        }

    }

    if(!allValid){
        alert("Escribe solo números en el campo edad")
        formulario.edad.focus();
        return false;
    }

    /*
    validar correo electronico
    Expresiones regulares
    nos van a ayudar a poder diferenciar una cadena de caracteres
    y definir que caracteres son validos de acuerdo 
    a una condicion
    */

    var txt = formulario.email.value;

    //expresion regular
    //algo@algo.com
    //algo@algo.algo.com
    var b = /^[^@\s]+@[^@\.\s]+(\.[^@\.\s]+)+$/;

    alert("Email" + (b.test(txt)?"":"no")+ "valido");
    return b.test(txt);




}