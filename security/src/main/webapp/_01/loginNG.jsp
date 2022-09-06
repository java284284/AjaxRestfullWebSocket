<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" 
      href="${pageContext.request.contextPath}/css/styles.css">
<meta charset="UTF-8">
<title>登入</title>
</head>
<body>
<%@ include file="/segments/header_sql.jsp" %>  
<div class='center'>
<h3>　系統登入(NG版)</h3>    
<form action="loginNG.do" method="post" >  
 帳號:<input type="text" name="userid" size='40' value='${param.userid}' />
 <br>　　<small><Font color='red' >${ErrorMsgKey.AccountEmptyError}</Font></small>
 <br/><br/>  
 密碼:<input type="text" name="password" size='40' value='${param.password}'  />
 <br>　　<small><Font color='red'>${ErrorMsgKey.PasswordEmptyError}</Font></small>
 <br/>
 　　<small><Font color='red'>${ErrorMsgKey.LoginError}</Font></small>
 <br/>
 <br/>
　<input type="submit" value="登入"/>
 <br/>    
 <br/>
<hr>
<c:choose>
<c:when test="${dbtype eq 'mysql'}">
使用資料庫  :<input type='radio' name='dbtype' value='mysql' checked='checked'>MySQL &nbsp;&nbsp;&nbsp;   
           <input type='radio' name='dbtype' value='sqlserver'>SQL Server&nbsp;&nbsp;&nbsp;
</c:when>         
<c:otherwise>
使用資料庫  :<input type='radio' name='dbtype' value='mysql'>MySQL &nbsp;&nbsp;&nbsp;   
           <input type='radio' name='dbtype' value='sqlserver' checked='checked'>SQL Server&nbsp;&nbsp;&nbsp;
</c:otherwise>
</c:choose>
</form>  
</div>
</body>
</html>