<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		var mems = [ {
			"id" : "kitty123",
			"name" : "Mary",
			"score" : 3000
		}, {
			"id" : "micky456",
			"name" : "Jack",
			"score" : 4500
		}, {
			"id" : "snoopy789",
			"name" : "Lisa",
			"score" : 5000
		} ];

		for (var i = 0; i < mems.length; i++) {
			console.log("id=" + mems[i].id + ", name=" + mems[i].name
					+ ", score=" + mems[i].score);
		}
		
	</script>
</body>
</html>