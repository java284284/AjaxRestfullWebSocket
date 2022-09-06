<%@ page session="false" pageEncoding="UTF-8" errorPage="error/ExceptionPage.jsp" %>
<%-- This page will cause an "divide by zero" exeception --%>
<HTML>
<HEAD>
<link rel='stylesheet' href='../css/styles.css'  type="text/css" />
<TITLE>本網頁可能含有例外</TITLE>
</HEAD>

<BODY BGCOLOR='white'>

<OL>
<%
   for ( int i=10; i > -10; i-- ) {
%>
  <LI><%= 100/i %></LI>
<%
   }
%>
</OL>

</BODY>

</HTML>
