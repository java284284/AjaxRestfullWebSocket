<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='../css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>樂透名牌</title>
</head>
<body>
<h1>${title}</h1>
<h3> 
<font color='#FF0000' >
<c:forEach var="number"  items="${numberArray}" > 
   ${ number }&nbsp;
</c:forEach>
</font>
</h3>
<br/>
<p/>
<HR>
<CENTER>
  <small>&lt;&lt;<a href="${header['referer']}">再試一次</a>&gt;&gt;</small>
</CENTER>
</body>
</html>