<%@ page contentType="text/html; charset=UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<head>
<link rel='stylesheet' href='../../css/styles.css'  type="text/css" />
</head>
<BODY>
<H1>新建表格失敗</H1>
<%-- Report any errors (if any) --%>
<c:if test="${not empty errorMsgs}">
  <p>
  <font color='red'>新建表格時，發生下列錯誤：
   <c:forEach var="message" items="${errorMsgs}">
      <li>${message}</li>
  </c:forEach>
  </font>
  </p>
</c:if>
<br>
<small>&lt;&lt;<a href="../">回前頁</a>&gt;&gt;</small>
</BODY>   
</HTML>