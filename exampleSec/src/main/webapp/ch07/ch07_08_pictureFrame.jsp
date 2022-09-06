<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' href='../css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>風景圖</title>
</head>
<body bgcolor='#fffacd'>
<center>
<TABLE  >
   <TR><TD width='120'>&nbsp;</TD>
       <TD>
           <TABLE border='3'><TR><TD>
           <IMG SRC='randomPicture.do'/>
           </TD></TR>
           </TABLE>
       </TD>
       <TD width='120' valign='bottom'>
       <small>&lt;&lt;<a href="${header['referer']}">回前頁</a>&gt;&gt;</small>
       </TD>
   </TR>
</TABLE>
</center>
</body>
</html>