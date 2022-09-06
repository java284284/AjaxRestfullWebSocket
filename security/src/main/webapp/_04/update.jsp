<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>
<c:if test="${empty LoginOK}">
    <c:set var='target' value='${pageContext.request.requestURI}' scope='session' />
    <c:redirect url="login.jsp"/>
</c:if>    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
<meta charset="UTF-8">
<title>資料更新</title>
</head>
<body>
<%@ include file="/segments/header_xss.jsp" %>
<div class='center'>
<h1>資料更新</h1>
<hr>
<form action='update.do' method='post'>
${LoginOK.custId}, 請更新下列資料<br/><br/>

電郵:<input type="text" name="email"  size='40'  value='${LoginOK.email}' />
 <br>　　<small><Font color='red' >${ErrorMsgKey.EmailEmptyError}</Font></small>
 <br/><br/>  
密碼:<input type="text" name="password"  size='40' value='${LoginOK.password}'  />

 <br>　　<small><Font color='red' >${ErrorMsgKey.PasswordEmptyError}</Font></small>
 <br/>
 　　<small><Font color='red' >${ErrorMsgKey.LoginError}</Font></small>
 <br/>
<input type="submit" value="更新"/>
<hr>
<%--
<jsp:include page="/segments/dbtype.jsp"  />
 --%>
</form>
</div>
</body>
</html>