<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type='text/javascript' src='${pageContext.request.contextPath}/scripts/jquery-1.9.1.min.js'></script>
<title></title>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/style.css'  type="text/css" />
</head>
<body>
<div align='center'>
<h3>會員資料</h3>
<a href='mem'>新增會員資料</a> &nbsp;&nbsp;&nbsp;<a href="<c:url value='/'/> " >回前頁</a>
<hr>
<form method='POST'>
	<input type='hidden' name='_method' value='DELETE'>
</form>

<c:choose>
	<c:when test="${empty memberList}">
	    沒有任何會員資料<br> 
	</c:when>
	<c:otherwise>
		<table border='1' cellpadding="3" cellspacing="1" >
			<tr>
			   <th width='56'>編號</th>
			   <th width='140'>姓名</th>
			   <th width='180'>電郵</th>
			   <th width='130'>生日</th>
			   <th width='64'>體重</th>
			   <th width='56'>嗜好</th>
			   <th width='56'>類型</th>
			   <th width='56'>性別</th>
			   <th>照片</th>
			   <th colspan='2' width='72'>資料維護</th>
			</tr>
			<c:forEach var='member' items='${memberList}'>
				<tr>
					<td style="text-align:center">${member.id}</td>
					<td>${member.name}</td>
					<td>${member.email}</td>
					<td style="text-align:center">${member.birthday}</td>
					<td style="text-align:right">${member.weight}</td>
					<td style="text-align:center">${member.hobby.name}</td>
					<td style="text-align:center">${member.category.name}</td>
					<td style="text-align:center">${member.gender == 'F' ? "女" : "男" }</td>
					<td><img width='60' height='72' src="<c:url value='/crm/crm/picture/${member.id}' />" /></td>
					 <td><a
                        href="${pageContext.request.contextPath}/crm/mem/${member.id}">編輯</a></td>
                    <td><a class='deletelink'
                        href="${pageContext.request.contextPath}/crm/mem/${member.id}">刪除</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:otherwise>
</c:choose>
<hr>
</div>
<script type='text/javascript'>
    $(document).ready(function() {
        $('.deletelink').click(function() {
        	if (confirm('確定刪除此筆紀錄? ')) {
        		var href = $(this).attr('href');
                $('form').attr('action', href).submit();
        	} 
        	return false;
            
        });
    })
</script>
</body>
</html>