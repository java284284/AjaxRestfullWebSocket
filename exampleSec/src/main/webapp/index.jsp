<%@ page contentType="text/html; charset=UTF-8" session="false"%>
<html> 
<head>   
<link rel='stylesheet' href='css/styles.css'  type="text/css" />
<title>JSP 範例</title>   
</head>
<body BGCOLOR="white">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/commons/header.jsp" />	  	
<div align="left">
<h3 align="left">基礎篇</h3>
<ul >
  <li><a href="<c:out value='${pageContext.request.contextPath}' />/ch01/index.jsp" >一、入門</a>&nbsp;<font color='red'>*</font></li>
  <li><a href="<c:out value='${pageContext.request.contextPath}' />/ch02/" >二、處理請求與產生回應</a>&nbsp;<font color='red'>*</font></li>
  <li><a href="<c:out value='${pageContext.request.contextPath}' />/ch03/index.jsp" >三、JSP 網頁</a> </li>
  <!-- 
  <li><a href="<%=request.getContextPath()%>/ch03/_ch03.jsp" >三、Servlet與ServletContext 的生命週期</a></li>
 -->  
  <li><a href="<%=request.getContextPath()%>/ch04/" >四、MVC架構與存取資料庫</a> </li>
  <li><a href="<c:out value='${pageContext.request.contextPath}' />/ch05/index.jsp" >五、EL、動作元素與JavaBean</a> </li>
  <li><a href="<c:out value='${pageContext.request.contextPath}' />/ch06/index.jsp" >六、Session 與 Cookie</a> </li>  
  <li><a href="<c:out value='${pageContext.request.contextPath}' />/ch07/index.jsp" >七、Servlet Servlet Context 生命週期</a> &nbsp;<font color='blue'>*</font></li>
  <li><a href="<c:out value='${pageContext.request.contextPath}' />/ch08/index.jsp" >八、Filter 過濾器</a>&nbsp;<font color='blue'>*</font> </li>
  <!-- 
  <li><a href="<c:out value='${pageContext.request.contextPath}' />/ch09/index.jsp" >九、Security</a> </li>
   -->
</ul>
<P/>
</div>
</body>
</html>