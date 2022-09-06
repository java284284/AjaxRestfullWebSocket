<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>第二個練習</title>
<script>


</script>
</head>
<body>
<div align='center'>
   <h3>練習二</h3>
   <hr>
   <button id='btn21'>現在本地時間</button>
   <button id='btn22'>回應為多份格式不同的資料</button>
<!--    <button id='btn23'>回應為多個物件</button> -->
   <hr>
   <div id='dataArea'>
      &nbsp;
   </div>
   <hr>   
   <a href="/">回前頁-A NG</a>
   <a href="<c:url value='/'  />">回前頁-B</a>
</div>
</body>
</html>