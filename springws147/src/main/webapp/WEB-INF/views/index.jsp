<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WebSocket</title>
</head>
<body>
<div align='center'>
   <h2> WebSocket 練習</h2>
<hr>
   
   <a href="<c:url value='/rest123' />" >查詢員工資料(JSON格式)</a>
<hr>
${now}
</div>
</body>
</html>