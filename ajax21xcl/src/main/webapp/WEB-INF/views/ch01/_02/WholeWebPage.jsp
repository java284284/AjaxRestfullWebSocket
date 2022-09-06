<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />
<style>
td {
	width: 48px; 
	text-align: center;
}
</style>
<meta charset="UTF-8">
<title>Hello JSP (holeWebPage.jsp)</title>
<script type="text/javascript">
window.onload=function(){
	var btn = document.getElementById("btn");
	var result = document.getElementById("result");
	btn.onclick=function(){
		result.innerHTML="<table border='3'>" + 	
		   "<tr><td>春</td><td width='40'>夏</td><td>秋</td><td>冬</td></tr>" + 
    	   "<tr><td>梅</td><td>蘭</td><td>竹</td><td>菊</td></tr>" + 
           "</table>";
	}
}
</script>
</head>
<body>
<div align='center'>
   <h3>送回完整的網頁</h3>  
   <hr>
    <table border='1'>
    	<tr><td>春</td><td width='40'>夏</td><td>秋</td><td>冬</td></tr>
    	<tr><td>梅</td><td>蘭</td><td>竹</td><td>菊</td></tr>
    </table>
	<hr>
	<div>
	<div id='result' style='height: 150px;' id='resp'>
	   &nbsp;
	</div>
	<hr>
	<button id='btn' style='font-size: 18px;'>植入部分網頁</button>
</div>
     
<p/>
<hr>
<a href="<c:url value='/ch01/' />">回前頁</a>
</div>
</body>
</html>  
