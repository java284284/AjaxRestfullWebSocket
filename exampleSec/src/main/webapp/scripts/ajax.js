try { 
	console.log("Loading script");
} catch(e) { 
	console = { log: function() {} }; 
}
function sendRequest(serverProgram, id) {
	var request = getRequestObject();	
	request.onreadystatechange =
	        function() { handleResponse(request, id)};
	request.open("GET", serverProgram, true);
    request.send(null);
}

function handleResponse(request, id) {
	if (request.readyState == 4  && request.status == 200) {
		//console.log("Response text is '%s'.",request.responseText);
		document.getElementById(id).innerHTML = request.responseText;
		
	}
}
function htmlInsert(id, htmlData) {
	document.getElementById(id).innerHTML = htmlData;
}
function getRequestObject() {
	if (window.XMLHttpRequest) {
		return (new XMLHttpRequest());     //Opera, Safari, Mozilla, Chrome, IE 7, and IE 8.
	} else if (window.ActiveXObject) {
		return(new ActiveXObject("Microsoft.XMLHTTP"));  //IE 5 and IE 6.
	} else {
		return(null);
	}
}
