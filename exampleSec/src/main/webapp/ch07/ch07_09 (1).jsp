<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css' type='text/css' />
<style>
        .coff:hover{
        	background-color:red;
        	font-style: italic;
        	color: #FAFAFA;
        }
    </style>
<TITLE>Coffee Catalog</TITLE>
</HEAD>
<BODY BGCOLOR='white'>
	<TABLE BORDER='5' CELLSPACING='5' align="center">
		<TR>
			<TD><TABLE BORDER='0' CELLSPACING='0' CELLPADDING='0'
					bgcolor='eedd82' WIDTH='600'>
					<TR HEIGHT='30'>
						<TD BGCOLOR='#CCCCFF'>&nbsp;</TD>
					</TR>
					<TR>
						<TD BGCOLOR='#CCCCFF' height='60' ALIGN='center' VALIGN='middle'>
							<H3>咖啡目錄</H3>
						</TD>
					</TR>
				</TABLE>
				<TABLE BORDER='2' CELLPADDING='5' WIDTH='600' bgcolor='eedd82'>
					<c:forEach var="c" items="${COFFEE_LIST}" varStatus="vs">
						<c:if test="${vs.first}">
							<TR>
								<TH>代號</TH>
								<TH>咖啡</TH>
								<TH>價格</TH>
								<TH>折扣</TH>
							</TR>
						</c:if>
						<c:set var="color" value="#2ECCFA"/>
						<c:if test="${vs.count % 2 == 0}">
							<c:set var="color" value="#64FE2E" />
						</c:if>
						<TR bgcolor="${color}" class="coff" >
							<TD style='text-align: right;'>${c.coffeeCode}&nbsp;&nbsp;&nbsp;&nbsp;</TD>
							<TD>${c.coffeeName}</TD>
							<TD style='text-align: right;'>${c.discount}</TD>
							<TD style='text-align: center;'>${c.price}</TD>
						</TR>
					</c:forEach>
				</TABLE></TD>
		</TR>
	</TABLE>
	<br>
	<div align="center">
	<font color='red' style="margin: auto"><small>本畫面直接由JSP產生</small></font>
	<hr>
	<small>&lt;&lt;<a href='index.jsp'>回前頁</a>&gt;&gt;</small>
	</div>
</BODY>
</HTML>