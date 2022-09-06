<%@ page session="false" pageEncoding="UTF-8" errorPage="error/ExceptionPage.jsp" %>
<%-- This page will cause an "divide by zero" exeception --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>

<HEAD>
<link rel='stylesheet' href='../css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<TITLE>本網頁會包含其他的網頁片段</TITLE>
</HEAD>
<c:set target='${pageContext.request}' property='characterEncoding' value='utf-8' />
<body>
<table style='width:600px;' border='1'>
<tr><td>
<c:import url="ch03_07_heading.jsp" >
   <c:param name='visitor' value='呂惠芳' />
   <c:param name='times' value='150' />
</c:import>
</td></tr>
<tr height="300"><td>
<h1>本網頁會包含其他的網頁片段</h1>
包含方式：<br>
&lt;c:import url="ch03_07_heading.jsp" /&gt;<br>
&lt;c:import url="ch03_07_footing.jsp" /&gt;<br>
</td></tr>
<tr><td>

<c:import  url="ch03_07_footing.jsp" />
</td></tr>
</table>
<jsp:include page="/commons/previousPage.jsp" />
</body>