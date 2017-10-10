function forma(){
	let x = document.getElementsByClassName("uno");
	let i;
	for (i = x.length-1; i >= 0 ; i--) {
    	x[i].className = "dos";
	}
}
function vuelta(){
	let x = document.getElementsByClassName("dos");
	let i;
	for (i = x.length-1; i >= 0 ; i--) {
    	x[i].className = "uno";
	}
}
function todo(){
	let db = document.getElementById("dbDiv");
	let dbz = document.getElementById("dbzDiv");
	let dbgt = document.getElementById("dbgtDiv");
	db.style.display = "block";	
	dbz.style.display = "block";	
	dbgt.style.display = "block";	
}
function db(){
	let db = document.getElementById("dbDiv");
	let dbz = document.getElementById("dbzDiv");
	let dbgt = document.getElementById("dbgtDiv");	
	db.style.display = "block";	
	dbz.style.display = "none";	
	dbgt.style.display = "none";	
}
function dbz(){
	let db = document.getElementById("dbDiv");
	let dbz = document.getElementById("dbzDiv");
	let dbgt = document.getElementById("dbgtDiv");	
	db.style.display = "none";	
	dbz.style.display = "block";	
	dbgt.style.display = "none";	
}
function dbgt(){
	let db = document.getElementById("dbDiv");
	let dbz = document.getElementById("dbzDiv");
	let dbgt = document.getElementById("dbgtDiv");	
	db.style.display = "none";	
	dbz.style.display = "none";	
	dbgt.style.display = "block";	
}