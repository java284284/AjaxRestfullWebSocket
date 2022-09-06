<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>	
<head>
<meta charset="UTF-8">
<title>測試用</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type='text/javascript'>
var amt = Math.floor(Math.random() * 5000) / 10.0; 
var url='http://localhost:8080/security/_04/orderInsert.do';
var obj = {
	id: 'X55001',
	amt: amt
};
$.post(url, obj);
</script>
</body>
</html>