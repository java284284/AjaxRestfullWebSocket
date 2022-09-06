<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='../../css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Send Redirect</title>
</head>
<body>
<h1>Send Redirect</h1>
Controller 所選取的數字為 ${anInteger}
<P/>要按F5重新整理，觀察差異(數字不會改變)
<BR><BR><HR><BR>
<small>&lt;&lt;<a href="${header['referer']}">再試一次</a>&gt;&gt;</small>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<small>&lt;&lt;<a href="../">回第四章首頁</a>&gt;&gt;</small>
</body>
</html>