<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>

<jsp:useBean id='dao' class='_04.model.MessageServiceMySQLDAO' />  

<c:if test="${empty LoginOK}">
    <c:set var='target' value='${pageContext.request.requestURI}' scope='session' />
    <c:redirect url="login.jsp"/>
</c:if>         
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
<meta charset="UTF-8">
<title>查看留言</title>
</head>
<body>
MySQL<br>
<%@ include file="/segments/header_xss.jsp" %>
<c:set target='${dao}' property='toid' value='${LoginOK.custId}' />

<div class='center'>
<c:choose> 
<c:when test="${not empty dao.messages}">
        留給${LoginOK.custId}的訊息<br><br>
   <c:forEach var='mb' items='${dao.messages}' varStatus='vs'>
      <c:if test="${vs.first}">
          <c:out value="<table border='1' style='width:960px;'>" escapeXml='false' />
          <tr>       
              <th style="width:80px">編號</th>
              <th style="width:80px">留言者</th>
              <th style="width:180px">主旨</th>
              <th style="width:250px">留言時間</th>
              <th style="width:250px">本文</th>
          </tr>
      </c:if>

      <tr>
          <td style="width:80px">${mb.seqno}</td>
          <td style="width:80px">${mb.fromId}</td>
          <td style="width:180px">${mb.title}</td>
          <td style="width:250px; text-align:left">&nbsp;${mb.ts}</td>
          <td style="width:250px; text-align:left">${mb.content}</td>
      </tr>
      <c:if test="${vs.last}">
          <c:out value="</table>" escapeXml='false' />
      </c:if>
   </c:forEach>
</c:when>
<c:otherwise>
     沒有留言給您
</c:otherwise>
</c:choose>   
</div>
</body>
</html>