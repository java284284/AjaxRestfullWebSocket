<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>keyup Event</title>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />
<script>
function keyup(val) {
	var data = document.getElementById("reflect");
	data.innerHTML = "輸入的訊息: <font color='red'>" + val + "</font>";
}
</script>	
</head>
<body>
	<div align='center'>
		<h3>keyup事件</h3>
		<hr>
		 <label>請輸入資料</label><p>
		留言: <input type="text" name="txt" value="" onkeyup="keyup(this.value)">
		<p />
		<div id='reflect' style='height: 64px;'>&nbsp;</div>
		<hr>
		<a href="<c:url value='/ch02/' />">回前頁</a>
	</div>
</body>
</html>