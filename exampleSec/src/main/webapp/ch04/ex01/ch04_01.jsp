<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='../../css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC</title>
</head>
<body>
<CENTER>
<H1>加入會員(使用EL與JSTL)</H1>
 (1) Controller呼叫error.jsp 與 success.jsp兩個View元件<BR>
 (2) 呼叫Model元件來進行Business Logic運算 <BR>
<HR>
<Form Action="register0401_v3.do" method="POST">
    <Table>
         <TR>
             <TD align="RIGHT">帳號：</TD>
             <TD align="LEFT"><input	type="text" name="userId" value="helloSnoopy" size="20"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">密碼：</TD>
             <TD align="LEFT" ><input	type="password" name="pswd" value="123456" size="20"></TD>
         </TR>             
         <TR>
             <TD align="RIGHT">姓名：</TD>
             <TD align="LEFT" ><input	type="text" name="userName" value="史努比"  size="30"></TD>
         </TR>             
         <TR>
             <TD align="RIGHT">EMail：</TD>
             <TD align="LEFT" ><input type="text" name="eMail" value="snoopyHello@ppp.com.tw" size="40"></TD>
         </TR>             
         <TR>
             <TD align="RIGHT">電話號碼：</TD>
             <TD align="LEFT" > <input type="text" name="tel" value="0999000999"></TD>
         </TR>             
         <TR>
             <TD align="RIGHT">使用Java經驗：</TD>
             <TD align="LEFT" > <input type="text" name="experience" value="1" size="3"> 年</TD>
         </TR>    
        <TR>
            <TD colspan="2" align="center">      <input type="submit" value="提交"> </TD>
            </TR>
         </Table>
</Form>
</CENTER>
<BR><BR><HR><BR><CENTER>
<small>&lt;&lt;<a href="../">回第四章首頁</a>&gt;&gt;</small>
</CENTER>
</body>
</html>
