<%-- @ page contentType="text/html; charset=UTF-8" session="false" --%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<link rel='stylesheet' href='../css/styles.css'  type="text/css" />
<title>Session</title>
</head>
<body BGCOLOR="white">
<jsp:include page="/commons/header.jsp" />

<h2 align="center">Ch06 Session 與 Cookie</h2>


<%
   session.setAttribute("dog", "Snoopy...");
%>
<div align="center"><center>
<h3>預設的情況下，Session已經開始</h3>
<table border="1">
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="SD1.do">測試Session是否新建isNew()</a><BR><font face="verdana" size="-2">ch06.ex01.view.SessionDemo1.java</font></td>
    <td  width="350"><p align="left"/>
      <a href="SD2.do">Session 必須存在</a><BR><font face="verdana" size="-2">ch06.ex02.view.SessionDemo2.java</font></td>
  </tr>  
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="SD3.do">URL Rewriting</a><BR><font face="verdana" size="-2">ch06.ex03.view.SessionDemo3.java<BR>WebContent/ch06/sd3Result.jsp</font></td>
    <td  width="350"><p align="left"/>
      <a href="setCookie.jsp">Cookie的設定與使用</a><BR><font face="verdana" size="-2">WebContent/ch06/setCookie.jsp<BR>ch06.ex04.controller.CookieTest.java<BR>ch06.ex04.view.DisplayCookie.java</font></td>
  </tr>  
  
  
  
</table>
</center></div>
<hr>
<jsp:include page="/commons/footer.jsp" />
</body>
</html>
