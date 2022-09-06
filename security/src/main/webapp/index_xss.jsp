<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>XSS攻擊</title>
</head>
<body>
<%@ include file="/segments/header_xss.jsp" %>

<div class='center'>
<h1>XSS攻擊</h1>
<h2>
<c:if test="${ not empty sessionScope.MessageInsertOK}">
  ${sessionScope.MessageInsertOK}
  <c:remove var="MessageInsertOK" scope="session" />
</c:if>
</h2>
<h2>
<c:if test="${not empty sessionScope.MessageLoginOK}">
  ${sessionScope.MessageLoginOK}
  <c:remove var="MessageLoginOK" scope="session" />
</c:if>
</h2>
<c:if test='${ not empty LoginOK }' >
<h2>${LoginOK.custId}</h2>
</c:if>	
</div>	
</body>
</html>