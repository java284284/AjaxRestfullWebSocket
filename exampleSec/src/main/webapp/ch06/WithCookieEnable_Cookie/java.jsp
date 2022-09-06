<%@ page contentType="text/html; charset=UTF-8" session="true" %>
<HTML>

<HEAD>
<TITLE>Java 書籍</TITLE>
</HEAD>

<BODY BGCOLOR="white">

<TABLE BORDER="1" CELLSPACING="0" CELLPADDING="0" WIDTH="720">
<TR HEIGHT="20">
  <TD BGCOLOR="#44AADD" ALIGN="center" VALIGN="middle" HEIGHT="20">
    <B>1) Java 類</B>
  </TD>
  <TD BGCOLOR="#44AA11" ALIGN="center" VALIGN="middle" HEIGHT="20">
    <B>2) XML  類</B>
  </TD>
  <TD BGCOLOR="#44AA11" ALIGN="center" VALIGN="middle" HEIGHT="20">
    <B>3) Net 類</B>
  </TD>
</TR>
</TABLE>

<FORM ACTION="book" METHOD="POST">

<INPUT TYPE="hidden" NAME="bookType" VALUE="JAVA">

<TABLE BORDER="0" CELLSPACING="0" CELLPADDING="5">

<TR HEIGHT="50"><TD HEIGHT="50" COLSPAN="3"><!-- vertical space --></TD></TR>
<TR>

  <TD><INPUT TYPE="checkbox" NAME="javaBook" value="Java 入門, A0001, 511" /></TD>
  <TD ALIGN="LEFT">Java 入門 (書號A0001) </TD>
</TR>
<TR>
  
  <TD><INPUT TYPE="checkbox" NAME="javaBook" value="Java 進階, A0002, 612 " /></TD>
  <TD ALIGN="LEFT">Java 進階 (書號A0002) </TD>
</TR>
<TR>
  
  <TD><INPUT TYPE="checkbox" NAME="javaBook" value="Java Servlet, A0003, 913" /></TD>
  <TD ALIGN="LEFT">Java Servlet (書號A0003) </TD>
</TR>
<TR>
  
  <TD><INPUT TYPE="checkbox" NAME="javaBook" value="JavaServerPage, A0004, 714"/> </TD>
  <TD ALIGN="right">JavaServerPage (書號A0004) </TD>
</TR>

<TR HEIGHT="10"><TD HEIGHT="10" COLSPAN="2"><!-- vertical space --></TD></TR>

<TR>
  <TD></TD>
  <TD><INPUT TYPE="submit" VALUE="下一頁"></TD>
</TR>

</TABLE>

</FORM>

</BODY>

</HTML>
