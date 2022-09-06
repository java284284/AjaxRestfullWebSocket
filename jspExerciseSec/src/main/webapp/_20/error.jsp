<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html >

<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css'  type='text/css' />
<meta charset="UTF-8">
<title>登入頁面</title>
</head>
<body>
	<c:url var="url" value="/_20/logon.jsp"/>
    <h3>無效的帳號或密碼.</h3>
    <p>請輸入正確的帳號與密碼來使用此資源. <br> 按這裏<a href="${url}">再試一次</a></p>
</body>
</html>