<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />	
<meta charset="UTF-8">
<title>Ajax 首頁</title>
</head>
<body>
	<div class='center'>
		<h2>預備工作</h2>
	<div style="text-align: center;">
		<div style="display: inline-block; text-align: left; height: 200px;">
			<a href="<c:url value='/ch02/event/focus_blur' />">1. onfocus, onblur 事件</a><br> 
			<a href="<c:url value='/ch02/event/onchange' />">2. change 事件</a><br> 
			<a href="<c:url value='/ch02/event/keypress' />">3. keypress 事件</a><br> 
			<a href="<c:url value='/ch02/event/keyup' />">4. keyup 事件</a><br> 
			<a href="<c:url value='/ch02/js/JavaScriptArray' />">5. JavaScript陣列</a><br> 
			<a href="<c:url value='/ch02/js/JavaScriptObject' />">6. JavaScript物件</a><br>
		</div>
	</div>
	<a href="<c:url value='/' />">回前頁</a>
	</div>
</body>
</html>