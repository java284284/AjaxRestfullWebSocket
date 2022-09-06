<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<link  rel='stylesheet' href="<c:url value='/css/style.css' />" />
<meta charset="UTF-8">
<title>Spring Boot</title>
<script>
let contextPath = '${contextPath}';
let sock = null;
let timer = null;
let messageArea = null;
window.onload = function(){
  let btnStart = document.getElementById("btnStart"); 
  let btnEnd = document.getElementById("btnEnd"); 
  let url = "ws://" + window.location.host + contextPath + '/macro' ;
  //  console.log('window.location.host=' + window.location.host);     
  btnEnd.disabled = true;
  messageArea = document.getElementById("messageArea"); 
	
  btnStart.addEventListener('click', function(){
     sock = new WebSocket(url);
     btnEnd.disabled = false;
     btnStart.disabled = true;
     sock.onopen = function (){
   	    console.log('開啟WebSocket連線');
   	    messageArea.value += '開啟WebSocket連線\n';
   	    sayMarco();
     }
     
     sock.onmessage = function(e){
   	    console.log('收到訊息', e.data);
   	    messageArea.value += '收到訊息:' + e.data + "\n";
   	    timer = setTimeout(function(){sayMarco(); }, 2000)
     }
   	
     sock.onclose = function (){
    	clearTimeout(timer);
   	    console.log('關閉WebSocket連線');
   	    messageArea.value += '關閉WebSocket連線\n';
     }
     
  });
  
  btnEnd.addEventListener('click', function(){
 	     sock.close();
	     btnEnd.disabled = true;
	     btnStart.disabled = false;
	  });
  
}

function sayMarco(){
   console.log('傳送訊息...');
   sock.send('Hello，你好');
}

function clearText(){
	messageArea.value = '';
}

</script>

</head>
<body>
<div align='center'>
    <h2>初等Spring WebSocket用法</h2>
    <hr>
    <button id='btnStart'>開始</button>&nbsp;&nbsp; 
    <button id='btnEnd'>結束</button>
    <hr>
   <table border="1" style='width:60%;'>
     <tr>
        <td>
            <textarea id="messageArea" style='width:99%; height: 250px; font-size:16px; color:blue;'></textarea>
        </td>
     </tr>
     <tr>   
        <td align='center'>
           <input type="button" value="清除訊息" onclick="clearText();">
        </td>
   </tr>
</table>
<a href="<c:url value='/' />">回前頁</a>
</div>
</body>
</html>