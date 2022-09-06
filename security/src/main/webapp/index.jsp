<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='css/styles.css'  type="text/css" />
<title>Security 範例</title>   
</head>
<body BGCOLOR="white">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/commons/header.jsp" />
<p/>
<div align='center' style='position: relative'>
   <div align='left' id='inner'>
      <a href="${pageContext.request.contextPath}/index_sql.jsp">隱碼攻擊(SQL Injection)</a><p/>  
      <a href="${pageContext.request.contextPath}/index_xss.jsp">跨網站程式碼攻擊(XSS)</a><p/>
      <a href="${pageContext.request.contextPath}/index_security.jsp">Tomcat的資源控管機制</a><p/>
   </div>
</div>
<c:remove var='sql' scope='session'  />
  
</body>
</html>