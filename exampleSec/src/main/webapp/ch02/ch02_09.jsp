<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='../css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我們搬新家了</title>
</head>
<body>
<%
   int  n = 5 ;  
   response.setHeader("Refresh",  n +";URL=http://tw.yahoo.com");  
%>

我們搬新家了，您的瀏覽器將在 <%= n %> 秒後自動前往新網址<BR>

</body>
</html>