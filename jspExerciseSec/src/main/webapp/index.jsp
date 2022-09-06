<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
#column1 {
position:absolute;
left:50px;
top:80px;
}
#column2 {
position:absolute;
left:450px;
top:80px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP 課堂作業</title>
</head>

<body>

<h1>JSP 課堂作業</h1>
<div id='column1'>
<a href="<c:url value='ch01/queryLottery.jsp'  />">問單一明牌</a><p/>
<a href="<c:url value='ch01/queryLottery2.jsp'  />">問多種明牌</a><p/>
<a href="<c:url value='ch02/InsertMemberForm.jsp'  />">加入會員</a><p/>
<a href="<c:url value='ch03/hello.jsp'  />">大家好(Hello, World)</a><p/> 
<a href="<c:url value='ch04_01/InsertMemberForm.jsp'  />">加入會員(MVC)</a><p/> 
<a href="<c:url value='ch04_02/InsertMemberForm.jsp'  />">加入會員(DB)</a><p/>
<a href="<c:url value='ch05_03/InsertMemberForm.jsp'  />">加入會員(顯示錯誤訊息)</a><p/>
<a href="<c:url value='ch05_04/queryLottery.jsp'  />">問單一明牌(Lab05_04)</a><p/>
<a href="<c:url value='ch05_05/queryLottery.jsp'  />">JSTL c:set練習 (Lab05_05)</a><p/>
<a href="<c:url value='ch05_08/queryLottery2.jsp'  />">JSTL 條件判斷練習 (Lab05_08)</a><p/>
<a href="<c:url value='ch05_09/ShowMember.jsp'  />">顯示會員資料(Lab05_09)</a><p/>

</div>
<div id='column2'>
<a href="<c:url value='ch06_01/login.jsp'  />">登入(Lab06_01)</a><p/>
<a href="<c:url value='ch06_01/logout.jsp'  />">登出(Lab06_01)</a><p/>
<a href="<c:url value='ch06_02/InsertMemberForm.jsp'  />">加入會員(顯示錯誤訊息)(Lab06_02)</a><p/>
<a href="<c:url value='ch07_01/InsertMemberForm.jsp'  />">加入會員(起始參數)(Lab07_01)</a><p/>
<a href="<c:url value='ch07_02/ShowMember.jsp'  />">顯示會員資料(Lab07_02)</a><p/>
</div>
</body>
</html>