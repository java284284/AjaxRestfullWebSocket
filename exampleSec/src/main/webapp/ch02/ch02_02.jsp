<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style>

</style>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel='stylesheet' href='../css/styles.css'  type="text/css" />    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>瀏覽器送出POST命令的時機</title>
</head>
<body>

<TABLE Border='3' width="90%" style="position:relative; left:50px;"  CELLPADDING='10' BORDERCOLOR='green' bgcolor='#ffe4e1'>
<TR><TH colspan='2' style="font-size:1.5em;">瀏覽器送出POST命令的時機</TH></TR>
<TR>
    <TD colspan='2' align='center'>
      <TABLE border='1' CELLPADDING='5'>
         <TR><TH> 1.利用表單輸入資料(Form的method屬性為POST)
         </TH></TR>    
         <TR><TD align="center">
            <Form Action="../ch02/survey.do" method="POST">
            <table width='640px' CELLPADDING='10' style="border-collapse:collapse;" borderColor="blue" border='1' >
            <tr>
            <td width='50%'>
              <p >姓名: <input	type="text" size='5' name="userName" value="李大華"></p>
              <p >EMail: <input type="text" size='15' name="eMail" value="user@ppp.com.tw"></p>
              <p >電話號碼 <input type="text" size='10' name="tel" > </p>
              </td>
              <td width='50%'>
              
               請挑選喜歡的水果:<br>
                  <INPUT TYPE='checkbox' NAME='fruit' VALUE='香蕉'> 香蕉 <BR>      
                  <INPUT TYPE='checkbox' NAME='fruit' VALUE='橘子'> 橘子 <BR>
                  <INPUT TYPE='checkbox' NAME='fruit' VALUE='蘋果'> 蘋果 <BR>
                  <INPUT TYPE='checkbox' NAME='fruit' VALUE='西瓜'> 西瓜 <BR>
                  <INPUT TYPE='checkbox' NAME='fruit' VALUE='梨子'> 梨子 <BR><P/>
              
                  </td>
                  </tr>
                  <tr><td style="text-align:center; " colspan='2'>
                  <input   type="submit" value="提交">
                  </td></tr>
                  
                  
                  </table>
                  
            </Form>
         </TD></TR>
      </TABLE>
    </TD>
</TR>
</TABLE>     

<P/>
<small>&lt;&lt;<a href="index.jsp">回前頁</a>&gt;&gt;</small>
</body>
</html>