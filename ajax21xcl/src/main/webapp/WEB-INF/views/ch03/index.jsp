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
<div class='center'>
<h2>Ajax非同步請求</h2>
</div>
<div style="text-align: center;">
<div style="display: inline-block; text-align: left">
	
	
	
<a href="<c:url value='/ch03/_01/ReadyStateChangeEvent' />" >1. 觀察XMLHttpRequest物件之readyState屬性的變化</a><br>
<a href="<c:url value='/ch03/_02/ErrorProneAjax' />" >2. Error Prone Servlet</a><br>
<a href="<c:url value='/ch03/_03/ShowTime' />" >3. 完整的Ajax程式</a><br>
<%-- <a href="<c:url value='/ch03/_03/mouseover' />" >3. Ajax範例：MouseOver事件</a><br> --%>
<a href="<c:url value='/ch03/_04/longrun' />" >4. 長時間執行程式  </a><br>
<a href="<c:url value='/ch03/_05/citytime' />" >5. 查詢世界主要城市的時間  </a><br>
<a href="<c:url value='/ch03/_06/ShowPicture' />" >6. Ajax傳送圖片  </a><br>
</div>
</div>
<div class='center'>
<a href="<c:url value='/' />">回前頁</a>
</div>
</body>
</html>