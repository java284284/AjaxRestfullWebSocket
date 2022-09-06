<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Focus Event</title>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />	
<script type="text/javascript">
	function showForm() {
		var form = document.forms['form'];
		form.style.display = 'block';
		form.elements[0].focus();
	}
	function gotFocus(x) {
		document.getElementById(x).style.background = "yellow";
	}
	function lostFocus(x) {
		document.getElementById(x).style.background = 'white';
	}
</script>
</head>
<body>
	<div align='center'>
		<h3>onfocus/onblur事件</h3>
		<hr>
		<div style='height: 230px;'>
			<form style="display: none" name="form">
				<label>請輸入資料</label>
				<p>
					帳號: <input style="" id='account' name="account"
						onfocus="gotFocus (this.id)" onblur="lostFocus (this.id)">
				<p>
					姓名: <input style="" id='name' name="name"
						onfocus="gotFocus(this.id)" onblur="lostFocus (this.id)">
				<p>
					地址: <input style="" id='address' name="address"
						onfocus="gotFocus(this.id)" onblur="lostFocus (this.id)">
				<p>
			</form>
		</div>
		<input type="button" value="顯示表單" onclick="showForm()">
		<p>
		<hr>
		<a href="<c:url value='/ch02/' />">回前頁</a>
	</div>
</body>
</html>