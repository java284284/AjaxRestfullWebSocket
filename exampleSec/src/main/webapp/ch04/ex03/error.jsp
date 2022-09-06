<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"  import="java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='../../css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC</title>
</head>
<body>
<H1>MVC (Database)</h1>
<h3>新增資料至資料庫時，如有錯誤，以error.jsp來顯示本畫面</H3>
<Font color='red' >檢查您的輸入資料時，發現含有下列錯誤，請更正後重新提交</font>
<c:forEach var="e" items="${ErrorMsgKey}">
    <li>${ e }</li>
</c:forEach>
<br>
<p/>
<small>&lt;&lt;<a href="ch04_ex03_mvc.jsp">回輸入畫面</a>&gt;&gt;</small>
</body>
</html>