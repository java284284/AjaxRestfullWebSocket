<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<jsp:useBean id="myBean" class="ch05_04.LotteryBean" scope="page" >
<%-- 
   <jsp:setProperty name="myBean" property="lowerBound" value="1" />
   <jsp:setProperty name="myBean" property="upperBound" value="49" />
   <jsp:setProperty name="myBean" property="ballNumber" value="6" />
   <c:set target="${myBean}" property="lowerBound" value="1" /> 
   <c:set target="${myBean}" property="upperBound" value="49" />
   <c:set target="${myBean}" property="ballNumber" value="6" />
--%>   
</jsp:useBean> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
   request.setCharacterEncoding("UTF-8");
%>
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${subTitle}</title>
</head>
<body>
<H2>卜籤求明牌</H2>   
<%-- ${param.visitor}，您好，<BR>--%>
<c:if  test="${empty param.visitor}" >
     訪客
</c:if>
${param.visitor}，您好，<BR> 
<c:choose>
   <c:when test="${param.numberType eq 'BIG' }">
      <c:set target="${myBean}" property="lowerBound" value="1" /> 
      <c:set target="${myBean}" property="upperBound" value="49" />
      <c:set target="${myBean}" property="ballNumber" value="6" />
   </c:when>
   <c:when test="${param.numberType eq 'MID' }">
      <c:set target="${myBean}" property="lowerBound" value="1" /> 
      <c:set target="${myBean}" property="upperBound" value="42" />
      <c:set target="${myBean}" property="ballNumber" value="6" />
   </c:when>
   <c:when test="${param.numberType eq 'SMALL' }">
      <c:set target="${myBean}" property="lowerBound" value="1" /> 
      <c:set target="${myBean}" property="upperBound" value="39" />
      <c:set target="${myBean}" property="ballNumber" value="5" />
   </c:when>
   <c:when test="${param.numberType eq 'FOURSTARS' }">
      <c:set target="${myBean}" property="lowerBound" value="0" /> 
      <c:set target="${myBean}" property="upperBound" value="9" />
      <c:set target="${myBean}" property="ballNumber" value="4" />
   </c:when>
</c:choose>  
您的明牌為：
<c:choose>
  <c:when test="${param.numberType != 'FOURSTARS' }">
    ${myBean.luckyNumbers}<BR>
  </c:when>
  <c:otherwise>
    ${myBean.fourStars}<BR>
  </c:otherwise>
</c:choose>

</body>
</html>