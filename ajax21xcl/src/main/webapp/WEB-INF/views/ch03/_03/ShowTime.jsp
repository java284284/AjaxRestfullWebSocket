<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />
<meta charset="UTF-8">
<title>完整的Ajax程式</title>
<script>
window.onload=function(){
	var btn = document.getElementById("btn");
	var div1 = document.getElementById("resp");
	btn.onclick = function() {
		// ajax的同步請求
		// 步驟一: 新建XMLHttpRequest物件
		var xhr = new XMLHttpRequest();
		// 步驟二: 經由AJAX提出HTTP請求
		if (xhr != null) {
			xhr.onreadystatechange = function(){
				if (xhr.readyState === 4) {
					// 伺服器回應成功
					if (xhr.status === 200) {
						// 收到伺服器的回應
						div1.innerHTML = "<font color='red'>" + xhr.responseText + "</font>";
					}
				}	
			}
			xhr.open('GET', "<c:url value='/ch03/_03/showLocalTime' />", true);
			xhr.send();
		} else {
			div1.innerHTML = "<h3>您的瀏覽器不支援Ajax</h3>";
		}
	}   
}	
</script>
</head>
<body>
<div class='center'>
<h3>完整的Ajax程式</h3>
<hr>
<input type='Button' id='btn' value='現在時間'>
<hr>
<div id='resp' style='height:100px; line-height: 80px;'></div>
<small>
<label style='color:#221172'><b>按下"現在時間"按鈕後，瀏覽器向後端程式 ch03.Ch03Controller#showLocalTime()發出非同步請求</b></label>
</small>
<hr>
<a href="<c:url value='/ch03/' />">回前頁</a>
</div>
</body>
</html>