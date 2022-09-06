<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>
<c:choose>
  <c:when test="${ dbtype != 'mysql' }" >
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
<body style='background-color: #EFF5FB;'>
<div class='center'>
<h2>會員資料</h2>
<table border='1' style='width:600px;'>
   <c:forEach var='cb' items='${dao.members}' >
      <tr>
          <td style="width:80px">${cb.pKey}</td>
          <td style="width:100px">${cb.custId}</td>
          <td style="width:180px">${cb.password}</td>
          <td style="width:250px">${cb.email}</td>
      </tr>
   </c:forEach>
</table>
<p/>
<div id='column3'>
<small>&lt;&lt;<a href="${pageContext.servletContext.contextPath}/index_security.jsp">回前頁</a>&gt;&gt;</small>
</div>
</div>

</body>
</html>