<%@ page contentType="text/html; charset=UTF-8" %>
<html> 
<head>
<link rel='stylesheet' href='../css/styles.css'  type='text/css' />
<title>動態網頁</title>
</head>
<body BGCOLOR="white"> 
<jsp:include page="/commons/header.jsp" />
<h2 align="center">Ch01 入門</h2> 
<div align="center">
  
<table border="1">
  <tr height="52" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="sayHelloServlet">Hello, World (Servlet 版)</a><BR>
           <font face="verdana" size="-2"> ch01.ex01.HelloWorldServlet.java</font>
    </td>
    <td  width="350"><p align="left"/>
      <a href="hello.jsp">Hello, World (JSP 版)  </a><BR>
           <font face="verdana" size="-2"> WebContent/ch01/hello.jsp</font>
    </td>
  </tr>  
  <tr height="52" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="messageServlet">動態網頁</a><BR>
           <font face="verdana" size="-2"> ch01.ex03.MessageServlet.java</font>
    </td>
    <td  width="350"><p align="left"/>
      <a href="helloAgain.jpg">Hello, Again (Servlet 版)</a><BR>
           <font face="verdana" size="-2"> com.abc.HahaServlet.java</font>
    </td>
  </tr>  
</table> 
</div>
<hr>
<jsp:include page="/commons/footer.jsp" />
</body>
</html>
