<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查詢明牌</title>
</head>
<body style='background-color: #EFF5FB;'>
<div>
<h2>查詢明牌</h2>
<Form action="<c:url value='LotteryServlet' />" method="POST">
      訪客姓名:<input type="text" name="visitor" size = "10"><P/>
   <input type="submit" value="確定"><P/>
</Form>
</div>
<div style='position:relative; top:100px;'>
<small>&lt;&lt;<a href="${pageContext.servletContext.contextPath}/index_security.jsp">回前頁</a>&gt;&gt;</small>
</div>
</body>
</html>