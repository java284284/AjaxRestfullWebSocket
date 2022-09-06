<%@ page session="false" pageEncoding="UTF-8" errorPage="error/ExceptionPage.jsp" %>
<%-- This page will cause an "divide by zero" exeception --%>

<HTML>

<HEAD>
<link rel='stylesheet' href='../css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<TITLE>本網頁會包含其他的網頁片段</TITLE>
</HEAD>
  
<body>
<table style='width:600px;' border='1'>
<tr><td><%@ include file="ch03_07_heading.jsp" %></td></tr>
<tr height="300"><td>
<h1>本網頁會包含其他的網頁片段</h1>
包含方式：<br>
&lt;%@ include file="ch03_07_heading.jsp" %&gt;<br>
&lt;%@ include file="ch03_07_footing.jsp" %&gt;<br>
</td></tr>
<tr><td>

<%@ include file="ch03_07_footing.jsp" %>
</td></tr>
</table>
<jsp:include page="/commons/previousPage.jsp" />
</body>

</html>
