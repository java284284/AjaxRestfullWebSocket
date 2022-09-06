<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c'  uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />	
<meta charset="UTF-8">
<title>Ajax 首頁</title>
</head>    
<body>
	<div class='center'>
		<h2>同步與非同步</h2>
		<div style="text-align: center;">
			<div style="display: inline-block; text-align: left; height: 200px;">
				<a href="<c:url value='/ch01/_01/HelloAjax' />">1. 同步請求</a><br> 
				<a href="<c:url value='/ch01/_02/WholeWebPage' />">2. 送回完整的網頁</a><br> 
				<a href="<c:url value='/ch01/_03/Synchronous' />">3. 同步請求與非同步請求的差別</a><br>
				<a href="<c:url value='/ch01/_04/EventDriven' />">4. 事件處理函式</a><br>
			</div>
		</div>
		<a href="<c:url value='/' />">回前頁</a>
	</div>
</body>
</html>