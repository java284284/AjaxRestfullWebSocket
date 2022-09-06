<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='../../css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>P361   Version 9</title>
</head>

<body>
<h1>Final EL Version   </h1>
<h3>使用EL(由ELVersionController.java forward 而來)</h3>
<TABLE border='1'>
<TR>
  <TD>
        姓名為 ${personKey.name}
  </TD> 
  <TD>
    使用的EL為 \${personKey.name}，personKey為Bean的識別字串，name為Bean的性質
  </TD>
</TR>
<TR>
  <TD>編號為 ${personKey.empID}</TD> 
  <TD>
  使用的EL為 \${personKey.empID}，personKey為Bean的識別字串，empID為Bean的性質
  </TD>
</TR>
</TABLE>
<P/>
<CENTER>
  <small>&lt;&lt;<a href="ch05_04.jsp">再試一次</a>&gt;&gt;</small>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <small>&lt;&lt;<a href="../index.jsp">回第五章首頁</a>&gt;&gt;</small>
  </CENTER>
</body>
</html>