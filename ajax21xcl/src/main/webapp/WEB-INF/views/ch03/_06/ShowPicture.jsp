<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />
<script>
window.onload = function(){
   var btn = document.getElementById("btn");
   btn.onclick = function(){
	  var xhr = new XMLHttpRequest();
	  var img1 = document.getElementById("img1");
	  img1.style.display = "none";
	  xhr.onreadystatechange = function(){
		  if (xhr.readyState == 4 && xhr.status == 200){
			  // src屬性必須俱備下列格式:
	    	  // data:[MIME-TYPE];base64,[經由Base64編碼的非文字檔]
			  img1.src = xhr.responseText;
		  }
	  }
	  xhr.open("GET", "<c:url value='/ch03/_06/getPicture.do ' />", true);
	  xhr.send();
	  img1.style.display = "inline";
   }
 }
</script>
<meta charset="UTF-8">
<title>Show Picture</title>
</head>
<body>
<div align='center'>
<h3>非同步傳送圖片</h3>
<hr>
<img width='300' height='200' id='img1'>
<img src="<c:url value='/images/m12.jpg' />"  width='300' height='200'/>
<hr>
<button  id='btn' style='width:80px; height:40px' >看圖片</button>
<hr>
<div id='control_Flow' style="text-align:left">
<small>
按下"看圖片"按鈕後，瀏覽器向後端程式: ch03.Ch03Controller#getPicture()發出非同步請求，
該程式會隨機挑選ㄧ張圖片，取得該圖片檔的MIME型態後，並由java.util.Base64對圖片的內容以
Base64的方式編碼，然後依下列格式將資料寫回前端的程式：<br>
data:[圖檔的MIME型態];base64,[編碼後的資料]<br>

</small>
</div>
<hr>
<a href="<c:url value='/ch03' />">回前頁</a>
</div>
</body>
</html>