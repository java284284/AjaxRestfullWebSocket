<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查詢明牌(Lab05_04)</title>
</head>
<body>
<h2>查詢明牌(Lab05_04)</h2> 
<!-- 
<Form action="goodLuck.jsp" method="POST">
 --> 
<Form action="<c:url value='goodLuck.jsp' />" method="POST">
    訪客姓名:<input type="text" name="visitor" size = "10"><P/>
    
  <input type="submit" value="確定"><P/>
</Form>
</body>
</html>