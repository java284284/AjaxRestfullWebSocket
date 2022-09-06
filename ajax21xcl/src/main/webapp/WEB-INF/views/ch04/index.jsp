<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />
<meta charset="UTF-8">
<title>Ajax 首頁</title>
</head>
<body>
<div align='center'>
<h2>JSON與資料庫存取</h2>
<hr>
</div>
<br>
<div style="text-align: center;">
<div style="display: inline-block; text-align: left">
	
<a href='_01/queryLottery' >1. 接收Server送回的JSON物件</a><br>
<a href='_02/register' >2. 輸入會員資料</a><br>
<a href='_03/allBooks.json' >3. 書籍的JSON格式資料</a><br>
<a href='_04/ShowAllBooksAjax' >4. 顯示所有書籍資料(JSON)</a><br>
<a href='_05/QueryBooksByPublisher' >5. 由出版社查書籍資料</a><br>
<a href='_06/QuerySingleBookAjax' >6. 發出Ajax請求查看單筆書籍資料</a><br>
<a href='_07/FileUpload' >7. 發出Ajax FileDataUrl</a><br>
</div>
</div>
<div class='center'>
<hr>
<a href="<c:url value='/' />">回前頁</a>
</div>
</body>
</html>