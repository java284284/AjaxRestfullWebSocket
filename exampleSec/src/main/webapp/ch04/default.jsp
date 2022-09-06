<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<link rel='stylesheet' href='../css/styles.css'  type="text/css" />
<title>MVC架構</title>
</head>
<body BGCOLOR="white">
<jsp:include page="/commons/header.jsp" />

<h2 align="center">Ch04 MVC架構與存取資料庫</h2>
<div align="center">

<table border="1">
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="ex01/ch04_01.jsp">MVC實作</a>&nbsp;<font color='red'>*</font><BR><font face="verdana" size="-2">WebContent/ch04/ex01/ch04_01.jsp<BR>WebContent/ch04/ex01/*.jsp<BR>ch04.ex01.controller.*.java<BR>ch04.ex01.model.*.java</font></td>
    <td  width="350"><p align="left"/>
      <a href="ex02/ch04_02.jsp">SendRedirect與RequestDispatcher</a><BR><font face="verdana" size="-2">WebContent/ch04/ex02/ch04_02.jsp<BR>WebContent/ch04/ex02/rd.jsp<BR>WebContent/ch04/ex02/sr.jsp<BR>ch04.ex02.controller.SendRedirectDemo.java<BR>ch04.ex02.controller.RequestDispatcherDemo.java</font></td>       
  </tr>
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left">
      <a href="ex03/ch04_ex03_mvc.jsp">新增會員資料(SQLServer)</a>&nbsp;<font color='red'>*</font><BR><font face="verdana" size="-2">WebContent/ch04/ex03/ch04_ex03_mvc_V4.jsp<BR>WebContent/ch04/ex03/*.jsp<BR>ch04.ex03.controller.*.java<BR>ch04.ex03.model.*.java</font></td>
    <td  width="350"><p align="left">
      <a href="ex04/queryAllMembers.do">查詢會員資料(SQLServer)</a><BR><font face="verdana" size="-2">WebContent/ch04/ex04/showAllMembers.jsp<BR>ch04.ex04.controller.QueryAllMembers.java</font></td>
  </tr>   
</table>
</div>
<hr>
<jsp:include page="/commons/footer.jsp" />
</body>
</html>
