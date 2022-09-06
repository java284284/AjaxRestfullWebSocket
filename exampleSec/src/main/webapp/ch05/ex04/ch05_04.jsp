<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='../../css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL 版 </title>
</head>
<body>
<h1>使用EL來顯示放在JavaBean內的資料</h1>
<h3>
本表單將輸入資料傳給 Controller(ch05.ex04.controller.ELVersionController.java)，<BR>
Controller使用JavaBean封裝收到的資料，然後將JavaBean放在request範圍內，<BR>
forward 給View(/ch05/ex04/resultFinalELVersion.jsp)，<BR>
View使用EL取出並顯示放在JavaBean內的資料
 </h3>
<P/> 
<form   method="post"  action="elfinal.do"   >
  姓名：<input type="text" name="name"  size="20" /> <BR>
  編號：<input type="text" name="empID" size="20" /> <BR><P/>
    <input type="submit"  />
</form>
<p/><p/>
<small>&lt;&lt;<a href="../index.jsp">回第五章首頁</a>&gt;&gt;</small>
</body>
</html>