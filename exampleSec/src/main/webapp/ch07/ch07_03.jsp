<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='../css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>load-on-startup</title>
</head>
<body>
<h1>啟動時自動載入(load-on-startup)</h1>
<BR>
請觀察『主控台』視窗會有下列訊息：<P/>
<font color='red'>
Servlet Zero is being loaded<BR>
Servlet First is being loaded<BR>
Servlet Second is being loaded<BR>
Servlet Third is being loaded<BR>
</font><P/>
這些訊息是由Servlet類別在載入時所顯示在『主控台』視窗，藉以觀察
load-on-startup <BR>所設定之載入先後順序的效果。<P/>

load-on-startup 用以指定伺服器啟動時，自動載入的類別，以及它們載入的順序。
<p/>
<jsp:include page="/commons/previousPage.jsp" />
</body>
</html>