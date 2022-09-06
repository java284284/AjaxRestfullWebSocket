<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<link rel='stylesheet' href='../css/styles.css'  type="text/css" />
<title>ServletConfig與ServletContext</title>
</head>
<body BGCOLOR="white">
<jsp:include page="/commons/header.jsp" />

<h2 align="center">Ch07 Servlet與ServletContext 的生命週期</h2>
<div align="center">
<table border="1">
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="initParameter.do">Servlet起始參數－設定</a><BR><font face="verdana" size="-2">ch07.ex01.controller.GetInitParameter.java</font></td>
    <td  width="350"><p align="left"/>
      <a href="ch07_02.jsp">Servlet起始參數－應用</a><BR><font face="verdana" size="-2">WebContent/ch07/ch07_02.jsp<BR>ch07.ex02.controller.LotteryServlet.java</font><BR><font face="verdana" size="-2">WebContent/ch07/lotteryResult.jsp</font></td>
  </tr>  
  
  <tr height="80" bgcolor="lightblue" align="center">

      <td  width="350"><p align="left"/>
      <a href="ch07_03.jsp">啟動時自動載入(load-on-startup)</a><BR><font face="verdana" size="-2">WebContent/ch07/ch07_03.jsp<BR>ch07.ex03.Anytime.java,&nbsp;First.java<BR>Second.java&nbsp;與&nbsp;Third.java</font></td>
      <td  width="350"><p align="left"/>
      <a href="ch07_04.jsp">ServletContext 設定起始參數</a><BR><font face="verdana" size="-2">WebContent/ch07/ch07_04.jsp<BR>ch07.ex04.view.ContextInitParamServlet.java</font></td>
  </tr>  
  
   <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="ch07_05.jsp">下載檔案</a><BR><font face="verdana" size="-2">WebContent/ch07/ch07_05.jsp<BR>ch07.ex05.controller.ReturnJarFile.java</font></td>    
    <td  width="350"><p align="left"/>
      <a href="ch07_06.jsp">使用ServletContextListener一</a><BR><font face="verdana" size="-2">WebContent/ch07/ch07_06.jsp<BR>ch07.ex06.view.ListenerTester.java<BR>ch07.ex06.web.MyServletContextListener.java</font></td>
  </tr>  
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="ch07_07.view">使用ServletContextListener二</a><BR><font face="verdana" size="-2">ch07.ex07.view.ShowCoffeeList.java<BR>ch07.ex07.web.ServletContextListenerDemo00.java</font></td>
       <td  width="350"><p align="left"/>
      <a href="ch07_08.jsp">顯示隨機圖片</a><BR><font face="verdana" size="-2">WebContent/ch07/ch07_08.jsp<BR>ch07.ex08.controller.ReturnRandomPicture.java</font></td>
  </tr>  
  
  
</table>
</div>
<hr>
<jsp:include page="/commons/footer.jsp" />
</body>
</html>
