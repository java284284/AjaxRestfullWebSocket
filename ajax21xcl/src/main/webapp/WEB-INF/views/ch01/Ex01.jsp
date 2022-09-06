<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix='c'  %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
let dataArea = null;
window.onload = function(){
  let btn = document.getElementById("btn");
  dataArea = document.getElementById("dataArea");
  btn.onclick = function(){
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
       alert(xhr.responseText + ", readyState=" + xhr.readyState);
       if (xhr.readyState == 4 && xhr.status == 200) {
       	   displayAjaxData(xhr.responseText);
       }
	}	
	xhr.open("GET", "<c:url value='/singleString' />", true);
	xhr.send();
  }
}

function displayAjaxData(responseText){
	dataArea.innerHTML = "<font color='red' >" + responseText + "</font>";
}
</script>

</head>
<body>
<div align='center'>
   <h2>Ajax 練習01</h2>
   <h3>送回單一字串</h3>
   <hr>
   <p>
   <button id='btn'>Click Me</button>
   <hr>
   <div id='dataArea'>
            
   
   </div>
   
</div>
</body>
</html>