<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>測試用</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type='text/javascript'>
var url='http://localhost:8080/security/_04/orderSelect.do';
$.getJSON(url, null, show);
function show(data){
	alert(JSON.stringify(data));
	/*
	$.each(data, function(order, orderInfo){
		alert(orderInfo.key);	
	} )
	*/
	alert(data[0].key);
}
</script>
</body>
</html>