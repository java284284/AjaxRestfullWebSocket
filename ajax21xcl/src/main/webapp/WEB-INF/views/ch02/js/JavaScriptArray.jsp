<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />
<meta charset="UTF-8">
<title>Array</title>
<script>
window.onload=function(){
	var arr1 = new Array(100, 50, 25, 45, 80);
	var sum1 = 0;
	for (var i = 0; i < arr1.length; i++) {
		sum1 += arr1[i];
	}
	var div1 = document.getElementById("dataArea1");
	var tab1 = "<table border='1'>";
	for (var i = 0; i < arr1.length; i++) {
		tab1 += "<tr><td  style='text-align: right; width: 124px;'>" + arr1[i]
				+ "&nbsp;&nbsp;</td></tr>";
	}
	tab1 += "<tr><td align='center'>" + "總和:" + sum1 + "</td></tr>";
	tab1 += "</table>";
	div1.innerHTML = tab1;
}	
</script>
</head>
<body>
	<div align='center'>
		<h3>JavaScript 陣列處理</h3>
		<hr>
		<div id='dataArea1' style='height: 180px;'></div>
		<hr>
		<a href="<c:url value='/ch02/' />">回前頁</a>
	</div>
</body>
</html>