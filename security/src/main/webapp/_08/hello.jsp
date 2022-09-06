<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>第一個JSP程式</title>
</head>
<body>
<%
    int times = (int)(Math.random() * 5) + 2;
	for(int n=0; n< times; n++){
		out.println("Hello, World, 大家好!<br>");
	}
%>
<p/>
<hr>
<div style='position:relative; top:100px;'>
<small>&lt;&lt;<a href="${pageContext.servletContext.contextPath}/index_security.jsp">回前頁</a>&gt;&gt;</small>
</div>
</body>
</html>