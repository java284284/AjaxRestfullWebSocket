<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
<meta charset="UTF-8">
<title>留言版</title>
</head>
<body>
<%@ include file="/segments/header_xss.jsp" %>
<div class='center'>
<h1>留言版</h1>

<form action='blog.do' method='post'>
    <table border='1' class='center'>
    <tr><td width='80'>To</td><td width='580' style='text-align:left;'>&nbsp;${param.id}</td></tr>
    <tr><td width='80'>主題</td><td width='580'><input type='text'  name='title' size='81' value='${param.title}'></td></tr>
    <tr><td width='80'>內文</td><td width='580'><textarea rows='10' cols='70'  name='content'  value='${param.content}'></textarea></td></tr>
    <tr><td colspan='2'><input type='submit'  value='提交'></td></tr>
  </table>
  <input type="hidden"  name='fromid' value='${LoginOK.custId}'>
  <input type="hidden"  name='id' value='${param.id}'>
  
</form>
</div>
<font color='red'>${ErrorMsgKey.TitleError}</font><br>
<font color='red'>${ErrorMsgKey.ContentError}</font><br>

</body>
</html>