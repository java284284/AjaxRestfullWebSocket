<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='../css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>10秒後自動更新畫面</title>
</head>
<body>
<%
   int  n = 10 ; 
   response.setHeader("Refresh", "" + n);  
   Date d = new Date();  
%>
您的瀏覽器將在 <%= n %> 秒後自動更新畫面<BR>
<%= d %>

<jsp:include page="/commons/previousPage.jsp" />
</body>
</html>