<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />
<script type="text/JavaScript">
	window.onload = function() {
		// SELECT標籤
		var city = document.getElementById("city");
		city.onchange = function() {
			var xhr = new XMLHttpRequest();
			var cityName = city.options[ city.selectedIndex ].text;	
			var queryString = "city=" + city.value + "&cityName=" + cityName;
			var url = "<c:url value='/ch03/_05/ShowCityTime' />?" + queryString;
			//console.log(url);
			xhr.open("GET", url, true);
			xhr.send();
			xhr.onreadystatechange = function() {
				// 向伺服器提出的請求已經收到回應
				if (xhr.readyState === 4) {
					// 伺服器回應成功
					if (xhr.status === 200) {
						document.getElementById("result").innerHTML = 
						"<font color='red'>" + xhr.responseText + "</font>";
					} else if (xhr.status === 404) {
						//....
					} 
				}
			}
		}
	};
</script>
<meta charset="UTF-8">
<title>顯示時間</title>
</head>
<body>
<div align='center'>
	<h3 style='color: blue;'>查詢世界主要城市的時間</h3>
<hr>
<select id='city'>
  <option value='Asia/Taipei'>台北</option>
  <option value='America/New_York'>紐約</option>  
  <option value='Asia/Tokyo'>東京</option>
  <option value='Europe/London'>倫敦</option>
</select>
<div id='result' style='height:100px; line-height:100px;'>
</div>
<hr>
<small>
搭配的Server端程式為ch03.Ch03Controller#cityTime(String, String)
</small>
<hr>
<a href="<c:url value='/ch03' />">回前頁</a>
</div>
</body>
</html>