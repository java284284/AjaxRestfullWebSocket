<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value='/js/jquery-1.12.2.min.js' />"></script>
<script>  
	window.onload = function() {
		var btn = document.getElementById("clickmeS"); // 『Click Me(JavaScript)』按鈕的事件處理函數
		btn.onclick = function() {
			var xhr = new XMLHttpRequest();
			xhr.open("GET", "<c:url value='/ch04/_03/allBooks.json' />", true);
			
			              
			xhr.send();
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					var content = "<table border='1'>";
					content += "<tr><th>編號</th><th>書名</th><th>作者</th><th>價格</th>" 
							 + "<th>出版社</th><th>封面</th></tr>";
					var books = JSON.parse(xhr.responseText);
					var imageURL = "<c:url value='/ch04/_03/getBookImage' />";
					for (var i = 0; i < books.length; i++) {
						content += "<tr><td align='center'>" + books[i].bookId + "</td>" 
								+ "<td>" + books[i].title + "</td>"
								+ "<td>" + books[i].author + "</td>"
								+ "<td align='right'>" + books[i].price + "</td>" 
								+ "<td align='center'>"	+ books[i].publisherBean.name.substring(0, 2)
								+ "</td>" + "<td><img  width='40' height='48' "
								+ " src='" + imageURL + "?no="  
								+ books[i].bookId + "'></td></tr>";
						
					}
					content += "</table>";
					var divs = document.getElementById("somedivS");
					divs.innerHTML = content;
				}
			}
		}
	}
	$(document).ready(
			function() {
			$('#clickmeQ').click(
				function() {
				    $.getJSON("<c:url value='/ch04/_03/allBooks.json' />",
						function(categoriesJson) {  
						$("#somedivS").empty();
						var $table = $('<table border="1">')
							.appendTo($('#somedivS'))
							.append("<tr><th>編號</th><th>書名</th><th>作者</th><th>價格</th><th>出版社</th><th>封面</th></tr>");
						$("#somedivS").append($table)
						     $.each(categoriesJson,
				             function(index, element) {
								$('<tr>').appendTo($table)
								.append($('<td align="center">').text(element.bookId))
								.append($('<td>').text(element.title))
								.append($('<td>').text(element.author + "(JQuery版)"))
								.append($('<td align="right">').text(element.price))
								.append($('<td align="center">').text(element.publisherBean.name.substring(0, 2)))
								.append("<td><img src='" + "<c:url value='/ch04/_03/getBookImage' />" + "?no=" + element.bookId + "'></td>")
								
		                           ;    
							  });
						});
					});
					});
	
</script>
</head>
<body>
	<div align='center'>
		<h3>顯示所有書籍資料(JSON)</h3>
		<hr>
		
		<p />
		<button id='clickmeS'>Click Me(JavaScript)</button>
		<button id='clickmeQ'>Click Me(JQuery)</button>
		<hr>
		<div id='somedivS'></div>
		<hr>
		<a href="<c:url value='/ch04/' />">回前頁</a>
	</div>
</body>
</html>