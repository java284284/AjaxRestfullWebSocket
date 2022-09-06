<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
	<h2>WebSocket Test</h2>
	<div>
		<input type="text" id="input" />
	</div>
	<div>
		<input type="button" id="connectBtn" value="CONNECT" onclick="connect()" /> 
		<input type="button" id="sendBtn" value="SEND" onclick="send()" disable="true" />
	</div>
	<div id="output">
		<h2>資料輸出區</h2>
	</div>
</body>
<script type="text/javascript">
	var webSocket;
	var output = document.getElementById("output");
	var connectBtn = document.getElementById("connectBtn");
	var sendBtn = document.getElementById("sendBtn");
	var wsUrl = (location.protocol == "https:" ? "wss://" : "ws://")
			+ location.hostname + (location.port ? ':' + location.port : '')
// 			+ "/WebSocketBasic/toUpper";
			+ "/WebSocketBasic/websocketbot";

	function connect() {
		// open the connection if one does not exist
		if (webSocket !== undefined
				&& webSocket.readyState !== WebSocket.CLOSED) {
			return;
		}

		updateOutput("Trying to establish a WebSocket connection to <code>"
				+ wsUrl + "</code>");

		// Create a websocket
		webSocket = new WebSocket(wsUrl);

		webSocket.onopen = function(event) {
			updateOutput("Connected!");
			connectBtn.disabled = true;
			sendBtn.disabled = false;
		};

		webSocket.onmessage = function(event) {
			updateOutput(event.data);
		};

		webSocket.onclose = function(event) {
			updateOutput("Connection Closed");
			connectBtn.disabled = false;
			sendBtn.disabled = true;
		};
	}

	function send() {
		var text = document.getElementById("input").value;
		webSocket.send(text);
	}

	function closeSocket() {
		webSocket.close();
	}

	function updateOutput(text) {
		output.innerHTML += "<br/>" + text;
	}
</script>
</html>