<%@ page session="false" isErrorPage="true" pageEncoding="UTF-8" 
    import="java.io.PrintWriter" %>

<%
  String expTypeFullName
    = exception.getClass().getName();
  String expTypeName
    = expTypeFullName.substring(expTypeFullName.lastIndexOf(".")+1);
  String request_uri
    = (String) request.getAttribute("javax.servlet.error.request_uri");
%>

<HTML>

<HEAD>
<link rel='stylesheet' href='../css/styles.css'  type="text/css" />
<TITLE>JSP Exception Page</TITLE>
</HEAD>

<BODY BGCOLOR='white'>

<TABLE BORDER='0' CELLSPACING='0' CELLPADDING='0' WIDTH='600'>

<TR>
  <TD ALIGN='center' >
     <IMG SRC='images/askduke.gif' ALT='Ask Duke!'>
  </TD>
  <TD BGCOLOR='pink' ALIGN='center'>
    <FONT SIZE='7' COLOR='red'><B><%= expTypeName %></B></FONT>
  </TD>
</TR>

<TR HEIGHT='15'><TD HEIGHT='15'><!-- vertical space --></TD></TR>

<TR>
  <TD></TD>
  <TD>
    <B><%= exception.getMessage() %></B><BR><BR>
    This was the request URI: <BR>
    <CODE><%= request_uri %></CODE><BR><BR>
    This is the complete backtrace of the exception:
    <FONT SIZE='1'>
<PRE>
   <% exception.printStackTrace(new PrintWriter(out)); %>
</PRE>
    </FONT>
  </TD>
</TR>

</TABLE>
<a href='${pageContext.request.contextPath}/ch03'>回第三章</a>
</BODY>

</HTML>
