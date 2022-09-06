<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
<style type="text/css">
#column1 {
display: inline-block


}
#column2 {
display: inline-block
}

#column3 {
position:absolute;
left:535px;
top:480px;
}
#column4 {
display: inline-block
}
</style>
<meta charset="UTF-8">
<title>Tomcat的資源控管機制</title>
</head>
<body>


<div class='center'>
<h1>Tomcat的資源控管機制</h1>
</div>
<div class='center'>
<div id='column1'>
<h2>需要登入</h2>
<a href="<c:url value='_07/queryLottery.jsp'  />">問單一明牌(角色: supervisor)</a><br/>
<a href="<c:url value='_07/queryLottery2.jsp'  />">問多種明牌(角色: supervisor)</a><br/>
<a href="<c:url value='_08/hello.jsp'  />">大家好(角色: agent)</a><br/> 
<a href="<c:url value='_09/list.jsp'  />">顯示會員資料(角色: supervisor, agent)</a><br/>
</div>
<div id='column4'>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</div>
<div id='column2'>
<h2>不需要登入</h2>
<a href="<c:url value='_10/queryLottery.jsp'  />">問單一明牌</a><br/>
<a href="<c:url value='_10/queryLottery2.jsp'  />">問多種明牌 </a><br/>
<a href="<c:url value='_11/hello.jsp'  />">大家好(Hello, World)</a><br/>
<a href="<c:url value='_12/list.jsp'  />">顯示會員資料</a><p/>
</div>	
</div>

<div class='center'>
<small>&lt;&lt;<a href="${pageContext.servletContext.contextPath}">回首頁</a>&gt;&gt;</small>
</div>
</body>
</html>