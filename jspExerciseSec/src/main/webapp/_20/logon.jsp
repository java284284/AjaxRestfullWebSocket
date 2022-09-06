<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css'  type='text/css' />
<meta charset="UTF-8">
<style>
input[type=submit], input[type="reset"] { 
	width: 100px;
	height: 36px;
	font-size: 20px;
}

input[type=text] { 
	font-size: 28px;
}

</style>
<title>登入頁面</title>

</head>
<body>
	<h3>請登入</h3>
	<form action="j_security_check" method="post">
		<p>
			<strong>帳號: </strong> <input style='font-size: 28px;' type="text" name="j_username" size="25">
		<p>
		<p>
			<strong>密碼: </strong> <input style='font-size: 28px;' type="password" size="15"
				name="j_password">
		<p>
		<p>
			<input style='width:100px;' type="submit" value="Submit"> <input type="reset"
				value="Reset">
	</form>
</body>
</html>