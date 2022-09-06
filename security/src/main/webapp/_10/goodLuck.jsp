<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>報明牌</title>
</head>
<body style='background-color: #EFF5FB;'>
<div >
<H2>卜籤求明牌</H2>   
${visitName}，您好，<BR>  
您的明牌為：${luckyNumber}
<p/>
<div style='position:relative; top:100px;'>
<small>&lt;&lt;<a href="${pageContext.servletContext.contextPath}/index_security.jsp">回前頁</a>&gt;&gt;</small>
</div>
</div>
</body>
</html>