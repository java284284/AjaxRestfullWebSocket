<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c'  uri="http://java.sun.com/jsp/jstl/core"  %>    
<!DOCTYPE html>
<html>
<head> 
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />
<script type="text/JavaScript">
window.onload = function(){ 
	var btn = document.getElementById("btn");
	var btnJson = document.getElementById("btnJson");
	var result = document.getElementById("lotteryResult")
	
	btnJson.onclick = function(){
	    var name = document.getElementById("visitor").value;
	    var addr = document.getElementById("address").value;
	   	var xhr = new XMLHttpRequest();
	   	var visitor = {
			"visitor": name,
			"address": addr,
			"amount": 99
	   	}
	   	var jsonString = JSON.stringify(visitor);
	   	console.log("瀏覽器送出" + jsonString);
	   	xhr.open("POST", "<c:url value='/ch04/_01/GetLotteryJSON' />", true);
	   	xhr.setRequestHeader("Content-type", "application/json");
	   	xhr.send(jsonString);
	    	
	   	xhr.onreadystatechange = function() {
		// 向伺服器提出的請求已經收到回應
	        if (xhr.readyState === 4) {
	        // status: HTTP通訊協定的狀態碼伺服器，
	        // 200表示Server成功的處理請求
	            if (xhr.status === 200) {
	          	// getResponseHeader: 取得回應內容的MIME Type
	                 var type = xhr.getResponseHeader("Content-Type");   
	                 // 判斷回應類型，這裡使用 JSON
	                 if (type.indexOf("application/json") === 0) {               
	                        console.log(xhr.responseText);
	                	    var obj = JSON.parse(xhr.responseText);
	                        
	                        if (obj.number) {
	                        		result.innerHTML =
	                            	"<font color='red'>" + obj.name  + '</font> 您好，' + 
	                            	'您的明牌為：' + obj.number + "<br>" + 
	                                '您的地址為：' + obj.addrAjax1 + "<br>" ;
	                        } else {
	                        	result.innerHTML = "資料錯誤";
	                        }
	                    }
	                } else {
	                    alert("發生錯誤1: " + xhr.status + ", " + xhr.responseText);
	                }
	            } 
	    	}
	    }
	
	btn.onclick = function(){
	    var name = document.getElementById("visitor").value;
	    var addr = document.getElementById("address").value;
	   	var xhr = new XMLHttpRequest();
	   	xhr.open("POST", "<c:url value='/ch04/_01/GetLottery' />", true);
	   	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	   	xhr.send("visitor=" + name + "&addr0=" + addr);
	    	
	   	xhr.onreadystatechange = function() {
		// 向伺服器提出的請求已經收到回應
	        if (xhr.readyState === 4) {
	        // status: HTTP通訊協定的狀態碼伺服器，
	        // 200表示Server成功的處理請求
	            if (xhr.status === 200) {
	          	// getResponseHeader: 取得回應內容的MIME Type
	                 var type = xhr.getResponseHeader("Content-Type");   
	                 // 判斷回應類型，這裡使用 JSON
	                 if (type.indexOf("application/json") === 0) {               
	                        console.log(xhr.responseText);
	                	    var obj = JSON.parse(xhr.responseText);
	                        
	                        if (obj.number) {
	                        		result.innerHTML =
	                            	"<font color='red'>" + obj.name  + '</font> 您好，' + 
	                            	'您的明牌為：' + obj.number + "<br>" + 
	                                '您的地址為：' + obj.addrAjax1 + "<br>" ;
	                        } else {
	                        	result.innerHTML = "資料錯誤";
	                        }
	                    }
	                } else {
	                    alert("發生錯誤1: " + xhr.status + ", " + xhr.responseText);
	                }
	            } 
	    	}
	    }
};
</script>

<meta charset="UTF-8">
<title>我的第一個AJAX程式</title>
</head>
<body>
<div align='center'>
<h3>查詢明牌</h3>
<hr>
<table>
   <tr height='36'>
     <td width='120' align='right'>訪客姓名：</td>
     <td><input id='visitor' type="text" name="visitor" size = "10"></td>
   </tr>
   <tr height='36'> 
     <td width='120' align='right'>訪客地址：</td>
     <td><input id='address' type="text" name="address" size = "20"></td>
   </tr>
   <tr height='48'> 
     <td colspan='2' align='center'>
         <input id='btn' type="button" value="確定">
         <input id='btnJson' type="button" value="確定(JSON)">
     </td>  
</table>
<hr>
<div id='lotteryResult'  style='height:70px; line-height: 30px;'></div>
<hr>
<p>	

<small>
按下"確定"按鈕後，瀏覽器向後端程式ch04.Ch04Controller.lotteryServlet(String, String)發出非同步請求,
該程式會向Model元件(ch03.service.LotteryService.java)要求樂透號碼(lottery.getFourStars();)，
得到樂透號碼後，接著將要送往前端程式的資料(識別字串分別為name, addrAjax1與number)放入Map物件(map)內，
由Spring MVC將map物件轉為JSON格式的資料後送出給前端程式。
</small>
<hr>
<a href="<c:url value='/ch04/' />">回前頁</a>
</div>
</body>
</html>