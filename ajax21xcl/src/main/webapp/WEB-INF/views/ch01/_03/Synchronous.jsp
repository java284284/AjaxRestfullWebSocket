<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />
<meta charset="UTF-8">
<title>Ajax範例二: 說明『同步請求的缺點』</title>
<script>
window.onload=function(){
		var btnSync  = document.getElementById("btnSync");
		var btnAsync = document.getElementById("btnAsync");
		var div1     = document.getElementById("resp");
		btnSync.onclick = function() {
			// ajax的同步請求
			// 步驟一: 新建XMLHttpRequest物件
			var xhr = new XMLHttpRequest();
			// 步驟二: 經由AJAX提出HTTP請求
			if (xhr != null) {
				xhr.open('GET', "<c:url value='/ch01/_03/DelayedResponse' />", false);
				xhr.send();
				div1.innerHTML = "<h3>" +  xhr.responseText + "</h3>";
				// 步驟三: 處理伺服器送回的回應資料
			} else {
				div1.innerHTML = "<h3>您的瀏覽器不支援Ajax</h3>";
			}
		}
		btnAsync.onclick = function() {
			// ajax的非同步請求
			// 步驟一: 新建XMLHttpRequest物件
			var xhr = new XMLHttpRequest();
			// 步驟二: 經由AJAX提出HTTP請求
			if (xhr != null) {
				xhr.onreadystatechange=function(){
					if (xhr.readyState == 4 && xhr.status == 200){
						div1.innerHTML = "<h3>" +  xhr.responseText + "</h3>";	
					}
				}
				xhr.open('GET', "<c:url value='/ch01/_03/DelayedResponse' />", true);
				xhr.send();
				
				// 步驟三: 處理伺服器送回的回應資料
			} else {
				div1.innerHTML = "<h3>您的瀏覽器不支援Ajax</h3>";
			}
		}
}		
	</script>
</head>
<body>
<div class='center'>
<h3>同步請求與非同步請求的差別</h3>
 <hr>
    <b>同步請求的缺點:</b><p> 
    前端程式必須等待後端程式送回要求的資料，若後端程式需要較長的執行時間<p>
	<input type='Button' style="color:#0000FF;"
		onmouseover="this.style.color='#FF0000';" 
		onmouseout="this.style.color='#0000FF';" 
		id='btnAsync' 
		value='非同步請求，不需等候'>
	<input type='Button' style="color:#0000FF;"
		onmouseover="this.style.color='#FF0000';" 
		onmouseout="this.style.color='#0000FF';" 
		id='btnSync' 
		value='同步請求，需等候5秒'>		
	<hr>
	<div id='resp' style='height:60px; line-height:40px;'>
	&nbsp;  
	</div>
	
	<hr>
<small>
搭配的Server端程式為ch01.Ch01FindViewController#synchronous()與ch01.Ch01Controller#delay()
</small>
<hr>

    <a href="<c:url value='/ch01/' />">回前頁</a>
</div>    
</body>
</html>