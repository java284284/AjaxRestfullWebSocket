<%@ page contentType="text/html; charset=UTF-8" session="true" %>
<HTML>

<HEAD>
<TITLE>XML 書籍</TITLE>
</HEAD>

<BODY BGCOLOR="white">

<TABLE BORDER="1" CELLSPACING="0" CELLPADDING="0" WIDTH="720">
<TR HEIGHT="20">
  <TD BGCOLOR="#44AA11" ALIGN="center" VALIGN="middle" HEIGHT="20">
    <B>1) Java 類</B>
  </TD>
  <TD BGCOLOR="#44AADD" ALIGN="center" VALIGN="middle" HEIGHT="20">
    <B>2) XML  類</B>
  </TD>
  <TD BGCOLOR="#44AA11" ALIGN="center" VALIGN="middle" HEIGHT="20">
    <B>3) Net 類</B>
  </TD>
</TR>
</TABLE>

<FORM ACTION="<%= response.encodeURL("book") %>" METHOD="POST">

<INPUT TYPE="hidden" NAME="bookType" VALUE="XML">

<TABLE BORDER="0" CELLSPACING="0" CELLPADDING="5">

<TR HEIGHT="50"><TD HEIGHT="50" COLSPAN="3"><!-- vertical space --></TD></TR>
<TR>

  <TD><INPUT TYPE="checkbox" NAME="xmlBook" value="XML 入門, B0001, 521" /></TD>
  <TD ALIGN="LEFT">XML 入門 (書號B0001) </TD>
</TR>

<TR>
  <TD><INPUT TYPE="checkbox" NAME="xmlBook" value="XML 進階, B0002, 522 " /></TD>
  <TD ALIGN="LEFT">XML 進階 (書號B0002) </TD>
</TR>

<TR>
  <TD><INPUT TYPE="checkbox" NAME="xmlBook" value="九十天學會 XML  , B0003, 623" /></TD>
  <TD ALIGN="LEFT">九十天學會 XML  (書號B0003) </TD>
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
