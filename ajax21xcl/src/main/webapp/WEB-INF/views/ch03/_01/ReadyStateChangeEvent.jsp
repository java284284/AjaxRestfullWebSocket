<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />
<meta charset="UTF-8">
<title>觀察XMLHttpRequest物件之readyState屬性的變化</title>
</head>
<body>
<div class='center'>
<h3>觀察readyState屬性的變化</h3>
<hr>
	<input type='Button' id='btnAsyn' value='送出非同步請求'>
	<hr>
	按下"送出非同步請求"按鈕後，瀏覽器向後端程式：ch01.Ch01Controller#helloAjaxOO()發出非同步請求。
	<hr>
	<font color='red'>必須開啟Chrome瀏覽器之『開發人員工具』，進入Console頁面，觀察readyState屬性的變化</font>
	<hr>
	<script>
		var btnAsyn = document.getElementById("btnAsyn");
		btnAsyn.onclick = function() {
			// 步驟一: 新建XMLHttpRequest物件
			var xhr = new XMLHttpRequest();
			// 步驟二: 經由AJAX提出HTTP請求
			if (xhr != null) {
				xhr.onreadystatechange = function(){
					console.log(xhr.readyState);   // 
				}
				xhr.open('GET', "<c:url value='/ch01/_01/HelloAjaxOO'  />", true);   // true: 表示非同步
				xhr.send();
			} else {
				div1.innerHTML = "<h3>您的瀏覽器不支援Ajax</h3>";
			}
		}
		
	</script>
	<a href="<c:url value='/ch03/' />">回前頁</a>
</div>    
</body>
</html>