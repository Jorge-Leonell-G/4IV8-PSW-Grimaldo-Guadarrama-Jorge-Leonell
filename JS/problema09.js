/*
Determinar la cantidad de dinero que recibirá un trabajador por 
concepto de las horas extra trabajadas en una empresa, sabiendo que 
cuando las horas de trabajo exceden de 40, el resto 
se consideran horas extra y que estas se pagan al doble de 
una hora normal cuando no exceden de 8; si las horas extra exceden de 8
se pagan las primeras 8 al doble de lo que se pagan las horas normales 
y el resto al triple.
*/

function validar(e){
    var teclado = (document.all)?e.keyCode:e.which
    if(teclado == 8)return true;

    var patron = /[0-9\d .]/;

    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba)
}

function horasTotal(){
    var horasemana = parseInt(document.hora.hrs.value);

    if(horasemana > 40){
        var horasextra = horasemana - 40;

        if(horasextra < 8){
            var horasextra = (horasemana * 2)

            var total1 = horasextra + (horasemana * 200.00);
            document.hora.horasT.value = + total1;

        }else{
            if(horasextra - horasemana == 8){
                primerashoras = horasextra - horasemana;
                horasextra = horasextra + primerashoras;

                var total2 = (horasextra * 400.00) * (horasemana * 200.00);
                document.hora.horasT.value = + total2;

            }else{
                horatriple = (horasextra * 3)

                var total3 = (horasemana * 200.00) + (horatriple * 200.00);
                document.hora.horasT.value = + total3;
            }
            
        }
        
    }else{
        var totalN = (horasemana * 200.00)
        document.hora.horasT.value = + totalN;
    }

}

function borrar(){
    document.hora.hrs.value = "";
    document.hora.horasT.value = "";
}