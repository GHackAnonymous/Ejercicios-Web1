function aparecer(arg){
	var elemento = document.getElementById(arg);
	elemento.style.display = "block";
}
function desAparecer(arg){
	var elemento = document.getElementById(arg);
	elemento.style.display = "none";
}
function dark(){
	var elemento = document.getElementById('Cuerpo');
	elemento.style.backgroundColor = "black";
	elemento.style.color = "whilte";
	var elemento = document.getElementsByClassName('tema');
	var i = 0;
	for(i = elemento.length-1; i>=0;i--){
			elemento[i].style.color = "white";
	}
	var elemento = document.getElementsByTagName('h2');
	var i = 0;
	for(i = elemento.length-1; i>=0;i--){
			elemento[i].style.backgroundColor = "white";
			elemento[i].style.color = "black";
	}
}
function light(){
	var elemento = document.getElementById('Cuerpo');
	elemento.style.backgroundColor = "white";
	elemento.style.color = "black";
	var elemento = document.getElementsByClassName('tema');
	var i = 0;
	for(i = elemento.length-1; i>=0;i--){
			elemento[i].style.color = "black";
	}
	var elemento = document.getElementsByTagName('h2');
	var i = 0;
	for(i = elemento.length-1; i>=0;i--){
			elemento[i].style.backgroundColor = "black";
			elemento[i].style.color = "white";
	}
}

