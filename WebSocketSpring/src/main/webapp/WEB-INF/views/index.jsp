<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/style.css' />" />
<meta charset="UTF-8">
<title>Spring Boot</title>

<script>
	
</script>

</head>
<body>
	<div align='center'>
		<h2>WebSocket 範例</h2>
		<hr>
		<table border="1" style='width: 60%;'>
			<tr height='36'>
				<td><a href="<c:url value='/index01' />">
				       1. 發送與接收訊息的低階API
					</a>
				</td>
				<td><a href="<c:url value='/index02' />">
				       2. SockJS
				    </a>
				</td>
			</tr>
			<tr height='36'>
				<td><a href="<c:url value='/index03' />">3. Spring Stomp
						連線1</a></td>
				<td><a href="<c:url value='/index05' />">4. Spring Stomp
						連線2</a></td>
			</tr>
			
		</table>
	</div>
</body>
</html>