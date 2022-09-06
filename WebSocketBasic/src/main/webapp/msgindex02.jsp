<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="css/styles.css" type="text/css" />
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.onload = function() {
		const ws_host_port = "ws://localhost:8080/";
		const contextPath = "WebSocketBasic/";
		const endpoint = "chatserver02";
		const connString = ws_host_port + contextPath + endpoint;
		const status = document.getElementById('status');
		var btnConn = document.getElementById('btnConn');
		var btnSend = document.getElementById('btnSend');
		var btnClose = document.getElementById('btnClose');
		
		var no = document.getElementById('no');
		var name = document.getElementById('name');
		var chi = document.getElementById('chi');
		var eng = document.getElementById('eng');
		var mat = document.getElementById('mat');
		var serverResponseArea = document.getElementById('serverResponseArea');
		var socket = null;
		btnClose.disabled = true;
		btnSend.disabled = true;

		btnSend.onclick = function() {
			if (socket == null) {
				status.innerHTML = "必須先連到主機才能送訊息";
				return;
			}

			if (name.value.length == 0 || no.value.length == 0 || chi.value.length == 0 || eng.value.length == 0 || mat.value.length == 0) {
				status.innerHTML = "尚未輸入資料，無法送出";
				return;
			}
			if (name.value.length > 0) {
				var sendMsg = {};
				sendMsg.no = no.value;
				sendMsg.name = name.value;
				sendMsg.chi = chi.value;
				sendMsg.eng = eng.value;
				sendMsg.mat = mat.value;
				jsonstr = JSON.stringify(sendMsg);   	// 將物件轉為JSON字串 
				socket.send(jsonstr);
//  				alert(jsonstr);
			}

		}
		btnConn.onclick = function() {
			socket = new WebSocket(connString);

			socket.onopen = function(e) {
				status.innerHTML = "已連線";
			};

			socket.onmessage = function(event) {
				var obj = JSON.parse(event.data);
// 				alert(event.data);
				appendMsg("Server: " + event.data);
			};
			btnClose.disabled = false;
			btnSend.disabled = false;
			socket.onclose = function(event) {
				if (event.wasClean) {
					status.innerHTML = "[close] 連線正常關閉, code=" + event.code
							+ ", reason= " + event.reason;
				} else {
					status.innerHTML = "[close] 連線不正常結束";
				}
				btnClose.disabled = true;
				btnSend.disabled = true;
				
			};

			socket.onerror = function(error) {
				alert("[error] 連線發生錯誤，原因：" + error.message);
			};
		}
		btnClose.onclick = function() {
			if (socket == null) {
				status.innerHTML = "必須先連到主機才能關閉連線";
				return;
			}
			if (socket.readyState === WebSocket.OPEN) {
				socket.onclose = function() {}; // disable onclose handler first
				socket.close();
				status.innerHTML = "已離線";
			}

			btnClose.disabled = true;
			btnSend.disabled = true;
		}
	}
	function appendMsg(message) {
		serverResponseArea.value = serverResponseArea.value + message + "\n";
	}
</script>
</head>
<body>
  <div align='center'>
	<button id='btnConn'>連結WebSocket主機</button>
	&nbsp;
	<span id='status'></span>
	<br>
	<button id='btnClose'>關閉與主機的連線</button>
	<hr>
	學號：<input type='text' id='no' size='5' value='stu001'>&nbsp;
	姓名：<input type='text' id='name' size='8' value='林小真' >&nbsp;
	國文：<input type='text' id='chi' size='3'  value='75.8'>&nbsp;
	英文：<input type='text' id='eng' size='3'  value='70' >&nbsp;
	數學：<input type='text' id='mat' size='3'  value='55.0'>&nbsp;
	<button id='btnSend'>送出訊息</button>
	<hr>
	<textarea cols='60' rows='16' id='serverResponseArea'>
</textarea>
<hr>
    Server端程式：_02.SendAndReceiveMessageObjectEndpoint.java (註釋型端點)<br>
    <a href='/WebSocketBasic/index.jsp'>回前頁</a><br> 
	</div>
</body>
</html>