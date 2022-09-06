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
<H1>MVC(EL+JSTL)</h1>
<h3>(進行Business Logic 運算, 以error.jsp來顯示本畫面)</H3>
<Font color='red' >檢查您的輸入資料時，發現含有下列錯誤，請更正後重新提交</font>
<c:forEach var="e" items="${ErrorMsgKey}">
    <li>${ e }</li>
</c:forEach>
<%--
    List<String> errorMsg = (List<String>) request.getAttribute("ErrorMsgKey");
    for (String e : errorMsg) {
	    out.println("<li>" + e);
    }
--%>
<BR><BR><HR><BR>
<CENTER>
<small>&lt;&lt;<a href="${header['referer']}">回前頁</a>&gt;&gt;</small>
</CENTER>
</body>
</html>