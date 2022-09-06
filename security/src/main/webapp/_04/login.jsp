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
<%@ include file="/segments/header_xss.jsp" %>  
<div class='center'>
<h3>　系統登入(XSS攻擊)</h3>    
<form action="login.do" method="post" >  
 帳號:<input type="text" name="userid"  size='40'  value='${param.userid}' />
 <br>　　<small><Font color='red' >${ErrorMsgKey.AccountEmptyError}</Font></small>
 <br/><br/>  
 密碼:<input type="text" name="password"  size='40'   value='${param.password}'  />
 <br>　　<small><Font color='red' >${ErrorMsgKey.PasswordEmptyError}</Font></small>
 <br/>
 　　<small><Font color='red' >${ErrorMsgKey.LoginError}</Font></small>
 <br/>
 <br/>    
　<input type="submit" value="登入"/> 
 <br/>    
 <br/>
<hr>
<jsp:include page="/segments/dbtype.jsp"  />
</form>  
</div>
</body>
</html>