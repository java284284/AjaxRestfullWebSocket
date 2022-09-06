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
	var  data = {mems: 
         [
            {"id" : "kittyAAA", "name" : "Mindy", "score" : 300}, 
          	{"id" : "mickyBBB", "name" : "Jenifer", "score" : 450}, 
            {"id" : "snoopyCCC", "name" : "Leo", "score" : 500}
          ]};

		for (var i = 0; i < data.mems.length; i++) {
			console.log("id=" + data.mems[i].id 
					+ ", name=" + data.mems[i].name
					+ ", score=" + data.mems[i].score);
		}
		
	</script>
</body>
</html>