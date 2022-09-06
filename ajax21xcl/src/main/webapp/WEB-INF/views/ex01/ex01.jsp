<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>第一個練習</title>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />
<script>
window.onload = function(){
	let btn01 = document.getElementById("btn01");
	let btn02 = document.getElementById("btn02");
	let btn03 = document.getElementById("btn03");
	let bookId = 2;
	let dataArea = document.getElementById("dataArea");

	btn03.onclick = function(){
        let xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function(){
		   if (xhr.readyState == 4 && xhr.status == 200) {
                 displayData03(xhr.responseText);
		   }
        }
		xhr.open("GET", "<c:url value='/ch04/_03/allBooks.json' />", true);
        xhr.send(); 
    }
	
	btn02.onclick = function(){
        let xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function(){
		   if (xhr.readyState == 4 && xhr.status == 200) {
                 displayData02(xhr.responseText);
		   }
        }
		xhr.open("GET", "<c:url value='/ch04/_03/singleBook.json' />?bookId=" + bookId , true);
        xhr.send(); 
    }
	
    btn01.onclick = function(){
        let xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function(){
		   if (xhr.readyState == 4 && xhr.status == 200) {
                 displayData01(xhr.responseText);
		   }
        }
		xhr.open("GET", "<c:url value='/ch03/_03/showLocalTime' />", true);
        xhr.send(); 
    }
}

function displayData03(data) {
	console.log(data);  
	var bookArray = JSON.parse(data);
	var content = "<table border='1'><tr><th>書名</th><th>作者</th><th>價格</th>"
		        + "<th>出版社</th><th>折扣</th><th>封面1</th><th>封面2</th></tr>";
        for(n=0; n < bookArray.length; n++){
        	var book = bookArray[n];
			var url = "<c:url value='/ch04/_03/getBookImage' />?no=" + book.bookId ; 
		    console.log("url=" + url);
			       
			content += "<tr>" +
			           "<td>" + book.title + "</td>" +
			           "<td>" + book.author + "</td>" +
			           "<td>" + book.price + "</td>" +
			           "<td>" + book.publisherBean.name + "</td>" +
			           "<td>" + book.discount + "</td>" +
			           "<td>" + "<img src='" + url + "'>" + "</td>" +
			           "<td>" + "<img src='" + book.dataUri  + "'></td>" +
			           "</tr>";         
	        }
			content += "</table>";        
	dataArea.innerHTML =  content;
}

function displayData02(data) {
	var book = JSON.parse(data);
	console.log(data);
	var content = "<table border='1'><tr><th>書名</th><th>作者</th><th>價格</th>"
		        + "<th>出版社</th><th>折扣</th><th>封面1</th><th>封面2</th></tr>";

		var url = "<c:url value='/ch04/_03/getBookImage' />?no=" + book.bookId ; 
	    console.log("url=" + url);
		       
		content += "<tr>" +
		           "<td>" + book.title + "</td>" +
		           "<td>" + book.author + "</td>" +
		           "<td>" + book.price + "</td>" +
		           "<td>" + book.publisherBean.name + "</td>" +
		           "<td>" + book.discount + "</td>" +
		           "<td>" + "<img src='" + url + "'>" + "</td>" +
		           "<td>" + "<img src='" + book.dataUri  + "'></td>" +
		           "</tr>";         

		content += "</table>";        
	dataArea.innerHTML =  content;
}


function displayData01(data) {
	dataArea.innerHTML = "<font color='red'>" + data + "</font>" ;
}
</script>
</head>
<body>
<div align='center'>
   <h3>練習一</h3>
   <hr>
   <button id='btn01'>回應為單一字串</button>
   <button id='btn02'>回應為單一物件</button>
   <button id='btn03'>回應為多個物件</button>
   <hr>
   <div id='dataArea'>
      &nbsp;
   </div>
   <hr>   
   
   <a href="<c:url value='/'  />">回前頁-B</a>
</div>
</body>
</html>