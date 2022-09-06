<%@ page contentType="text/html; charset=UTF-8" session="true" %>
<HTML>

<HEAD>
<TITLE>Session 觀念</TITLE>
</HEAD>

<BODY BGCOLOR="white">
isSessionNew()= <%= session.isNew() %>
<TABLE BORDER="0" CELLSPACING="0" CELLPADDING="0" WIDTH="600">
<TR>
  <TD COLSPAN="2" BGCOLOR="#CCCCFF" ALIGN="center">
    <H3></H3>
  </TD>
</TR>
</TABLE>

<UL>
  <LI><A HREF="<%= response.encodeURL("java.jsp") %>" >Java類</A></LI>
  <LI><A HREF="<%= response.encodeURL("xml.jsp") %>" >XML 類</A></LI>
  <LI><A HREF="<%= response.encodeURL("net.jsp") %>" >Net 類</A></LI>
</UL>

</BODY>

</HTML>
