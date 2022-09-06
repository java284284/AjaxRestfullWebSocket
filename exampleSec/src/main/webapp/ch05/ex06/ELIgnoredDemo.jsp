<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="true" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='../../css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示忽略 JSP 文件中的 EL </title>
</head>
<body>
<h1>展示忽略 JSP 文件中的 EL </h1>
太空梭專用螺絲
料號:  ${1 + 2 }
<center>
<P/>
<a href='<%= request.getContextPath() %>/ch05'>回第五章首頁</a>
</CENTER>
</body>
</html>