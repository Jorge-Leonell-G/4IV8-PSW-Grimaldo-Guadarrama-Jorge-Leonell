//obtener los valores que vienen por parte
//de las dieferentes variables [id]

//Aqui vamos a utilzar JS de una forma distinta
/*
Comenzamos con el uso de las variables let, que a diferencia de las var,
solo funcionan dentro de funciones en que son especificadas, esto para evitar una 
sobrecarga de los valores a la variable
*/
let temporizador = document.getElementById('temporizador');
let iniciar = document.getElementById('iniciar');
let resetear = document.getElementById('resetear');
let grabar = document.getElementById('grabar');
let almacenarTiempos = document.getElementById('almacenarTiempos');

let tiempo = 0;
let intervalo = 0;
let verificador = false;

init();

function init(){
    iniciar.addEventListener('click', iniciarContador);
    resetear.addEventListener('click', resetearContador);
    grabar.addEventListener('click', grabarContador);
}
//Ya supe como "parar el tiempo". Oh yeah!
/*
Simplemente tuvimos que borrar el "var" de nuestra variable intervalo, ya que al tener var, no 
se "conectaba" por así decirlo con el let inicializado en 0 que tenemos en la parte posterior.
Por lo que en vez de parar nuestro cronómetro, lo que provocábamos era un incremento en 10 milisegundos 
de nuestro cronómetro.
Se podría decir que hicimos a nuestra variable intervalo, una variable global.
*/
function iniciarContador(){
    if(verificador == false){
        intervalo = setInterval(function (){
            tiempo += 0.01;
            temporizador.innerHTML = tiempo.toFixed(2);
        }, 10);
        verificador = true;
    }else{
        verificador = false;
        clearInterval(intervalo);
    }
}

function resetearContador(){
    verificador = false;
    tiempo = 0;
    temporizador.innerHTML = tiempo + '0.00';
    clearInterval(intervalo);
    while(almacenarTiempos.firstChild){
        almacenarTiempos.removeChild(almacenarTiempos.firstChild);
    }
}
/*
Por alguna razón, nuestro cronometro se extiende a dos cifras al presionar "Resetear", es decir, 
tenemos un "00.00". Es por eso que en nuestra condicional if, agregué dos casos unidos por una 
disyunción ||
*/
//Primer caso: textContent al iniciar por primera vez||Segundo caso: textContent al presionar "Resetear"
function grabarContador(){
    if(temporizador.textContent === '0.00' || temporizador.textContent === '00.00'){
        console.log('Click en el botón iniciar');
        //También desplegaremos una alerta why not :)
        alert('Presione el botón "Iniciar/Parar"');
    }else{
        let p = document.createElement('ul');
        p.innerHTML = `
        
        <li> Tiempo : ${tiempo.toFixed(2)} </li>
        
        `;
        almacenarTiempos.appendChild(p);
    }
}