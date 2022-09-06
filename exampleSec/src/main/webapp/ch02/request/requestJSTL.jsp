<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='../../css/styles.css'  type='text/css' />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Request Information Example(JSTL)</title>
</head>
<body>
<h3>Request Information Example(JSTL)</h3>
<h3>本畫面由JSP網頁產生</h3>
<P/>Request URI: ${pageContext.request.requestURI}
<P/>QueryString: ${pageContext.request.queryString}
<P/>Context Path: ${pageContext.request.contextPath}
<P/>Servlet Path: ${pageContext.request.servletPath}
<P/>SessionId: ${pageContext.request.requestedSessionId}
<P/>Method: ${pageContext.request.method}
<P/>Protocol: ${pageContext.request.protocol}
<P/>Remote Address: ${pageContext.request.remoteAddr}
<P><HR><CENTER><small>&lt;&lt;<a href='../_ch02.jsp'>回第二章首頁</a>&gt;&gt;</small></CENTER>
</body>
</html>