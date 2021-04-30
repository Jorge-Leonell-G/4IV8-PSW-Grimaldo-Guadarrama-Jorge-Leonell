//Podemos validar nuestro formulario de muchas formas, en este caso:
//Lo haremos a través de funciones, obteniendo ahí mismo el value, junto con expresiones regulares

//esta funcion será para los campos del nombre y apellidos
function validarNombre(e){
    var teclado = (document.all)?e.keyCode:e.which
    if(teclado == 8)return true;

    var name = /^[a-zA-ZÀ-ÿ\s]{1,40}$/;

    var prueba = String.fromCharCode(teclado);
    return name.test(prueba)
}

//funcion para validar edad
function validarNumero(e){
    var teclado = (document.all)?e.keyCode:e.which
    if(teclado == 8)return true;

    var patron = /[0-9\d ]/;

    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba)
}

//funcion para validar correo
function validarCorreo(e){
    var teclado = (document.all)?e.keyCode:e.which
    if(teclado == 8)return true;

    var email = /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]$/;

    var prueba = String.fromCharCode(teclado);
    return email.test(prueba)
}

/*
Esta función se va a encargar de emitir alertas en caso de que el usuario ingrese
datos que no sean válidos; a pesar de ya haber validado las entradas, hay que hacerle
saber al usuario que no todos los datos serán bienvenidos
*/
function validarAlertas(){
    dnom = document.formulario.nombre.value;
    dappat = document.formulario.appat.value;
    dapmat = document.formulario.apmat.value;
    dedad = parseInt(document.formulario.edad.value);
    dcorreo = document.formulario.correo.value;

    if(dnom == ""){
        alert("Error: Por favor ingrese su(s) nombre(s)");

        return false;
    }else{
        if(dappat == ""){
            alert("Error: Por favor ingrese su apellido paterno");

            return false;
        }else{
            if(dapmat == ""){
                alert("Error: Por favor ingrese su apellido materno");

                return false;
            }else{
                if(dedad == ""){
                    alert("Error: Por favor ingrese su edad");

                    return false;
                }else{
                    if(dcorreo == ""){
                        alert("Error: Por favor ingrese su email");

                        return false;
                    }else{
                        alert("Datos correctamente validados");

                        return true;
                    }
                }
            }
        }
    }
   }
  
