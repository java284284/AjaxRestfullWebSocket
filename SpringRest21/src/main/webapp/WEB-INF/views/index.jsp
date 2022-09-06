<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" >
<meta charset="UTF-8">
<title>Ajax_REST</title>
</head>
<body>
<div align='center'>
<h2>RESTful Web Service</h2>
<hr>
</div>
<br>
<div style="text-align: center;">
<div style="display: inline-block; text-align: left">
	
<a href="<c:url value='/_01/getLottery' />" >1. 接收Server送回的JSON物件</a><br>
<a href="<c:url value='/insertMemberForm' />" >2. 輸入會員資料</a><br>
<a href="<c:url value='/members' />" >3. 檢視Server送回的JSON資料(生資料)</a><br>
<a href="<c:url value='/showAllMembersAjax' />" >4. 查詢、修改與刪除會員資料(Ajax)</a><br>
</div>
</div>
<hr>
<div class='center'>
<font color='red' size='-2'>DB:${sys.dbType}</font>
<hr>
</div>
</body>
</html>