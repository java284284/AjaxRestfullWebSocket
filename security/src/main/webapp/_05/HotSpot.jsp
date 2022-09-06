<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HotSpot</title>
</head>
<body>
<div class='center'>
<h1>反射型</h1>
本日神奇寶貝的熱點如下:<br>
北投市場<br>
北投公園<br>
北投國小<br>
北投國中<br>
<c:out value='${param.x}'  escapeXml='false' /><br>
</div>
</body>
</html>