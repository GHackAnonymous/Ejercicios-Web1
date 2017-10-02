function updateMain(that){

	var alt = that.alt;

	//var img = document.getElementsByTagName("img:hover");

	//for (var i = 0; i < img.length; i++) {
		
	   // var alt = img[i].alt;

    	console.log(alt);
    
	    if(alt == "This is the alt of the 1st image"){
	    	crearImg(0);
	    	var texto = document.getElementById("mainText");
	    	texto.textContent  = alt;
	    }else if(alt == "This is the alt of the 2nd image"){
	    	crearImg(1);
	    	var texto = document.getElementById("mainText");
	    	texto.textContent  = alt;
	    }else if(alt == "This is the alt of the 3rd image"){
	    	crearImg(2);
	    	var texto = document.getElementById("mainText");
	    	texto.textContent  = alt;
	    }
	//}
}

/*function crearImg(int){
	var url = document.getElementsByTagName("img")[int].getAttribute("src");
	var contenedor = document.getElementById("main");
	var img = document.createElement('img');
	img.id = "full";
	img.style.width = '100%';
	img.style.height = '100%';
	img.style.padding = "40";
	img.setAttribute("src",url); 
	contenedor.appendChild(img);
}*/

function crearImg(int){
	var url = document.getElementsByTagName("img")[int].getAttribute("src");
	var contenedor = document.getElementById("main");
	contenedor.style.backgroundImage = "url("+url+")";//"url('img_tree.png')"; 
}


/*function resetMain(){
	var element = document.getElementById("full");
	if (element) {
    	element.parentNode.removeChild(element);
	}
	var texto = document.getElementById("mainText");
	texto.textContent  = "Hover an image to display it here.";
}*/

function resetMain(){
	var element = document.getElementById("main");
	element.style.backgroundImage = "none";


	var texto = document.getElementById("mainText");
	texto.textContent  = "Hover an image to display it here.";
}

/*https://stackoverflow.com/questions/36992781/display-image-alt-attribute-text-on-hover*/
/* https://jsfiddle.net/ywLjkgah/2/ */