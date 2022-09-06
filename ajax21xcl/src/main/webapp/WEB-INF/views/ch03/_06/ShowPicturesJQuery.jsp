<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(document).ready(function(){

    $("#btn").click(function(){
    	$.get("getPicture.do", function (rawImageData) {
    		// src屬性必須俱備下列格式:
    	    // data:[MIME-TYPE];base64,[經由Base64編碼的非文字檔]
    	    //$("#target").attr("src","data:image/jpeg;base64," + rawImageData);
    		$("#target").attr("src", rawImageData);

    	});
    });
});
</script>
</head>
<body>
<div class='center'>
<h1>JQuery傳送圖片</h1>
<img id="target" src="" width='300' height='200'/>
<img id="target2" src="<c:url value='/images/m12.jpg' />"  width='300' height='200'/>
<hr>
<button  id='btn' style='width:80px; height:40px' >看圖片</button>
<!-- 
<img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAUA
AAAFCAYAAACNbyblAAAAHElEQVQI12P4//8/w38GIAXDIBKE0DHxgljNBAAO
9TXL0Y4OHwAAAABJRU5ErkJggg==" alt="Red dot" />
 -->
  
</div>
</body>
</html>

    