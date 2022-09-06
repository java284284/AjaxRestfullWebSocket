<%@ page contentType="text/html; charset=UTF-8" %>
<html>
	<head>
	    <link rel='stylesheet' href='../css/styles.css'  type="text/css" />
		<title>理解JSP的原理</title>
	</head>
	<body>
	    <h1>html表單</h1>
		<p> 請輸入顯示  Hello, World! 的次數:(預設值為 5)</p>
		<form method=get action="ch03_02_sayHello.jsp">
			請輸入次數<input type="text" name=times size="2" value="5" style="text-align:right;"><BR>
			<P>
			<input type=submit value="提交">
		</form>
	</body>
</html>