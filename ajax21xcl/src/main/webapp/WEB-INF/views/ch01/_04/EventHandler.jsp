<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />
<meta charset="UTF-8">
<title>event handling example</title>
</head>
<body>
<div align='center'>
<h3>事件處理範例</h3>
<hr>
<button onclick="triggerAlert();">Click事件處理範例</button>
<hr>  
<script>
	function triggerAlert() {
		alert('這是事件處理函示發出的訊息');
	}
</script>
    <a href="<c:url value='/ch01/' />">回前頁</a>
</div>    

</body>
</html>
