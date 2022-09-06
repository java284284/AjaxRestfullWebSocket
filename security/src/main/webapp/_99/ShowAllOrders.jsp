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
	var n = 3;
	//alert(JSON.stringify(data));       // 顯示所有訂單
	//alert(JSON.stringify(data[0]));    // 顯示第一筆訂單
	// 顯示前n筆訂單
	var str = "";                        
	$.each(data, function(i, anOrder) {
	    str += "\n" + JSON.stringify(anOrder);
	    return i < n-1;
	});
	alert(str);
}
</script>
</body>
</html>