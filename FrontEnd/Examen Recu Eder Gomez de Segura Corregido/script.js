function clicado(that){
	var s2 = document.getElementsByTagName('section');

	for (var i = s2.length -1; i >= 0; i--) {
		s2[i].className = "desclicadoStilo";
	}
	var s = document.getElementById(that);
	s.className = "clicadoStilo";
}
