<%@ page session="false" pageEncoding="UTF-8" errorPage="error/ExceptionPage.jsp" %>
<%-- This page will cause an "divide by zero" exeception --%>

<html>

<head>
<link rel='stylesheet' href='../css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>本網頁會包含其他的網頁片段</title>
</head>

<body>
<h2>包含共用的網頁片段</h2>
<table style='width:800px;' border='1'>
  <tr>
     <td>靜態包含</td><td><a href='ch03_07_directive_include.jsp'>使用 &lt;%@ include file='ch03_07_directive_include.jsp'  %&gt;</a></td>
  </tr>
  <tr>
     <td>動態包含</td><td><a href='ch03_07_standard_action_include.jsp'>使用 &lt;jsp:include page='ch03_07_standard_action_include.jsp'  %&gt;</a></td>
  </tr>
  <tr>
     <td>動態包含</td><td><a href='ch03_07_jstl_import.jsp'>使用 &lt;c:import url='ch03_07_jstl_import.jsp'  %&gt;</a></td>
  </tr>

</table>
<p/>
<small>
<a href='${pageContext.request.contextPath}/ch03'>回第三章首頁</a>
</small>
</body>

</html>
