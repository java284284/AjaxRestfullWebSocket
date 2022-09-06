<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>
<c:if test="${empty LoginOK}">
    <c:set var='target' value='${pageContext.request.requestURI}' scope='session' />
    <c:redirect url="login.jsp"/>
</c:if>
<c:choose>
  <c:when test="${ dbtype == 'mysql' }" >
      <jsp:useBean id='dao1' class='_01.model.LoginServiceMySQLDAO'/>
      <c:set var='dao' value='${dao1}'  />
  </c:when>
  <c:otherwise >
      <jsp:useBean id='dao2' class='_01.model.LoginServiceSQLServerDAO'/>
      <c:set var='dao' value='${dao2}'  />
  </c:otherwise>
</c:choose>


     
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%@ include file="/segments/header_xss.jsp" %>
<div class='center'>
<table border='1' style='width:600px;'>
   <c:forEach var='cb' items='${dao.members}' >
      <tr>
          <td style="width:80px">${cb.pKey}</td>
          <td style="width:100px">
            <c:choose>
            <c:when test="${cb.custId != LoginOK.custId}">
                 <a href='blog.jsp?id=${cb.custId}'>${cb.custId}</a>
            </c:when>
            <c:otherwise>
                 ${cb.custId}
            </c:otherwise>
            </c:choose>
          </td>
          <td style="width:180px">${cb.password}</td>
          <td style="width:250px">${cb.email}</td>
      </tr>
   </c:forEach>
</table>

</div>
</body>
</html>