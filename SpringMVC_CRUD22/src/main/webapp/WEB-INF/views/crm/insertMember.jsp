<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<style type="text/css">
   span.error {
	color: red;
	display: inline-block;
	font-size: 10pt;
}
</style>
<meta charset="UTF-8">
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/style.css'  type="text/css" />
</head>
<body>
<fieldset>
	<legend >新增會員資料(Member)</legend> 
	<form:form method="POST" modelAttribute="member" enctype='multipart/form-data'>
	<Table align="center">
		<c:choose>
			<c:when test='${member.id == null}'>
				<br>
				<tr>
					<td>帳號：<br>&nbsp;
					</td>
					<td width='360'><form:input path='account' /><br>&nbsp;
					<form:errors path="account" cssClass="error" /></td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<td>帳號：<br>&nbsp;
					</td>
					<td><form:hidden path='account' /> ${member.account}<br>&nbsp;
					</td>
				</tr>
			</c:otherwise>
		</c:choose>

				<tr>
	      <td>姓名：<br>&nbsp;</td>
		  <td  width='360'><form:input path='name' /><br>&nbsp;	
		      <form:errors path='name' cssClass="error"/>
		  </td>
		  <td>電郵：<br>&nbsp;</td>
	      <td  width='360'>
	      	<form:input path="email"/><br>&nbsp;	
		      <form:errors path='email' cssClass="error"/>
		  </td>
	   </tr>
	   <tr>
	      <td>生日：<br>&nbsp;</td>
	   	  <td>
	      	<form:input path="birthday"/><br>&nbsp;	
		      <form:errors path='birthday' cssClass="error"/>
		  </td>
		   <td>體重：<br>&nbsp;</td>
	   	  <td>
	      	<form:input path="weight"/><br>&nbsp;	
		      <form:errors path='weight' cssClass="error"/>
		  </td>
	   </tr>	   
	  	   
	   <tr>
	      <td>嗜好：<br>&nbsp;</td>
	   	  <td>
<%-- 			<form:select path="hobby.id" > --%>
		  <form:select path="hobby.id" >
				<form:option value="-1" label="請挑選" />
				
				<form:options  items="${hobbyList}"
	   	  	       itemLabel='name' itemValue='id'/>
	   	  	</form:select><br>&nbsp;
	   	  <form:errors path="hobby"  cssClass="error"/>
	   	  </td>
	   	   <td>分類：<br>&nbsp;</td>
	   	  <td>
	   	  	<form:select path="category.id">
	   	  		<form:option value="-1" label="請挑選" />
				<form:options  items="${categoryList}"
	   	  	   			itemLabel='shortName' itemValue='id'/>
	   	  	</form:select><br>&nbsp;
	   	   <form:errors path="category"  cssClass="error" /></td>
	   </tr>
	   <tr>
	      <td>性別：<br>&nbsp;</td>
	   	  <td>
	   	  	<form:radiobuttons path="gender" items='${genderMap}'/><br>&nbsp;
	   	  	   <form:errors path="gender"  cssClass="error" />
	   	  </td>
	   	  <td>照片：<br>&nbsp;</td>
	   	  <td>
	   	  	 <form:input path="productImage" type='file'/><br>&nbsp;
	   	  	 <form:errors path="productImage"  cssClass="error" />
	   	  </td>
	   </tr>
	   <tr>
	    <td colspan='4' align='center'><br>&nbsp;
	      <input type='submit'>
        </td>
	   </tr>
	</Table>
		 
	</form:form>
	
</fieldset>
<br>
<a href="<c:url value='/crm/showAllMembers'/> " >回前頁</a>
</body>
</html>