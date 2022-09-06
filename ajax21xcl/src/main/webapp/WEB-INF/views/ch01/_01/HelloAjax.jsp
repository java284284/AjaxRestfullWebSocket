<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' 	href="<c:url value='/css/styles.css' />" type="text/css" />
<meta charset="UTF-8">
<title>Ajax範例: 同步請求</title>
</head>
<body>
	<div align='center'>
		<h3>同步請求</h3>
		<hr>
		瀏覽器送出請求後必須等待伺服器端程式送出回應，它才可以進行下一個工作
		<hr>
		<input type='Button' id='btnSendRequest' value='送出請求給後端程式並由它送回訊息'>
		<div style='height: 100px;' id='resp'>
			<h3>&nbsp;</h3>
		</div>
		<script>
			var btnSendRequest = document.getElementById("btnSendRequest");
			var div1 = document.getElementById("resp");
			btnSendRequest.onclick = function() {
				// ajax的同步請求
				// 步驟一: 新建XMLHttpRequest物件
				var xhr = new XMLHttpRequest();
				// 步驟二: 經由AJAX提出HTTP請求
				if (xhr != null) {
					xhr.open('GET', "<c:url value='/ch01/_01/HelloAjaxOO' />", false);
					xhr.send();
					// 步驟三: 處理伺服器送回的回應資料
					div1.innerHTML = "<h3>" + xhr.responseText + "</h3>";
				} else {
					div1.innerHTML = "<h3>您的瀏覽器不支援Ajax</h3>";
				}
			}
		</script>
		<hr>
		<small> 搭配的Server端程式為ch01.Ch01Controller#helloAjaxOO() </small>
		<hr>
		<a href="<c:url value='/ch01/' />">回前頁</a>
	</div>
</body>
</html>