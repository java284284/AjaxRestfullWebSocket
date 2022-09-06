<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css'  type='text/css' />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
<form method="POST" action="j_security_check">
 帳號: <input type="text" name="j_username"><p>
 密碼: <input type="password" name="j_password"><p>
<input type='submit'>  
</form>

</body>
</html>