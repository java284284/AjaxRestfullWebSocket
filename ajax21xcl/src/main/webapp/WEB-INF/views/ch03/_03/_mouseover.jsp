<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />
<script type="text/JavaScript">
var xhr = null;
window.onload = function() {
	var star4 = document.getElementById("fourStars"); 
	var star5 = document.getElementById("fiveStars");
	var resp = document.getElementById("resp"); 
	star4.onmouseover = function() {
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if (xhr.readyState === 4) {
				// 伺服器回應成功
				if (xhr.status === 200) {
					// 收到伺服器的回應
					resp.innerHTML = "<font color='red'>" + xhr.responseText + "</font>";
				}
			}	
		};   
		xhr.open("GET", "<c:url value='/ch03/_03/Lottery?type=4' />", true);
		xhr.send();
	}
	star5.onmouseover = function() {
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if (xhr.readyState === 4) {
				// 伺服器回應成功
				if (xhr.status === 200) {
					// 收到伺服器的回應
					resp.innerHTML = "<font color='red'>" + xhr.responseText + "</font>";
				}
			}	
		};
		xhr.open("GET", "<c:url value='/ch03/_03/Lottery?type=6' />", true);
		xhr.send();
	}
};

</script>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />
<meta charset="UTF-8">
<title>處理</title>
</head>
<body>
<div class='center'>
<h3>Mouse Over事件</h3>
<hr>
<font color='blue' size='4'>
<label id="showTime" style='font-weight: bold'>將游標移到下列兩個標籤的上方</label>
</font>
<p/>
<table border='1'>
  <tr>
	<td width='180' height='52'>
		<label id="fourStars" style='font-weight: bold; color: #F00;'>四星彩</label>
	</td>
	<td width='180' height='52'>
		<label id="fiveStars" style='font-weight: bold; color: #F00;'>大樂透</label>
	</td>
  </tr>
</table>
<hr>
<div id='resp' style='height:100px; line-height: 80px;'></div>
<small>
搭配的Server端程式為ch03.Ch03Controller#lottery()
</small>
<hr>
<a href="<c:url value='/ch03/' />">回前頁</a>
</div>

</body>
</html>