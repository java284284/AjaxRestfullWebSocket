<%@ page contentType="text/html; charset=UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>  
<head>
<link rel='stylesheet' href='css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Filter</title>
</head>

<body bgcolor='white'>

<!-- Page Heading -->
<table border='1' cellpadding='5' cellspacing='0' width='400'>
<tr bgcolor='#CCCCFF' align='center' height='20'>
  <td><h3>Filter Demo</h3></td>
</tr>
</table>
<h3>Filter功能展示</h3>
<ol>
<li>


效能檢視過濾器&nbsp;&nbsp;<font size='-1'>先按這裡產生資料表格&nbsp;&nbsp;
<a href="<c:url value='CreateTableServlet?type=MySQL' />">MySQL</a>&nbsp;&nbsp;&nbsp;
<a href="<c:url value='CreateTableServlet?type=SQLServer' />">SQLServer</a>
</font><font color='red'>&nbsp;&nbsp; ${ Message }</font><BR>

&nbsp;&nbsp;<a href="<c:url value='DriverManagerServlet' />">透過 DriverManager存取資料庫</a>
&nbsp;&nbsp; ${DM}<BR>
&nbsp;&nbsp;<a href="<c:url value='DataSourceServlet' />">透過 DataSource存取資料庫</a>
&nbsp;&nbsp; ${DS}<BR>
<P/>
<li>
 <a href="<c:url value='TopSecret' />">資源監視過濾器</a><BR>
&nbsp;&nbsp;任何人執行TopSecretServlet將被紀錄
<P/>
<li>
<P/>經由Servlet的url-pattern啟動Filter<BR>
<a href="<c:url value='urlPattern' />">執行URLPatternServlet</a>
<P/>
<li>
<P/>經由Servlet的servlet-name啟動Filter<BR>
<a href="<c:url value='servletName' />">執行ServletNameServlet</a><BR>
<P/>
<li>
<P/>一個Servlet配置多個Filters<BR>
<a href='hello'>觀察多個Filters的執行順序</a><BR>
<P/>
<li>

<P/>有條件的啟動Filter(&lt;dispatcher&gt;INCLUDE&lt;/dispatcher&gt;)<br>
<a href="<c:url value='Main_Include' />">執行 ch08.ex04.Main_IncludeServlet (它會include另外一個Servlet:NextServlet)</a><BR>
<a href="<c:url value='IncludeNextS' />">直接執行 ch08.ex04.NextServlet (直接執行此Servlet)</a><BR>
<P/>
<li>
<P/>有條件的啟動Filter(&lt;dispatcher&gt;FORWARD&lt;/dispatcher&gt;)<br>
<a href="<c:url value='Main_Forward' />">執行 ch08.ex04.Main_ForwardServlet (它會forward另外一個Servlet:NextServlet)</a><BR>
<a href="<c:url value='ForwardNextS' />">直接執行 ch08.ex04.NextServlet (直接執行此Servlet)</a><BR>
</ol>
<hr>
<jsp:include page="/commons/footer.jsp" />
</body>
</html>
