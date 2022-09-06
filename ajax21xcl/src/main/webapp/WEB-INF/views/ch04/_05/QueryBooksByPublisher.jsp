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
	請挑選出版社: 
	<select id='Publisher'></select>
	<hr>
	<a href="<c:url value='/ch04/' />">回前頁</a>
	<hr>
	<div id='detail'></div>
	<hr>
	<!-- 顯示書籍資料的區域 -->
	<div id='bookarea' style='height: 150px;' class='center'>
	</div>
	<script>
		var selectElement = document.getElementById('Publisher');  // 取出select標籤
		var bookarea = document.getElementById('bookarea');     // 取出書籍資料的div標籤
		var detail = document.getElementById('detail');     // 取出書籍資料的div標籤
		var xhr = new XMLHttpRequest();        	// 讀取書籍表格內的書籍資料
		var xhr2 = new XMLHttpRequest();		// 讀取單一書籍的資料
		// 存放所有出版社名稱與主鍵值，每一名稱與主鍵值放入一個陣列，將此陣列放入(push)陣列companyData中
		var companyData = [];						
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				
				var publishers = JSON.parse(xhr.responseText);
				for (var i = 0; i < publishers.length; i++) {
					// 每一本書的書名與主鍵值放入一個陣列
					var publisher = [ publishers[i].name, publishers[i].id ];
					// 在將此陣列放入(push)陣列companyData中
					companyData.push(publisher);
				}
		        // 將companyData內的資料全部移植到select標籤中
				for (var i = 0; i < companyData.length; i++) {
					var option = new Option(companyData[i][0], "" + companyData[i][1]);
					selectElement.options[selectElement.options.length] = option;
				}
			}
		}
		xhr.open("GET", "<c:url value='/ch04/_03/allPublishers.json' />", true);
		xhr.send();
		// 定義select標籤的change事件處理函數
		selectElement.onchange = function(){
			xhr2.onreadystatechange = function() {
				if (xhr2.readyState == 4 && xhr2.status == 200) {
					displayPageBooks(xhr2.responseText);
				}
			}
			//使用者挑選的書籍之主鍵值是存放在selectElement.options[selectElement.selectedIndex].value中
			var publisherId = selectElement.options[ selectElement.selectedIndex ].value;
			// 定義open方法
			xhr2.open("GET", "<c:url value='/ch04/_05/getBooksByPubllisher.json' />" + "?publisherId=" + publisherId, true);
			// 送出請求
			xhr2.send();
		}
		
		function displayPageBooks(responseText){
			var mapData = JSON.parse(responseText);
			var BookType = mapData.BookType;
			var companyName = mapData.companyName;
			var books = mapData.bookBeanList;
			var imageURL = "<c:url value='/ch04/_03/getBookImage' />";
			var content = "<table border='1'  bgcolor='#fbdb98'>";
			content += "<tr><th width='60'>編號</th><th width='400' >書名</th><th width='200'>作者</th>"
					   + "<th width='60' >價格</th><th width='90' >出版社</th><th>封面</th></tr>";
			for(var i=0; i < books.length; i++){
				content += "<tr><td align='center'>" + books[i].bookId + "</td>" + 
				           "<td >" + books[i].title + "</td>" +
				           "<td>" + books[i].author + "</td>" +
				           "<td align='right'>" + books[i].price + "</td>" +
				           "<td align='center'>" + books[i].publisherBean.name.substring(0, 2) + "</td>" +
				           "<td><img  width='40' height='48' " +   
				           " src='" + imageURL + "?no=" + books[i].bookId + "'></td></tr>";
			}
			content += "</table>";
			var divs = document.getElementById("somedivS");
			bookarea.innerHTML = content;
			detail.innerHTML = companyName.substring(0,2) + "出版社目前共有" + BookType + "種書籍";
		}		
		
	</script>
</div>
</body>
</html>