<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />
<meta charset="UTF-8">
<script>
var customer = new  Object(); 
customer.name = "張君雅";
customer.address = "新北市板橋區";
var product = {
	   "name": "鉛筆",  
	   "price": 15.5, 
	   "quantity": 300       
};
</script>
<title>Array</title>
</head>
<body>
<div align='center'>
<h3>JavaScript 物件處理</h3>
<hr>
<div id='dataArea1'></div>
<hr>
<div id='dataArea2'></div>
<script>
   var div1 = document.getElementById("dataArea1");
   var div2 = document.getElementById("dataArea2");
   var tab1 = "<table border='1'><tr><th>姓名</th><th>地址</th></tr>" + 
              "<tr><td>" + customer.name +"</td><td>" + customer.address + "</td></tr>" +
              "</table>" ;
   var tab2 = "<table border='1'><tr><th>產品名稱</th><th>價格</th><th>數量</th></tr>" + 
              "<tr><td>" + product.name + "</td><td>" + product.price  + "</td><td>" 
              + product.quantity + "</td></tr>" + "</table>" ;              
   div1.innerHTML=tab1;
   div2.innerHTML=tab2;
</script>
<hr>
<a href="<c:url value='/ch02/' />">回前頁</a>
</div>
</body>
</html>