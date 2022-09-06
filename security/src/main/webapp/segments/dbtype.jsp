<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>

<c:choose>
<c:when test="${dbtype == 'mysql'}">
使用資料庫  :<input type='radio' name='dbtype' value='mysql' checked='checked'>MySQL &nbsp;&nbsp;&nbsp;   
         <input type='radio' name='dbtype' value='sqlserver'>SQL Server&nbsp;&nbsp;&nbsp;
</c:when>         
<c:otherwise>
使用資料庫  :<input type='radio' name='dbtype' value='mysql'>MySQL &nbsp;&nbsp;&nbsp;   
         <input type='radio' name='dbtype' value='sqlserver' checked='checked'>SQL Server&nbsp;&nbsp;&nbsp;
</c:otherwise>
</c:choose>