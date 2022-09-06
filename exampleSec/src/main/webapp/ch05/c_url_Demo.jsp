<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' href='../css/styles.css'  type='text/css' />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>URL</title>
</head>
<body>
url標籤將代表資源的字串存放在可以指定存活範圍的變數target內，如果有必要，<br>
此標籤會字串做URL Rewriting的處理。如果不指定變數，此標籤直接將結果輸出。<br>
<hr>
Case 1: <c:url value='/ch01/hello.jsp' var='target' /><br>
<hr>
Case 2: <c:url value='/hello.jsp'/><br>
<hr>
Case 3: <c:url value='hello.jsp'/><br>
<hr>
Case 4: target變數內的值 ${target}<br>
<hr>

<p/>
<jsp:include page="/commons/previousPage.jsp" />
</body>
</html>