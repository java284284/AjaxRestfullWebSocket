<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<link rel='stylesheet' href='../css/styles.css'  type="text/css" />
<title>動態網頁</title>
</head>
<body BGCOLOR="white">
<jsp:include page="/commons/header.jsp" />

<h2 align="center">Ch02 請求與回應</h2>
<div align="center">
<form name='a' id='a'>
    <input type='hidden' name='a' />
</form>
<table border="1">
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
         <a href="ch02_01.jsp">瀏覽器送出GET命令的時機</a><BR><font face="verdana" size="-2">WebContent/ch02/ch02_01.jsp</font></td>
    <td  width="350"><p align="left"/>
         <a href="ch02_02.jsp">瀏覽器送出POST命令的時機</a><BR><font face="verdana" size="-2">WebContent/ch02/ch02_02.jsp</font></td>
  </tr> 
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="ch02_03.jsp">讀取表單資料(GET)</a><BR><font face="verdana" size="-2">WebContent/ch02/ch02_03.jsp<BR>ch02.ex03.controller.ProcessOrder.java<BR>WebContent/ch02/displayCustomerInfo.jsp</font></td>
    <td  width="350"><p align="left"/>
      <a href="ch02_04.jsp">讀取表單資料(POST) </a><BR><font face="verdana" size="-2">WebContent/ch02/ch02_04.jsp<BR>ch02.ex03.controller.ProcessOrder.java<BR>WebContent/ch02/displayCustomerInfo.jsp</font></td>
  </tr>  
<tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="	ch02_05.jsp">由Servlet產生文字性回應</a><BR><font face="verdana" size="-2">WebContent/ch02/ch02_05.jsp<BR>ch02.ex05.controller.MemberServlet.java</font></td>
    <td  width="350"><p align="left"/>
      <a href="ch02_06.jsp">由Servlet產生非文字性回應</a><BR><font face="verdana" size="-2">WebContent/ch02/ch02_06.jsp<BR>WebContent/ch02/showPicture.jsp<BR>ch02.ex06.controller.ShowPictureServlet.java</font></td>
  </tr>    
<!--   
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="	ch02_05.jsp">請求資訊(Servlet版)</a><BR><font face="verdana" size="-2">WebContent/ch02/ch02_05.jsp<BR>ch02.ex05.controller.RequestInfo.java</font></td>
    <td  width="350"><p align="left"/>
      <a href="ch02_06.jsp">請求資訊(JSTL版) </a><BR><font face="verdana" size="-2">WebContent/ch02/ch02_06.jsp<BR>WebContent/ch02/request/requestJSTL.jsp</font></td>
  </tr>  
 -->  
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
         <a href="sendRedirect1">setHeader範例(sendRedirect一)</a><BR><font face="verdana" size="-2">ch02.ex07.controller.SendRedirect1.java</font></td>
    <td  width="350"><p align="left"/>
         <a href="sendRedirect2">setHeader範例(sendRedirect二)</a><BR><font face="verdana" size="-2">ch02.ex08.controller.SendRedirect2.java<BR>WebContent/ch02/ch02_08_1.jsp,&nbsp;ch02_08_2.jsp<BR>ch02_08_3.jsp&nbsp;與&nbsp;ch02_08_4.jsp</font></td>
  </tr>
   <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
       <a href="ch02_09.jsp">setHeader範例，我們搬家了</a><BR><font face="verdana" size="-2">(客戶端提取)<BR>WebContent/ch02/ch02_09.jsp</font></td>
    <td  width="350"><p align="left"/>
         <a href="ch02_10.jsp">10秒後自動更新畫面</a><BR><font face="verdana" size="-2">(客戶端提取)<BR>WebContent/ch02/ch02_10.jsp</font></td></td> 
  </tr>
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="requestInfo/request.do?arg1=value1&name=snoopy">與請求有關的資訊</a><BR><font face="verdana" size="-2">ch02.ex11.controller.RequestInfo.java</font>
    </td>
    <td  width="350"><p align="left"/>
      <a href="ch02_12.jsp">setHeader範例(不使用 cache)</a><BR><font face="verdana" size="-2">WebContent/ch02/ch02_12.jsp</font>
    </td>      
  </tr>
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="../ch99/index.jsp">瀏覽器如何提出請求</a><BR><font face="verdana" size="-2">WebContent/ch99/index.jsp</font>
    </td>
    <td  width="350"><p align="left"/>
      <a href="ex14/spy.007">1.明確的對應關係(/ch02/ex14/spy.007)</a><BR><font face="verdana" size="-2">ch02.ex14.controller.ExplicitServlet</font><br>
      <a href="ex14/PSY/abula.009">2.前置路徑的對應關係(/ch02/ex14/PSY/*)</a><BR><font face="verdana" size="-2">ch02.ex14.controller.PrefixServlet</font><br>
      <a href="ex14/nono/GangNam_Style.007">3.延伸檔名的對應關係(*.007)</a><BR><font face="verdana" size="-2">ch02.ex14.controller.ExtensionServlet</font><br>
      4.預設的對應關係(/*)保留給容器用對應關係<BR><font face="verdana" size="-2">ch02.ex14.controller.DefaultServlet</font><br>
    </td>      
  </tr>    
</table>
</div>
<hr>
<jsp:include page="/commons/footer.jsp" />
</body>
</html>
