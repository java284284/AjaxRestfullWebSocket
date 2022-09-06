<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='../../css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Members</title>
</head>
<body>

<div align="center">
		    <c:forEach var="mem"  varStatus="statusX" items="${AllMembers}">
                   <c:if test="${statusX.first}" >
                        <c:out value="<table border='1' cellspacing='5' cellpadding='5' >" escapeXml="false"/>
      		          	    <tr bgcolor="CCCC00">
			                    <td  colspan='5' ALIGN='CENTER'>會員基本資料</td>
			                </tr>
			                <tr  bgcolor="CCCC00">
			                    <th>帳 號</th><th>姓 名</th><th>eMail</th><th>電話</th><th>Java經驗</th>
			                </tr>
                    </c:if>		         
                    <c:choose>
                             <c:when test="${ statusX.count % 2 == 0 }">
                                  <c:set var="colorVar" value="99ddff" />
                             </c:when>
                             <c:otherwise>
                                  <c:set var="colorVar" value="88dd00" />
                             </c:otherwise>
                   </c:choose>
                    
                    <tr bgcolor="${colorVar}">
                         <td>${mem.userId}</td>
                         <td>${mem.name} </td>
                         <td>${mem.email}</td>
                         <td>${mem.tel} </td>
                         <td>${mem.experience}</td>
                    </tr>
                     <c:if test="${statusX.last}" >
                        <c:out value="</table>" escapeXml="flase" />
                    </c:if>		                      
		    </c:forEach>
</div>

<jsp:include page="/commons/previousPage.jsp" />
</body>
</html>