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
var url='http://localhost:8080/security/_04/orderSelect.do';
var url2='http://localhost:8080/security/_04/orderDelete.do';
$.getJSON(url, null, show);
function show(data){
	var firstKey = data[0].key;      // 第一筆訂單的key
	//alert(firstKey);
	//alert(JSON.stringify(data[0]));  // 顯示第一筆訂單
	var obj = {
		id: firstKey	
	}
	$.getJSON(url2, obj);
}
</script>
</body>
</html>