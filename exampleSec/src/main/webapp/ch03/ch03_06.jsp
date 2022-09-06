<%@ page session="false" pageEncoding="UTF-8" errorPage="error/ExceptionPage.jsp" %>
<%-- This page will cause an "divide by zero" exeception --%>

<html>

<head>
<link rel='stylesheet' href='../css/styles.css'  type='text/css' />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>例外處理</title>
</head>

<body>
<h2>例外處理</h2>
<table style='width:900px;' border='1'>
  <tr>
     <td>程式發生ServletException</td><td><a href='MyErrorProneServlet'>使用 MyErrorProneServlet</a></td>
  </tr>
  <tr>
     <td>不存在的資源</td><td><a href='NotFound.jsp'>不存在的網頁</a></td>
  </tr>
  <tr>
     <td>程式發生RuntimeException</td><td><a href='RuntimeExceptionServlet'>使用 RuntimeExceptionServlet</a></td>
  </tr>

</table>
<p/>
<small>
<a href='${pageContext.request.contextPath}/ch03'>回第三章首頁</a>
</small>
</body>

</html>
