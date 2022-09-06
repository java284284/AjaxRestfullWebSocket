<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' href='../../css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL Demo 2</title>
</head>
<body>
<H1>
EL 功能展示二
</H1>
${errorMSG.overAllMSG}&nbsp;<BR>
<FORM action="ReadParameters.do" methd="POST">
姓名:<INPUT type="text" name="customerName" value="${param.customerName }"/><font color='red' size='-1'>${errorMSG.NameError}</font><BR>
地址:<INPUT type="text" name="address" value="${param.address }"/><font color='red' size='-1'>${errorMSG.AddrError}</font><BR><P/>
<INPUT type="submit" value="提交"/> <BR>
</FORM>
<P/>
<BR>
<small>&lt;&lt;<a href="../index.jsp">回第五章首頁</a>&gt;&gt;</small>
</body>
</html>