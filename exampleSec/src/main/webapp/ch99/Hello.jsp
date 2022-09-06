<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<fmt:setLocale value="jp" />
<fmt:setBundle basename="ch99.Login" var="myBundle"/>
<fmt:message key='user' bundle='${myBundle}'/>
<br>
<fmt:message key='pswd' bundle='${myBundle}'/>
<br>
<fmt:message key='regards' bundle='${myBundle}'>
  <fmt:param value='Good Morning' />
  <fmt:param value='TGIF' />
</fmt:message>

</body>
</html>