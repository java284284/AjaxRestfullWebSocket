<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<link rel='stylesheet' href='../css/styles.css'  type='text/css' />
<title>EL</title>
</head>
<body BGCOLOR="white"> 
<jsp:include page="/commons/header.jsp" />

<h2 align="center">ch05 EL、動作元素與JavaBean</h2> 
<div align="center">

<table border="1">
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="ELDemo.do">屬性物件的種類</a><BR><font face="verdana" size="-2">WebContent/ch05/ex01/ELDemo.jsp<BR>ch05.ex01.controller.ELDemo.jave<BR>ch05.ex01.model.OrderBean.jave</font></td>
    <td  width="350"><p align="left"/>
      <a href="ex02/InputData.jsp">EL讀取輸入資料</a><BR><font face="verdana" size="-2">WebContent/ch05/ex02/InputData.jsp<BR>WebContent/ch05/ex02/InputDataSuccess.jsp<BR>ch05.ex02.controller.ReadParameterServlet.java</font></td>
  </tr>  
   <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="ex03/ch05_03.jsp">EL運算</a><BR><font face="verdana" size="-2">WebContent/ch05/ex03/ch05_03.jsp<BR>WebContent/ch05/ex03/ch05_03solution.jsp</font></td>
    <td  width="350"><p align="left"/>
      <a href="ex04/ch05_04.jsp">JSP+JavaBean</a><BR><font face="verdana" size="-2">WebContent/ch05/ex04/ch05_04.jsp<BR>ch05.ex04.controller.ELVersionController.java</font></td>
  </tr>    
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="ex05/ch05_05.jsp">利用JSP+JavaBean來產生樂透號碼</a><BR><font face="verdana" size="-2">WebContent/ch05/ex05/ch05_05.jsp</font></td>
    <td  width="350"><p align="left"/>
      <a href="ex06/ELIgnoredDemo.jsp">忽略 EL</a><BR><font face="verdana" size="-2">WebContent/ch05/ex06/ELIgnoredDemo.jsp</font></td>
  </tr>
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="ex07/jspInclude01.jsp">jsp:include</a><BR><font face="verdana" size="-2">WebContent/ch05/ex07/jspInclude01.jsp<BR>WebContent/ch05/ex07/jspInclude02.jsp<BR>WebContent/ch05/ex07/jspInclude03.jsp<BR></font></td>
    <td  width="350"><p align="left"/>
      <a href="ex08/jspForward01.jsp">jsp:forward</a><BR><font face="verdana" size="-2">WebContent/ch05/ex08/jspForward01.jsp<BR>WebContent/ch05/ex08/jspForward02.jsp<BR>WebContent/ch05/ex08/jspForward03.jsp<BR></font></td>
  </tr>       
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="c_url_Demo.jsp">c_url_Demo.jsp</a><BR><font face="verdana" size="-2">WebContent/ch06/c_url_Demo.jsp</font>
    </td>
    <td  width="350"><p align="left"/>
          <a href="c_redirect_Demo.jsp">c_redirect_Demo.jsp</a><BR><font face="verdana" size="-2">WebContent/ch06/c_redirect_Demo.jsp</font>
      </td>
  </tr>    
</table>
</div>
<hr>
<jsp:include page="/commons/footer.jsp" />
</body>
</html>
