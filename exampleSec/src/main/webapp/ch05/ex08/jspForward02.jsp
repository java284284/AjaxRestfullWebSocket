<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' href='../css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jspForward02.jsp</title>
</head>
<body>
<font color="#556655">這是第二頁，準備進入(Forward)第三頁</font><br>
<jsp:forward page="jspForward03.jsp"/>
<font color="#556655">這是第二頁，由第三頁返回</font><br>
<br><br><br>
<CENTER>
  <small>&lt;&lt;<a href="../index.jsp">回第五章首頁(02)</a>&gt;&gt;</small>
</CENTER>
</body>
</html>