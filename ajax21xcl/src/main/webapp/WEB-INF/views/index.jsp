<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />
<meta charset="UTF-8">
<title>Ajax 首頁</title>
</head>
<body>
<div class='center'>
<h2>Ajax 範例</h2>
<a href='ch01/' >第一章  同步與非同步</a><br>
<a href='ch02/' >第二章  預備工作</a><br>
<a href='ch03/' >第三章  Ajax非同步處理</a><br>
<a href='ch04/' >第四章  JSON與資料庫存取</a><br>
<hr>
請先執行ch00.util.InitialDataSetup.java新建表格與初始資料<br>
<font color='red' size='-2'>DB:${sys.dbType}</font>
<hr>

<a href="<c:url value='/ex01' />">練習一</a><br>
<a href="<c:url value='/inClassExer01' />">課堂練習一</a><br>
<a href="<c:url value='/inClassExer02xyz' />">課堂練習二</a><br>

</div>
</body>
</html>