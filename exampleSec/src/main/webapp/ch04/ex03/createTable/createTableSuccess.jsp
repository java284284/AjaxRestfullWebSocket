<%@ page contentType="text/html; charset=UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<head>
<link rel='stylesheet' href='../../css/styles.css'  type="text/css" />
</head>
<BODY>
<H1>表格新建成功</H1>
<c:if test="${not empty messages}">
  <p>
  <font color='blue'>執行結果：
  <c:forEach var="message" items="${messages}">
         <li>${message}</li>
  </c:forEach>
  </font>
  </p>
</c:if>
<br><br>
請重新啟動伺服器<br><br>
<P/><a href="${header['referer']}">回前頁</a>
</BODY>   
</HTML>