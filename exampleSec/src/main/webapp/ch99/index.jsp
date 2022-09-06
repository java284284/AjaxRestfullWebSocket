<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' href='../css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello, Kitty</title>
</head>
<body>
	<font face="Verdana" size='-1'>
		<table border='5' borderColor="#0000FF" width='100%'>
		
			<tr height='36'>
				<th>相對於本文件所在目錄</th>
				<th>相對於文件根目錄</th>
				<th>絕對路徑</th>
			</tr>
			<tr>
				<td align='center'><a href='kitty.jpg'>凱蒂貓</a><br>
				<small> &lt;a href='kitty.jpg' &gt;</small></td>
				<td align='center'><a href='/example/ch99/kitty.jpg'>凱蒂貓</a><br>
				<small>&lt;a href='/example/ch99/kitty.jpg'&gt;</small></td>
				<td align='center'><a
					href='http://localhost:8080/example/ch99/kitty.jpg'>凱蒂貓</a><br>
					<small>&lt;a
						href='http://localhost:8080/example/ch99/kitty.jpg'&gt;</small></td>
			</tr>
			<tr>
				<td align='center'><a href='../images/snoopy.jpg'>史奴比</a><br>
				<small> &lt;a href='../images/snoopy.jpg' &gt;</small></td>
				<td align='center'><a href='/example/images/snoopy.jpg'>史奴比</a><br>
                <small> &lt;a href='/example/images/snoopy.jpg' &gt;</small></td>
				<td align='center'><a href='http://localhost:8080/example/images/snoopy.jpg'>史奴比</a><br>
				<small> &lt;a href='http://localhost:8080/example/images/snoopy.jpg' &gt;</small></td>
			</tr>
			<tr>
				<td align='center'>
					<form action="../ch02/ShowPictureServlet" method="GET">
						<input type="submit" value="美圖" /><br>
						<small> &lt;a href='../ch02/SPServlet' &gt;</small>
					</form>
				</td>
				<td align='center'>
					<form action="/example/ch02/ShowPictureServlet" method="GET">
						<input type="submit" value="美圖" /><br>
						<small> &lt;a href='/example/ch02/SPServlet' &gt;</small>
					</form>
				</td>
				<td align='center'>
					<form action="http://localhost:8080/example/ch02/ShowPictureServlet" method="GET">
						<input type="submit" value="美圖" /><br>
						<small> &lt;a href='http://localhost:8080/example/ch02/SPServlet' &gt;</small>
					</form>
				</td>
			</tr>
			
		</table>
	</font> 
	<br>
	<a href='browser.jsp'>瀏覽器如何提出請求</a>
	<hr>
<center>
<small>&lt;&lt;<a href="/example/ch02">回第二章首頁</a>&gt;&gt;</small>
<!-- 
<small>&lt;&lt;<a href="/${pageContext.servletContext.servletContextName}">回首頁</a>&gt;&gt;</small>
 -->
</center>
</body>
</html>