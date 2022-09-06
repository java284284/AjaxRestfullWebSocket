<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' href='../../css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jspInclude01.jsp</title>
</head>
<body>
<font color="#FF0000">這是第一頁，準備進入(Include)第二頁</font><br>
<jsp:include page="jspInclude02.jsp"/>
<font color="#FF0000">這是第一頁，由第二頁返回</font><br>
<br><br><br>
<center>
  <small>&lt;&lt;<a href="../index.jsp">回第五章首頁(01)</a>&gt;&gt;</small>
</center>
</body>
</html>