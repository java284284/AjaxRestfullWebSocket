<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' href='../css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>加入會員</title>
</head>
<body>
<h2>加入會員</h2> 
<Form action="MemberServlet" method="POST"> 
    會員代號:<input type="text" name="userId" size = "10"><P/>
    密碼:<input type="password" name="pswd" size = "20"><P/>
    電郵:<input type="text" name="email" size = "50"><P/>
    性別:<input type="radio" name="gender" value='M'/>男生&nbsp;&nbsp;&nbsp;
       <input type="radio" name="gender" value='F'/>女生<P/>
    
    嗜好:<BR>
  <input type="checkbox" name="hobby" value="swimming">游泳<BR>
  <input type="checkbox" name="hobby" value="programming">程式設計<BR>
  <input type="checkbox" name="hobby" value="music">聽音樂<BR><BR><P/>
         <input type="submit" value="確定"><P/>
</Form>
<small>&lt;&lt;<a href="index.jsp">回前頁</a>&gt;&gt;</small>
</body>
</html>