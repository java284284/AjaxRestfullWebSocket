<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script>
	window.onload = function() {
		var alink = document.getElementById("accountCheck");
		var div = document.getElementById('result0c');
		alink.onclick = function() {
			var id = document.getElementById("id").value;
			if (!id) {
				div.innerHTML = "<font color='blue' size='-1'>請輸入帳號</font>";
				return;
			}
			var xhr = new XMLHttpRequest();
			xhr.open("POST", "<c:url value='/ch04/_02/CheckMemberId' />", true);
			xhr.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded");
			xhr.send("id=" + id);
			var message = "";
			xhr.onreadystatechange = function() {
				// 伺服器請求完成
				if (xhr.readyState == 4 && xhr.status == 200) {
					var result = JSON.parse(xhr.responseText);

					if (result.id.length == 0) {
						message = "帳號可用";
					} else if (result.id.startsWith("Error")) {
						message = result.id;
					} else {
						message = "帳號重複，請重新輸入帳號";
					}
					div.innerHTML = "<font color='red' size='-2'>" + message
							+ "</font>";
				}
			}
		}
		var sendData = document.getElementById("sendData");
		sendData.onclick = function() {
			// 讀取欄位資料	  
			var id = document.getElementById("id").value;
			var name = document.getElementById("name").value;
			var balance = document.getElementById("balance").value;
			var birthday = document.getElementById("birthday").value;

			var hasError = false; // 設定判斷有無錯誤的旗標
			var div0 = document.getElementById('result0c');
			var div1 = document.getElementById('result1c');
			var div2 = document.getElementById('result2c');
			var div3 = document.getElementById('result3c');
			var divResult = document.getElementById('resultMsg');
			if (!id) {
				div0.innerHTML = "<font color='red' size='-2'>請輸入帳號</font>";
				hasError = true;
			} else {
				div0.innerHTML = "";
			}
			if (!name) {
				div1.innerHTML = "<font color='red' size='-2'>請輸入姓名</font>";
				hasError = true;
			} else {
				div1.innerHTML = "";
			}
			if (!balance) {
				div2.innerHTML = "<font color='red' size='-2'>請輸入餘額</font>";
				hasError = true;
			} else {
				div2.innerHTML = "";
			}
			if (!birthday) {
				div3.innerHTML = "<font color='red' size='-2'>請輸入生日</font>";
				hasError = true;
			} else {
				div3.innerHTML = "";
			}
			if (hasError) {
				return false;
			}
			var xhr1 = new XMLHttpRequest();
			xhr1.open("POST", "<c:url value='/ch04/_02/AddMember.do' />", true);
			xhr1.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded");
			xhr1.send("id=" + id + "&name=" + name + "&balance=" + balance
					+ "&birthday=" + birthday);
			xhr1.onreadystatechange = function() {
				// 伺服器請求完成
				if (xhr1.readyState == 4 && xhr1.status == 200) {
					result = JSON.parse(xhr1.responseText);
					if (result.fail) {
						divResult.innerHTML = "<font color='pink' >"
								+ result.fail + "</font>";
					} else if (result.success) {
						divResult.innerHTML = "<font color='GREEN'>"
								+ result.success + "</font>";
						div0.innerHTML = "";
						div1.innerHTML = "";
						div2.innerHTML = "";
						div3.innerHTML = "";
					} else {
						if (result.idError) {
							div0.innerHTML = "<font color='green' size='-2'>"
									+ result.idError + "</font>";
						} else {
							div0.innerHTML = "";
						}
						if (result.nameError) {
							div1.innerHTML = "<font color='green' size='-2'>"
									+ result.nameError + "</font>";
						} else {
							div1.innerHTML = "";
						}
						if (result.balanceError) {
							div2.innerHTML = "<font color='green' size='-2'>"
									+ result.balanceError + "</font>";
						} else {
							div2.innerHTML = "";
						}
						if (result.birthdayError) {
							div3.innerHTML = "<font color='green' size='-2'>"
									+ result.birthdayError + "</font>";
						} else {
							div3.innerHTML = "";
						}
					}
				}
			}
		}

	}
</script>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
	<div align='center'>
		<h3>輸入會員資料</h3>
		<div id='resultMsg' style="height: 18px; font-weight: bold;"></div>
		<fieldset style='display: inline-block; width: 820px;'>
			<legend>填寫下列資料</legend>
			<table border='1'>
				<tr height='60'>
					<td width='200'>&nbsp;</td>
					<td width='400'>&nbsp;帳號: <input type="text" name="id" id='id'><br>
						<div style='font-size: 10pt; text-align: center;'>
							<a href='#' id='accountCheck' style='font-size: 10pt;'>檢查帳號</a>
						</div>
					</td>
					<td width='200'>
						<div id='result0c' style="height: 10px;"></div>
						<br>
						<div id='result0s' style="height: 10px;"></div>
					</td>
				</tr>
				<tr height='60'>
					<td width='200'>&nbsp;</td>
					<td width='400'>&nbsp;姓名: <input type="text" name="name"
						id='name'><br>
					</td>
					<td width='200' style="vertical-align: top">
						<div id='result1c' style="height: 10px;"></div>
						<br>
						<div id='result1s' style="height: 10px;"></div>
					</td>
				</tr>
				<tr height='60'>
					<td width='200'>&nbsp;</td>
					<td width='400'>&nbsp;餘額: <input type="text" name="balance"
						id='balance'><br>
					</td>
					<td width='200' style="vertical-align: top">
						<div id='result2c' style="height: 10px;"></div>
						<br>
						<div id='result2s' style="height: 10px;"></div>
					</td>
				</tr>
				<tr height='60'>
					<td width='200'>&nbsp;</td>
					<td width='400'>&nbsp;生日: <input type="text" name="birthday"
						id='birthday' size='24'>
					</td>
					<td width='200'>
						<div id='result3c' style="height: 10px;"></div>
						<br>
						<div id='result3s' style="height: 10px;"></div>
					</td>
				</tr>
				<tr height='50'>
					<td colspan='3' align='center'><button id='sendData'>送出</button></td>
				</tr>
			</table>
		</fieldset>
		<hr>
		<p>
			<a href="<c:url value='/ch04/' />">回前頁</a>
		<hr>
		<small>
			按下"檢查帳號"超連結後，前端的JavaScript會先進行ㄧ些檢查，然後向後端程式(ch04._02.controller.CheckMemberIdServlet.java)發出非同步請求。
			該程式會請Model元件(ch04._02.model.MemberDaoImpl.java)代為檢查帳號是否可用(dao.checkMemberId(id);)
			接著將該方法傳回的資料(id)放入Map物件(map)內，由Gson的toJson()方法
			將map物件轉為JSON格式的資料，最後由out物件將此資料寫出給前端程式。<br>
			按下"送出"按鈕後，瀏覽器向後端程式(ch04._02.controller.AddMemberServlet.java)發出非同步請求，
			該程式會進行Controller的標準功能：(1)讀取使用者輸入資料，(2)進行必要的型態轉換(本程式不需要)，(3)檢查輸入資料，
			(3-1)如果輸入資料有誤，將錯誤訊息送回前端，請使用者修正，(4)呼叫Model元件(ch04._02.model.MemberDaoImpl.java)
			進行企業邏輯運算，(5)依照企業邏輯運算的結果送回適當的訊息。
			要寫回的訊息都先放入Map物件(map)內，再由Gson的toJson()方法將map物件轉為JSON格式的資料，最後由out物件寫出給前端程式。
		</small>
	</div>

</body>
</html>