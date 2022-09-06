<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />
<meta charset="UTF-8">
<title>當Server端程式有錯誤時</title>
</head>
<body>
	<div class='center'>
		<h3>當Server端程式有錯誤時</h3>
		<hr>
		<input type='Button' id='btnServlet' value='送出請求'>
		<div id='resp'></div>
		<script>
			var btnServlet = document.getElementById("btnServlet");
			var resp = document.getElementById("resp");
			btnServlet.onclick = function() {
				// 步驟一: 新建XMLHttpRequest物件
				var xhr = new XMLHttpRequest();
				// 步驟二: 經由AJAX提出HTTP請求
				xhr.onreadystatechange = function() {
					// 步驟三: 處理伺服器送回的回應資料
					if (xhr.readyState == 4) {
						// 必須取消下面四行的註解，程式才能正常
						if (xhr.status == 200 ) {  
							resp.innerHTML = "<h3>" + xhr.responseText	+ "</h3>";
						} else {
						    resp.innerHTML = "<font color='red'>程式發生異常" +  xhr.statusText + "</font>";
						}
					}
				}
				xhr.open('GET', "<c:url value='/ch03/_02/withError' />", true); 
				xhr.send();
			}
		</script>
		<a style="position: relative; top: 150px;" href='<c:url value='/ch03/' />'>回前頁</a>
	</div>

</body>
</html>