//Obtenemos nuestros elementos HTML mediante getElementsByClassName(Clase);
var piezas = document.getElementsByClassName('movil');

var tamWidh = [134,192,134,163,134,163,134,192,134];

var tamHeight = [163,134,163,134,192,134,163,134,163];

//enviamos nuestros atributos a través de un recorrido por cada pieza, esto para la redimensión 
//de las imágenes
for(var i=0;i<piezas.length;i++){
	piezas[i].setAttribute("width", tamWidh[i]);
	piezas[i].setAttribute("height",tamHeight[i]);
    //posicionamiento de las piezas
	piezas[i].setAttribute("x", Math.floor((Math.random() * 10) + 1));
	piezas[i].setAttribute("y", Math.floor((Math.random() * 409) + 1));
	piezas[i].setAttribute("onmousedown","seleccionarElemento(evt)");
}

var elementSelect = 0;  
var currentX = 0;
var currentY = 0;
var currentPosX = 0;
var currentPosY = 0;

function seleccionarElemento(evt) {
	elementSelect = reordenar(evt);
	currentX = evt.clientX;        
	currentY = evt.clientY;
	currentPosX = parseFloat(elementSelect.getAttribute("x"));     
	currentPosY = parseFloat(elementSelect.getAttribute("y"));
	elementSelect.setAttribute("onmousemove","moverElemento(evt)");
}

function moverElemento(evt){
	var dx = evt.clientX - currentX;
	var dy = evt.clientY - currentY;
	currentPosX = currentPosX + dx;
	currentPosY = currentPosY + dy;
	elementSelect.setAttribute("x",currentPosX);
	elementSelect.setAttribute("y",currentPosY);
	currentX = evt.clientX;        
	currentY = evt.clientY;
    //casos en los que se efectua la deselección de las piezas
	elementSelect.setAttribute("onmouseout","deseleccionarElemento(evt)");
	elementSelect.setAttribute("onmouseup","deseleccionarElemento(evt)");
	iman();
}

//Aqui removemos las propiedades de movimiento para nuestras piezas, más en específico, 3 propiedades
function deseleccionarElemento(evt){
    //instancia de la funcion para la posicion final
	testing();
	if(elementSelect != 0){			
		elementSelect.removeAttribute("onmousemove");
		elementSelect.removeAttribute("onmouseout");
		elementSelect.removeAttribute("onmouseup");
		elementSelect = 0;
	}
}

var entorno = document.getElementById('entorno');

//reordenamos nuestro conjunto de piezas respecto al ultimo elemento conisderando al primero
function reordenar(evt){
	var padre = evt.target.parentNode;
	var clone = padre.cloneNode(true);
	var id = padre.getAttribute("id");
	entorno.removeChild(document.getElementById(id));
	entorno.appendChild(clone);
	return entorno.lastChild.firstChild;
}

var origX = [200,304,466,200,333,437,200,304,466];   
var origY = [100,100,100,233,204,233,337,366,337];

//no entiendo muy bien los poderes místicos de esta función
function iman(){
	for(var i=0;i<piezas.length;i++){
		if (Math.abs(currentPosX-origX[i])<15 && Math.abs(currentPosY-origY[i])<15) {
			elementSelect.setAttribute("x",origX[i]);
			elementSelect.setAttribute("y",origY[i]);
		}
	}
}

//sonido de pikachu XD			
var win = document.getElementById("win");

//Posicion correcta para cada pieza respecto a su origen
function testing() {
	var bien_ubicada = 0;
	var padres = document.getElementsByClassName('padre');
	for(var i=0;i<piezas.length;i++){
		var posX = parseFloat(padres[i].firstChild.getAttribute("x"));    
		var posY = parseFloat(padres[i].firstChild.getAttribute("y"));
		ide = padres[i].getAttribute("id");
		if(origX[ide] == posX && origY[ide] == posY){
			bien_ubicada = bien_ubicada + 1;
		}
	}
	if(bien_ubicada == 9){
		win.play();
	}
}