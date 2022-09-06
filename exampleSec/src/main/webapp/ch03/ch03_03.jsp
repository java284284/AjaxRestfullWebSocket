<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--          這是一個 JSP 的註解                 --%>
<html>
<head>
<link rel='stylesheet' href='../css/styles.css'  type='text/css' />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello Again</title>
</head>
<body>
<H3>Hello Again, 大家好</H3>
<BR>
<%
java.util.Date d = new java.util.Date();
%>
現在時刻是 <%= d %><BR><P/>
明牌為 <%= getLottery() %><BR>

<jsp:include page="/commons/previousPage.jsp" />
</body>
</html>
<%!  public String getLottery() {
	return "11  29  31  40  45  46";
}
%>