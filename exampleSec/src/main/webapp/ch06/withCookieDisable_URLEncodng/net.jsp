﻿<%@ page contentType="text/html; charset=UTF-8" session="true" %>
<HTML>

<HEAD>
<TITLE>網路書籍</TITLE>
</HEAD>

<BODY BGCOLOR="white">

<TABLE BORDER="1" CELLSPACING="0" CELLPADDING="0" WIDTH="720">
<TR HEIGHT="20">
  <TD BGCOLOR="#44AA11" ALIGN="center" VALIGN="middle" HEIGHT="20">
    <B>1) Java 類</B>
  </TD>
  <TD BGCOLOR="#44AA11" ALIGN="center" VALIGN="middle" HEIGHT="20">
    <B>2) XML  類</B>
  </TD>
  <TD BGCOLOR="#44AADD" ALIGN="center" VALIGN="middle" HEIGHT="20">
    <B>3) Net 類</B>
  </TD>
</TR>
</TABLE>

<FORM ACTION="<%= response.encodeURL("book") %>" METHOD="POST">

<INPUT TYPE="hidden" NAME="bookType" VALUE="NET">

<TABLE BORDER="0" CELLSPACING="0" CELLPADDING="5">

<TR HEIGHT="50"><TD HEIGHT="50" COLSPAN="3"><!-- vertical space --></TD></TR>
<TR>

  <TD><INPUT TYPE="checkbox" NAME="netBook" value="網路入門, C0001, 531"/> </TD>
  <TD ALIGN="LEFT">網路入門 (書號C0001) </TD>
</TR>

<TR>
  <TD><INPUT TYPE="checkbox" NAME="netBook" value="網路進階, C0002, 532" /></TD>
  <TD ALIGN="LEFT">網路進階 (書號C0002) </TD>
</TR>

<TR>
  <TD><INPUT TYPE="checkbox" NAME="netBook" value="八十天學會網路, C0003, 633" /></TD>
  <TD ALIGN="LEFT">八十天學會網路 (書號C0003) </TD>
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
