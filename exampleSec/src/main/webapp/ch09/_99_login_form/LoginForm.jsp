<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HTML表單登錄</title>
</head>
<body>

	<form method=post action="j_security_check">
		<p>
			<span>使用者帳號:</span> <br /> 
			<input type="text" name="j_username">
		</p>
		<p>
			<span>密碼:</span> <br /> 
			<input type="password" name="j_password">
		</p>
		<p>
			<input type="submit" value="Login">
		</p>
	</form>


</body>
</html>   