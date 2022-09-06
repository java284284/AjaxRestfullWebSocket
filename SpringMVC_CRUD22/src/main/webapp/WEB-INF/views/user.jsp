<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head><title>Create User</title></head>
<body>
<table>
  <form:form action="save" method="post" commandName="user">
	<tr>  <td>User Name:</td> <td><form:input  path="name"/> </td> 
	      <td> <form:errors path="name" cssStyle="color: red;"/></td> </tr>
	<tr> <td> Password :</td> <td><form:input path="password"/> </td> 
	     <td> <form:errors path="password" cssStyle="color: red;"/> </td> </tr>
	<tr> <td>  Email :</td> <td><form:input path="email"/> </td> 
	     <td> <form:errors path="email" cssStyle="color: red;"/> </td> </tr>
	<tr> <td>  Date of Birth :</td> <td><form:input path="dob"/> </td> 
	     <td> <form:errors path="dob" cssStyle="color: red;"/> </td> </tr>	     
	<tr> <td colspan=3>   <input type="submit"> </td>
  </form:form>
</table>   
</body>
</html> 