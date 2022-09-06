<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />"
	type="text/css" />
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.onload = function() {
		btn03.onclick = function() {
			let xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					dataArea.innerHTML = processAllBooks(xhr.responseText);
				}
			}

			xhr.open("GET", "<c:url value='/findAllBooks' />");
			xhr.send();
		}

		btn02.onclick = function() {
			let xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					dataArea.innerHTML = processBook(xhr.responseText);
				}
			}

			xhr.open("GET", "<c:url value='/findBookById' />?id=5");
			xhr.send();
		}
		btn01.onclick = function() {
			let xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					//alert(xhr.responseText);
					dataArea.innerHTML = "<font color='red'>"
							+ xhr.responseText + "</font>";
				}
			}

			xhr.open("GET", "<c:url value='/ch01/_01/HelloAjaxOO' />");
			xhr.send();
		}
		function processAllBooks(jsonData) {
			console.log(jsonData);
			let bookArray = JSON.parse(jsonData);
			let segment = "<table border='1'>";
			segment += "<tr><th>編號</th><th>書名</th><th>作者</th>"
					+ "<th>價格</th><th>折扣</th><th>圖片</th></tr>";
					
			for(i = 0; i < bookArray.length ; i++){
				let book = bookArray[i];
				segment += "<tr><td>" + book.bookId + " </td><td>" + book.title
					+ "</td>" + "<td>" + book.author + "</td><td>" + book.price
					+ "</td>" + "<td>" + book.discount
					+ "</td><td><img src='" + book.dataUri  + "'></td>"
					+ "</tr>";
			}		
			segment += "</table>";
			return segment;
		}

		function processBook(jsonData) {

			let book = JSON.parse(jsonData);
			let segment = "<table border='1'>";
			segment += "<tr><th>編號</th><th>書名</th><th>作者</th>"
					+ "<th>價格</th><th>折扣</th><th>圖片</th></tr>";
			segment += "<tr><td>" + book.bookId + " </td><td>" + book.title
					+ "</td>" + "<td>" + book.author + "</td><td>" + book.price
					+ "</td>" + "<td>" + book.discount
					+ "</td><td><img src='" + book.dataUri  + "'></td>"
					+ "</tr>";
			segment += "</table>";
			return segment;
		}
	}
</script>
</head>
<body>
	<div align='center'>
		<h2>Ajax練習</h2>
		<hr>
		<button id='btn01'>回應為單一字串</button>
		<button id='btn02'>回應為單一物件</button>
		<button id='btn03'>回應為多個物件</button>
		<hr>
		<div id='dataArea'>&nbsp;</div>
		<hr>

		<a href="<c:url value='/'  />">回前頁</a>

	</div>



</body>
</html>