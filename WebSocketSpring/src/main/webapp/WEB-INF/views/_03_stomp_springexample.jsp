<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">
	var contextPath = "${contextPath}";
</script>
<title>Hello WebSocket</title>
<link href="<c:url value='/main.css' />" rel="stylesheet">
<link rel='stylesheet' href="<c:url value='/css/style.css' />" />
<script src="<c:url value='/webjars/jquery/jquery.min.js' />"></script>
<script src="<c:url value='/webjars/sockjs-client/sockjs.min.js' />"></script>
<script src="<c:url value='/webjars/stomp-websocket/stomp.min.js' />"></script>
<%--     <script src="<c:url value='/app.js' />"></script> --%>
</head>
<body>
	<noscript>
		<h2 style="color: #ff0000">您的瀏覽器似乎支援Javascript! Websocket必須依賴
			Javascript 才能發揮其功能</h2>
	</noscript>
	<script>
		const ENDPOINT = '/gs-guide-websocket';
		const CONTEXT_PATH = "${contextPath}";
		console.log(CONTEXT_PATH);
		let connect = null;
		let disconnect = null;
		let conversation = null;
		let stompClient = null;
		let name = null;
		let greetings = null;
		let send = null;
		let queryTime = null;

		window.addEventListener('load', function() {
			connect = document.getElementById("connect");
			disconnect = document.getElementById("disconnect");
			conversation = document.getElementById("conversation");
			name = document.getElementById("name");
			greetings = document.getElementById("greetings");
			send = document.getElementById("send");
			queryTime = document.getElementById("queryTime");
			connect.addEventListener('click', connectOk);
			disconnect.addEventListener('click', disconnectOk);
			send.addEventListener('click', sendData);
			queryTime.addEventListener('click', queryTimeOK);
		});

		function connectOk() {
			var socket = new SockJS(CONTEXT_PATH + ENDPOINT);
			stompClient = Stomp.over(socket);
			stompClient.connect({}, function(frame) {
				setConnected(true);
				console.log('連線成功: ' + frame);
				stompClient.subscribe('/topic/greetings', function(feedback) {
					showGreeting(JSON.parse(feedback.body).content);
				});
			});
		}

		function sendData() {
			if (!name.value || name.value === null
					|| name.value.trim().length == 0) {
				alert("必須輸入姓名");
				return;
			}
			
			var dataSent = JSON.stringify({
				'name' : name.value
			});
			stompClient.send("/app/hello", {}, dataSent);
			console.log("Client: Send Data: " + dataSent);
		}
		
		function queryTimeOK() {
			queryTime.disabled = true;
			var dataSent = JSON.stringify({
				'timezone' : 'Asia/Taipei'
			});
			stompClient.send("/app/queryTime", {}, dataSent);
			console.log("Client: Send Data: " + dataSent);
		}
		

		function disconnectOk() {
			if (stompClient !== null) {
				stompClient.disconnect();
			}
			setConnected(false);
			console.log("Disconnected");
		}

		function setConnected(connected) {
			connect.disabled = connected;
			disconnect.disabled = !connected;
			queryTime.disabled = !connected;
			send.disabled = !connected;

// 			if (connected) {
// 				conversation.style.display = "block";
// 			} else {
// 				conversation.style.display = "none";
// 			}
		}

		function showGreeting(message) {

			console.log("message = " + message);
			// 	greetings.append("<tr><td>" + message + "</td></tr>");
			var newRow = greetings.insertRow();
			

			// Insert a cell at the end of the row
			var newCell = newRow.insertCell();

			// Append a text node to the cell
			var textNode = document.createTextNode(message);
			newCell.appendChild(textNode);
		}
	</script>
	<div align='center'>
		<h2>Spring Stomp 連線1</h2>
		<h3>參考下列網址加以修改</h3>
		<p><small>url: https://spring.io/guides/gs/messaging-stomp-websocket/</small></p>
		<hr>
		<div align='center'>
			<button id="connect" type="submit">連線</button>
			<button id="disconnect" type="submit" disabled="disabled">離線</button>
			<hr>
			<label for="name">請輸入姓名：</label> <input type="text" id="name"
				placeholder="Your name here...">
			<button id="send" type="submit" disabled="disabled">送出</button>
			<hr>
			<button id="queryTime" type="submit" disabled="disabled">送出多次訊息</button>
			<hr>
			<a href="<c:url value='/' />">回前頁</a>
		</div>
		<table style='width: 90%;' id="conversation">
			
				<tr style='width: 634px;'>
					<th align='center'>回覆訊息</th>
				</tr>
			
			<tbody id="greetings" style='text-align: center;'>
			</tbody>
		</table>


	</div>
</body>
</html>