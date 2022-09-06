<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />
<meta charset="UTF-8">
<title>查詢單筆書籍資料</title>
</head>
<body>
<div class='center'>
	請挑選書籍: 
	<select id='bookNo'></select>
	<hr>
	<!-- 顯示書籍資料的區域 -->
	<div id='bookarea' style='height: 150px;' class='center'>
	</div>
	<script>
		var selectElement = document.getElementById('bookNo');  // 取出select標籤
		var bookarea = document.getElementById('bookarea');     // 取出書籍資料的div標籤
		var xhr = new XMLHttpRequest();        	// 讀取書籍表格內的書籍資料
		var xhr2 = new XMLHttpRequest();		// 讀取單一書籍的資料
		// 存放所有書籍資料的書名與主鍵值，每一本書的書名與主鍵值放入一個陣列，在將此陣列放入(push)陣列bookData中
		var bookData = [];						
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var books = JSON.parse(xhr.responseText);
				for (var i = 0; i < books.length; i++) {
					// 每一本書的書名與主鍵值放入一個陣列
					var book = [ books[i].title, books[i].bookId ];
					// 在將此陣列放入(push)陣列bookData中
					bookData.push(book);
				}
		        // 將bookData內的資料全部移植到select標籤中
				for (var i = 0; i < bookData.length; i++) {
					var option = new Option(bookData[i][0], "" + bookData[i][1]);
					selectElement.options[selectElement.options.length] = option;
				}
			}
		}
		xhr.open("GET", "<c:url value='/ch04/_03/allBooks.json' />", true);
		xhr.send();
		// 定義select標籤的change事件處理函數
		selectElement.onchange = function(){
			xhr2.onreadystatechange = function() {
				if (xhr2.readyState == 4 && xhr2.status == 200) {
					var singleBook = JSON.parse(xhr2.responseText);
					displayPageBooks(singleBook);
				}
			}
			//使用者挑選的書籍之主鍵值是存放在
			//selectElement.options[ selectElement.selectedIndex ].value中
			var bookId = selectElement.options[ selectElement.selectedIndex ].value;
			// 定義open方法
			xhr2.open("GET", "<c:url value='/ch04/_03/singleBook.json' />" 
							+ "?bookId=" + bookId, true);
			// 送出請求
			xhr2.send();
		}
		
		function displayPageBooks(singleBook){
			var content = "<table border='1'  bgcolor='#fbdb98'>";
			var imageURL = "<c:url value='/ch04/_03/getBookImage' />";
			content += "<tr><td width='80'>書名</td><td width='380'>" + singleBook.title + "</td>";
			content += "<td rowspan='4'><img width='80' height='120' src='" + imageURL  + "?no=" + singleBook.bookId + "'></td></tr>";
			content += "<tr><td>作者</td><td>" + singleBook.author + "</td></tr>";						
			content += "<tr><td>價格</td><td>" + singleBook.price + "</td></tr>";
			content += "<tr><td>ID</td><td>" + singleBook.bookId + "</td></tr>";
			content += "</table>";
			bookarea.innerHTML = content;
		}		
		
	</script>
	<hr>
	<a href="<c:url value='/ch04/' />">回前頁</a>
	</div>
	
</body>
</html>