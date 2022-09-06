<%@ page language="java" contentType="text/html; charset=UTF-8"%> 
<%@ page info="a hello world example" %>
<html>
	<head>
    	<link rel='stylesheet' href='../css/styles.css'  type='text/css' />
		<title>理解JSP的原理</title>
	</head>
	<body>
	
		<h1>
		<%
		int times = 5 ; 
		try { 
		    times=Integer.parseInt(request.getParameter("times"));
		} catch(NumberFormatException e) {
			;
		}
		for (int i=0;i<times;i++) {
		    out.println(" Hello, World! ");
		    out.println("<br>");
		}
		%>
		</h1>
<p/>
<a href="<%=request.getContextPath()%>/ch03/" ><small>回第三章首頁</small></a>
	</body>
</html>
