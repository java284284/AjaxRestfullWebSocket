<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css'  type='text/css' />
<title>Login Page</title>
</head>

<h2>請登入</h2>
<form action="${pageContext.request.contextPath}/j_security_check" method=post>
	<p>
		<strong>帳號: </strong> <input type="text" style="font-size: 16pt;"
			name="j_username" size="25">
	<p>
	<p>
		<strong>密碼: </strong> <input type="password" style="font-size: 16pt;"
			size="15" name="j_password">
	<p>
	<p>
		<input type="submit" value="Submit"> <input type="reset"
			value="Reset">
</form>
</html>