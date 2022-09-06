<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登錄</title>
</head>
<body>
<CENTER>  
<!-- 
<Form Action="login.do" method="POST">
 -->
 <!-- 
<Form Action="<c:url value='login.do' />" method="POST">
 -->
<Form Action="<c:url value='/ch06_01/login.do' />" method="POST">
    <Table width='330' >
         <TR><TH colspan='2'>
            <H1>登入</H1> 
         </TH><TH></TH></TR>
         <TR>
             <TD align="RIGHT">帳號：</TD>
             <TD align="LEFT"><input	type="text" name="userId" size="10"></TD>
             <TD width='120'><small><Font color='red' size="-1">${ErrorMsgKey.AccountEmptyError}</Font></small></TD>
         </TR>
         <TR>
             <TD align="RIGHT">密碼：</TD>
             <TD align="LEFT" ><input	type="password" name="pswd"  size="10"></TD>
             <TD width='120'><small><Font color='red'  size="-1">${ErrorMsgKey.PasswordEmptyError}</Font></small></TD>
         </TR>            
         <TR>
             <TD align="CENTER" colspan='3'><Font color='red' size="-1">${ErrorMsgKey.LoginError}&nbsp;</Font></TD>
             
         </TR>
            
        <TR>
            <TD colspan="2" align="center">      <input type="submit" value="提交"> </TD>
            </TR>
         </Table>        
         
</Form>
</CENTER>
</body>

</html>
