<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head> 
<link rel='stylesheet' href="<c:url value='/css/style.css' />" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC</title>
</head>   
<body>
	<h2 style="text-align:center">Spring MVC 範例</h2>
	<h3 style="text-align:center">新增、刪除、修改、查詢</h3>
	<hr/>
	<div style="text-align:center">
	<a href="<c:url value='/crm/showAllMembers' />">處理會員資料(有圖)</a><br><br>
	</div>
</body>
</html>