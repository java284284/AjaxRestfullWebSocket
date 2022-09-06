<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>   	
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
<meta charset="UTF-8">
<title>登入</title>
</head>
<body>
<%@ include file="/segments/header_sql.jsp" %>
<br/>
<div class='center'>
<h1>SQL Injection</h1>

<c:if test='${ not empty LoginOK }' >
<h2>歡迎光臨，${LoginOK.custId}，${Code}版</h2>
</c:if>	
</div>	
</body>
</html>

