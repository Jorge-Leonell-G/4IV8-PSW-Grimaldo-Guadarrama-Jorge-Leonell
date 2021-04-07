/*
Calcular la utilidad que un trabajador recibe 
                    en el reparto anual de utilidades si este se le asigna 
                    como un porcentaje de su salario mensual que depende de su 
                    antiguedad en la empresa de acuerdo con la siguiente tabla:
                    <br>
                    <table>
                        <tr>
                            <td>Tiempo</td>
                            <td>Utilidad</td>
                        </tr>
                        <tr>
                            <td>Menos de 1 año</td>
                            <td>5% del salario</td>
                        </tr>
                        <tr>
                            <td>1 año o más y menos de 2 años</td>
                            <td>7% del salario</td>
                        </tr>
                        <tr>
                            <td>2 años o más y menos de 5 años</td>
                            <td>10% del salario</td>
                        </tr>
                        <tr>
                            <td>5 años o más y menos de 10 años</td>
                            <td>15% del salario</td>
                        </tr>
                        <tr>
                            <td>10 años o más</td>
                            <td>20% del salario</td>
                        </tr>
                    </table>
                </li>
            </ol>
*/

function validar(e){
    var teclado = (document.all)?e.keyCode:e.which
    if(teclado == 8)return true;

    var patron = /[0-9\d]/;

    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba)
}


function utilidad(){
    //variables globales que funcionaran a lo largo de todo el switch
    var p = parseInt(document.utilidad.opcionU.value);
    var sueldo = 900.00;
//condicional switch
    switch (p){
        case 1:
            //Aqui designaremos las operaciones acorde a cada opcion
            sueldo1 = sueldo * 0.05;
            total = sueldo + sueldo1;
            document.utilidad.reparto.value = "$"+total;
            break;
        case 2:
            sueldo2 = sueldo * 0.07;
            total = sueldo + sueldo2;
            document.utilidad.reparto.value = "$"+total;
            break;
        case 3:
            sueldo3 = sueldo * 0.10;
            total = sueldo + sueldo3;
            document.utilidad.reparto.value = "$"+total;
            break;
        case 4:
            sueldo4 = sueldo * 0.15;
            total = sueldo + sueldo4;
            document.utilidad.reparto.value = "$"+total;
            break;
        case 5:
            sueldo5 = sueldo * 0.20;
            total = sueldo + sueldo5;
            document.utilidad.reparto.value = "$"+total;
            break;
        default:
            alert("Ingrese un número válido acorde a la tabla");
            document.utilidad.opcionU.value = "";
            document.utilidad.reparto.value = "";
            break; 
    }
    alert("Ingrese un número válido acorde a la tabla");
}


function borrar(){
    document.utilidad.opcionU.value = "";
    document.utilidad.reparto.value = "";
}