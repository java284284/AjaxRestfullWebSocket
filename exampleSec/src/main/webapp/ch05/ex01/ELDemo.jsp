<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' href='../css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL Demo</title>
</head>
<body> 
Case1 屬性物件是字串物件==>透過 EL 來取用，\${識別字串}<BR>
 
<Font Color='darkblue'>${Case1} </Font><P/>
<HR>
Case2 屬性物件是JavaBean物件==>透過 EL 來取用，\${識別字串.JavaBean的性質}<BR>
<Font Color='red'>
訂單編號：${Case2.orderNo} <BR>
訂單日期：${Case2.orderDate} <BR>
客戶編號：${Case2.customerID} <BR>
訂單金額：${Case2.amount} <BR>
 </Font>
<HR>
Case3 屬性物件是Map物件==>透過EL來取用，\${識別字串.鍵值}就可取得對應的value，
如果value為JavaBean則\${識別字串.鍵值.Bean的性質名稱}就可以取得對應的性質<BR>
<Font Color='blue'>
mapkey1對應字串物件：${Case3.mapkey1} <BR>
訂單編號：${Case3.mapkey2.orderNo} <BR>
訂單日期：${Case3.mapkey2.orderDate} <BR>
客戶編號：${Case3.mapkey2.customerID} <BR>
訂單金額：${Case3.mapkey2.amount} <BR>
 </Font>
<HR>
Case4 屬性物件是元素是JavaBean物件的陣列==>搭配JSTL的＜c:forEach＞ 與 EL 來取用<BR>
<Font Color='brown'>
<c:forEach var="aVar" items="${Case4}">
訂單編號：${aVar.orderNo} <BR>
訂單日期：${aVar.orderDate} <BR>
客戶編號：${aVar.customerID} <BR>
訂單金額：${aVar.amount} <BR>
------------------------------------------<BR>
</c:forEach>
 </Font>
<HR>
Case5 屬性物件是元素是JavaBean物件的Collection==>搭配JSTL的＜c:forEach＞與EL 來取用<BR>
<Font Color='purple'>
<c:forEach var="aVar" items="${Case5}">
訂單編號：${aVar.orderNo} <BR>
訂單日期：${aVar.orderDate} <BR>
客戶編號：${aVar.customerID} <BR>
訂單金額：${aVar.amount} <BR>
------------------------------------------<BR>
</c:forEach>
 </Font>
 <HR>
Case6 屬性物件是元素是JavaBean物件的Map==>搭配JSTL的＜c:forEach＞與EL 來取用<BR>
<Font Color='red'>
<c:forEach var="anEnter" items="${Case6}">
Map的Key：${anEnter.key} <BR>
訂單編號：${anEnter.value.orderNo} <BR>
訂單日期：${anEnter.value.orderDate} <BR>
客戶編號：${anEnter.value.customerID} <BR>
訂單金額：${anEnter.value.amount} <BR>
------------------------------------------<BR>
</c:forEach>
 </Font>
<small>&lt;&lt;<a href="index.jsp">回第五章首頁</a>&gt;&gt;</small> 
</body>
</html>