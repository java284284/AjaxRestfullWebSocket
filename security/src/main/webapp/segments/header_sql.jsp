<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
<meta charset="UTF-8">
<title>SQL Injection首頁</title>
</head>
<body>
<div class='center'>
<div class='right'>${sessionScope.dbtype}</div>
<div>
<a href="${pageContext.request.contextPath}/_01/loginNG.jsp">登入 NG</a> |  
<a href="${pageContext.request.contextPath}/_02/loginOK.jsp">登入 OK</a> |
<c:choose>
<c:when test="${not empty LoginOK}">
   <a href="${pageContext.request.contextPath}/_03/logout.jsp">登出</a>
</c:when>
<c:otherwise>
   <a href="${pageContext.request.contextPath}/index.jsp">回首頁</a>
</c:otherwise>  
</c:choose>  
<hr>
　${sessionScope.sql}
<hr>
</div>
</div>
</body>
</html>