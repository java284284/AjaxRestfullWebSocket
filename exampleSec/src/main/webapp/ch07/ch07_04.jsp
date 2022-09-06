<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='../css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ServletContext 設定起始參數</title>
</head>
<body>
<h1>ServletContext 設定起始參數</h1>
<h3>功能：</h3>
1. 微調 ServletContext的行為(如Log的路徑、圖片檔資料夾的路徑、JNDI名稱等)<BR>
2. 多個 Servlet 的共用資料，如相同的起始參數<BR>
<BR>
以上資料皆可由ServletContext 起始參數讀入，然後透過context.setAttribute()方法，將起始
參數放入context scope內(context 置物櫃)
<P/>
<a href="contextInitParam.do">讀取 ServletContext 起始參數</a>
<p/>
<HR><CENTER><small><a href='index.jsp'>回前頁</a></small></CENTER>
</body>
</html>