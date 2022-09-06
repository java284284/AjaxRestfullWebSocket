<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' href='../../css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查詢明牌(JSP+JavaBean版 )</title>
</head>
<body>
<h1>了解JavaBean如何封裝功能</h1>
<h3>大樂透(六個介於1-49的數字)</h3> 
<jsp:useBean id="SuperLotteryBean"  class="ch05.ex03.model.LotteryBean"  scope="page" />
<jsp:setProperty property="lowerBound" name="SuperLotteryBean" value="1"/>
<jsp:setProperty property="upperBound" name="SuperLotteryBean" value="49"/>
<jsp:setProperty property="ballNumber" name="SuperLotteryBean" value="6"/>
您的大樂透明牌為:<jsp:getProperty property="luckyNumbers" name="SuperLotteryBean" />
<BR><BR><BR>
<CENTER>
  <small>&lt;&lt;<a href="ch05_05.jsp">再試一次</a>&gt;&gt;</small>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <small>&lt;&lt;<a href="../index.jsp">回第五章首頁</a>&gt;&gt;</small>
  </CENTER>
</body>
</html>