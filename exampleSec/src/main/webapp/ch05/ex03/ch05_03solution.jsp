<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<HEAD>
<link rel='stylesheet' href='../../css/styles.css'  type="text/css" />
<style type="text/css">
  table{
    border-collapse: collapse;
    border:3px solid #7A7;
    text-align: center; 
    width:400px; 
    margin: 0 auto; 
  }
  table td{
    border: 1px solid #a56;
  }
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<TITLE>Arithmetic Operations in EL</TITLE>
</HEAD>
<BODY style='text-align:center;'>
  <H1>Arithmetic Operations in EL</H1>
  <table>
    <TR>
      <TD WIDTH='300'>\${10 + 5}</TD>
      <TD WIDTH='100'>${10 + 5}</TD>
    </TR>
    <TR>
      <TD WIDTH='300'>\${10 * 5}</TD>
      <TD WIDTH='100'>${10 * 5}</TD>
    </TR>
    <TR>
      <TD WIDTH='300'>\${10 / 5}</TD>
      <TD WIDTH='100'>${10 / 5}</TD>
    </TR>
    <TR>
      <TD WIDTH='300'>\${10 mod 5}</TD>
      <TD WIDTH='100'>${10 mod 5}</TD>
    </TR>
    <TR>
      <TD WIDTH='300'>\${10 + 2 * 5}</TD>
      <TD WIDTH='100'>${10 + 2 * 5}</TD>
    </TR>
    <TR>
      <TD WIDTH='300'>\${(10 + 2) * 5}</TD>
      <TD WIDTH='100'>${(10 + 2) * 5}</TD>
    </TR>
  </TABLE>
  <P/>
  
  <hr>
  <div style='text-align:left;'>
  客戶端電腦的IP為:<font color='red'>${pageContext.request.remoteHost}</font><br>
  客戶端使用的http方法為:<font color='red'>${pageContext.request.method}</font><br>
  客戶端的瀏覽器為:<font color='red'>${header['user-agent']}</font><br>
  客戶端的瀏覽器送出的請求標頭有:<br>
  <c:forEach var='entry' items='${headerValues}'>
     ${entry.key} ==> 
     <c:forEach items="${entry.value}" varStatus="vs">
      <font color='red'>[${vs.index}]: ${entry.value[vs.index]}</font>
    </c:forEach> <br>
  </c:forEach>
  <p/>
  </div>
  <small>&lt;&lt;<a href="../index.jsp">回第五章首頁</a>&gt;&gt;</small>

</BODY>
</HTML>