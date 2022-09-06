<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<link rel='stylesheet' href='../css/styles.css'  type='text/css' />
<title>第一個JSP</title></head>
<body>

  <div align="center">
  <h1>動態網頁</h1>
	<table border="1">
		<tr align ="center" bgcolor="99ccff">
		   <td width="80">ID</td><td width="80">姓名</td>
		</tr>
	<%
	    int i;
		String color1="99ccff"; 
		String color2="88cc33";
		int num = (int)(Math.random()*8) + 5;
		for(i=1;i<=num;i++) {
			String color="";
			if(i%2==0) { 
			   color= color1;
			} else { 
			   color = color2; 
			   }
			out.println("<tr align ='center' bgcolor="+color+">");
			out.println("<td >"+i+"</td>");
			out.println("<td> 章君雅 </td>");
			out.println("</tr>");
		}
	%>
	</table> 
  </div>
<p/>
<jsp:include page="/commons/previousPage.jsp" />
</body>
</html>