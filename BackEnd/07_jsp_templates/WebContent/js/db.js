const articleIds = ["db-article","dbz-article","dbgt-article"];
const navIds = ["db-nav","dbz-nav","dbgt-nav","all-nav"];

function setArticle(articleId){
	console.log("setArticle("+articleId+")");
	var currentNavSet = false;
	var i;
	
	//Change the content of the page
	for(i=0;i<articleIds.length;i++){
		//Hide-unhide articles
		article = document.getElementById(articleIds[i]);
		if(articleId == "all-articles" || articleId == articleIds[i]){
			//remove hideme class to the element
			console.log("remove hideme class to "+articleIds[i]);
			article.className = "";
		}else{
			//add hideme class to the element
			console.log("Add hideme to "+articleIds[i]);
			article.className = "hideme";
		}
		
		// Change the style of the "current" nav item
		navElement = document.getElementById(navIds[i]);
		if(articleId == articleIds[i]){
			navElement.className = "current-nav";
			currentNavSet = true;
		}else{
			navElement.className = "";
		}
	}
	console.log(navIds[i]);
	//This is the 4th nav item
	navElement = document.getElementById(navIds[i]);
	if(!currentNavSet){
		// 4th element is the current one
		console.log("4th element is the current one");
		navElement.className = "current-nav";
	}else{
		// 4th element is not the current one
		console.log("4th element is not the current one");
		navElement.className = "";
	}
}