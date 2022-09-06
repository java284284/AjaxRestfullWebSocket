<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />
<style>
div #canvas {
	width: 400px;
	height: 220px;
	border: 1px solid black;
}
</style>
<script type="text/JavaScript">
	var xhr = null;
	window.onload = function() {
		var obj = document.getElementById("canvas");
		obj.onmousemove = function() {
			xhr = new XMLHttpRequest();
			xhr.open("GET", "<c:url value='/ch03/_03/ShowTimeMillis' />", true);
			xhr.send();
			xhr.onreadystatechange = callback;
		}
	};
	function callback() {
		// 向伺服器提出的請求已經收到回應
		if (xhr.readyState === 4) {
			// 伺服器回應成功
			if (xhr.status === 200) {
				document.getElementById("result").innerHTML = "<font color='blue'>"
						+ xhr.responseText + "</font>";
			}
		}
	}
	function clearCoor() {
		document.getElementById("demo").innerHTML = "";
	}
</script>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />	
<meta charset="UTF-8">
<title>Mouse Over事件處理</title>
</head>
<body>
	<div align='center'>
		<h3>Mouse Move事件</h3>
		<hr>
		<font color='blue' size='5'> <label>將游標移過來</label>
		</font>
		<p />
		<div id='canvas' onmouseout="clearCoor()"></div>
		<p id='demo'></p>
		<div id='result'></div>
		<hr>
	<a href="<c:url value='/ch03/' />">回前頁</a>
	</div>


</body>
</html>