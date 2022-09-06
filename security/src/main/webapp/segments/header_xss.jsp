<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
<meta charset="UTF-8">
<title>首頁</title>
</head>
<body>
<div class='center'>
<div class='right'>${sessionScope.dbtype}</div>
<div>
<a href="${pageContext.request.contextPath}/_04/login.jsp">登入</a> |
<a href="${pageContext.request.contextPath}/_04/update.jsp">更新資料</a> |
<a href="${pageContext.request.contextPath}/_04/list.jsp">顯示資料</a> |
<a href="${pageContext.request.contextPath}/_04/showMessage.jsp">查看留言</a> |
<c:choose>
<c:when test="${not empty LoginOK}">
   <a href="${pageContext.request.contextPath}/_04/logout.jsp">登出</a>
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