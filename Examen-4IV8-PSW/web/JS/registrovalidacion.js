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
function validarDomicilio(e){
    var teclado = (document.all)?e.keyCode:e.which
    if(teclado == 8)return true;

    var domic = /^[a-zA-Z0-9_.+-]+[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;

    var prueba = String.fromCharCode(teclado);
    return domic.test(prueba)
}

//funcion extra para validar el ingreso de precios :D
function validarCosto(e){
    var teclado = (document.all)?e.keyCode:e.which
    if(teclado == 8)return true;

    var precio = /[0-9\d. ]/;

    var prueba = String.fromCharCode(teclado);
    return precio.test(prueba)
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
        alert("Error: Campo vacío");

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


function validarAlertasElim(){
    //variable extra para la fucnion de eliminar usuario
    deliminar = parseInt(document.formularioeliminar.ideliminar.value);
    if(deliminar == ""){
        alert("Error: Por favor ingrese el ID del usuario a eliminar");
        
        return false;
    }else{
        return true;
    }
}


function validarAlertasAct(){
    //inclusión de la variable para el ID
    idact = parseInt(document.formularioactualizar.idactualizar.value);
    //demas variables del container del registro
    dnom = document.formularioactualizar.nombre_act.value;
    dappat = document.formularioactualizar.appat_act.value;
    dapmat = document.formularioactualizar.apmat_act.value;
    dedad = parseInt(document.formularioactualizar.edad_act.value);
    dcorreo = document.formularioactualizar.correo_act.value;
    
    if(idact == ""){
        alert("Error: Por favor ingrese el ID del usuario a actualizar");
        
        return false;
    }else{
        if(dnom == ""){
        alert("Error: Campo vacío");

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
                        return true;
                    }
                }
            }
          }
      }
    }
  }
