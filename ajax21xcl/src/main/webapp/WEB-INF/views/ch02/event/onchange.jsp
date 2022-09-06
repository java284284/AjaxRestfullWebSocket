<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Event</title>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />
</head>
<script>
	function valueChanged(val) {
		var data = document.getElementById("reflect");
		data.innerHTML = "輸入的訊息: <font color='red'>" + val + "</font>";
	}
</script>
<body>
<div class='center'>
<h3>onchange事件</h3>
<hr> 
	<label>請輸入資料</label><p>
           標題: <input type="text" name="title" value="" onchange="valueChanged(this.value)"><br><br>
           留言: <input type="text" name="msg" value="" onchange="valueChanged(this.value)"><br><br>
    <p/>
    <div id='reflect' style='height: 80px;'>
      	&nbsp;
    </div>
<hr>
<a href="<c:url value='/ch02/' />">回前頁</a>
</div>
</body>
</html>