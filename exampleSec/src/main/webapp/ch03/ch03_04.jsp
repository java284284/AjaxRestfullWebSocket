<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='../css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP 註解</title>
</head>
<body>
<!--  This text is a html comment  -->
<h2>JSP網頁可以使用的 註解</h2>
<%--  這是JSP註解  --%>
<%
  int n = (int)(Math.random()*20) + 1  ; 
  if ( n > 10 )    // 這是Java註解
	  out.println("Hello, World, n=" + n);
  else 
	  out.println("大家好, n=" + n);
%>
<P/>
HTML註解 =&gt;<font color="blue"> &lt;!--  This text is a html comment  --&gt; </font><p/>
JSP註解 =&gt;<font color="red">&lt;%--  這是JSP註解  --%&gt;</font><p/>
Java註解 =&gt; <font color="brown"> // 這是Java註解</font>
<p/>
<jsp:include page="/commons/previousPage.jsp" />
</body>
</html>