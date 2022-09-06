<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html >
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />
<script>
window.onload = function(){
 	var showmsg = document.getElementById("result");
	var btn  = document.getElementById("btn");
	var img1 = document.getElementById("img1");
	btn.onclick = function(){
		showmsg.innerHTML = "";   		// 清除訊息區   
		xhr = new XMLHttpRequest();		// 建立XMLHttpRequest物件
		xhr.open("GET", "<c:url value='/ch03/_04/LongRunController' />", true);
		xhr.send();						// 送出非同步請求
	 	img1.style.display = "inline";
		xhr.onreadystatechange = function() {
			// 向伺服器提出的請求已經收到回應
			if (xhr.readyState === 4) {
				// 伺服器回應成功
				if (xhr.status === 200) {
					showmsg.innerHTML = "<font color='red'>"
							+ xhr.responseText  + "</font>";
				} else {
					alert("error, " + xhr.status);
				} 
				img1.style.display = "none";
			} 
		}
	}
}
</script>
<meta charset="UTF-8">
<title>展示用</title>
</head>
<body>
<div align='center'>
<h3>長時間執行程式</h3>
<hr>
<input id='btn'  type="button"  value="開始執行程式(五秒鐘)">

<hr>
<div style="height:50px; line-height: 50px;" >
<!--工作尚未開始時應該隱藏<img>標籤==> style="display:none" -->
<img id="img1" src="<c:url value='/images/ajax-loader.gif' />" style="display:none;">
</div>           
<hr>
<div id='result' style="height:50px;" >
</div>
<hr>
<small>
搭配的Server端程式為ch03.Ch03Controller#longRun()<br>
</small><br>
<a href="<c:url value='/ch03/' />">回前頁</a>
</div>
</body>
</html>