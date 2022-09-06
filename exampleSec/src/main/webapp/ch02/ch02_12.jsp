<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel='stylesheet' href='../css/styles.css'  type="text/css" />
<title>要求瀏覽器不要Cache回應</title>
<link   rel="stylesheet"  href="../css/styles.css" type="text/css"/>
<script src="../scripts/ajax.js" type="text/javascript">
</script>
</head>
<body>
<center>
<table border="1" bgcolor="gray">
   <tr><th><big >Cache回應之範例展示(Ajax)</big></th></tr>  
</table>
<div id="currentTime">目前時間為...</div>
<p />
<input type="button" value="顯示目前時間" onclick='sendRequest("../ch02/ex12/ShowMessage", "currentTime")' />
<p />
</center>
<small>&lt;&lt;<a href="index.jsp">回前頁</a>&gt;&gt;</small>
</body>
</html>