<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    	
<!DOCTYPE html>
<html>
<head>
<title>Chat WebSocket</title>
<link  rel='stylesheet' href="<c:url value='/css/style.css' />" />
<script src="/websocket/webjars/sockjs-client/sockjs.min.js"></script>
<script src="/websocket/webjars/stomp-websocket/stomp.min.js"></script>

<script type="text/javascript">
let stompClient = null;
let url = "http://" + window.location.host + '/websocket/chatting' ;
let chatId = null ;				// 聊天代號
let to = null ;					// 
let responseArea = null ;		// 聊天訊息顯示區
let inputMessageArea = null ;	// 聊天訊息輸入區
let btnConnect = null ;		
let btnDisconnect = null ;
let promptArea = null ;			// 系統訊息提示區	

let btnSendToChatRoom2 = null ;


window.addEventListener('load', function() {
	btnConnect 		= document.getElementById('btnConnect');
	btnDisconnect 	= document.getElementById('btnDisconnect');
	chatId 			= document.getElementById('chatId');
	responseArea 	= document.getElementById('responseArea');
	promptArea 		= document.getElementById('promptArea');
	inputMessageArea = document.getElementById('inputMessageArea');
	
	btnSendToChatRoom2 = document.getElementById('sendToChatRoom2');
	
	
	
	btnConnect.onclick = function() {
		let chatIdValue = chatId.value;
		if (chatIdValue == null || chatIdValue == "" ) {
			promptArea.innerHTML = "<font size='-1' color='red'>必須先輸入聊天代號才能加入聊天室</font>";
			return;
		} else {
			promptArea.innerHTML = "";
		}
		var socket = new SockJS(url);
		stompClient = Stomp.over(socket);
		stompClient.connect({}, function(frame) {
			setConnected(true);
			inputMessageArea.focus();
			console.log('Connected: ' + frame);
			stompClient.subscribe('/topic/messages', function(messageOutput) {
				showMessageOutput(JSON.parse(messageOutput.body));
				
			});
		});
	};
	btnDisconnect.onclick = function() {
		if (stompClient != null) {
			stompClient.disconnect();
		}
		setConnected(false);
		chatId.value = "";
		console.log("Disconnected");
		
	};
	
	inputMessageArea.onkeyup = function(){
		if (event.keyCode === 13) {
			let text = inputMessageArea.value;
			if (text.length > 0)  {
				console.log(text.length);
				stompClient.send("/app/chat", {}, JSON.stringify({
					'from' : chatId.value,
					'text' : text
				}));
			}
		}
	}
	
	btnSendToChatRoom2.onclick = function(){
		let text = inputMessageArea.value;
		if (text.length > 0)  {
			console.log(text.length);
			stompClient.send("/app/chat", {}, JSON.stringify({
				'from' : chatId.value,
				'text' : text
			}));
		}
		}
	

	setConnected(false);
	chatId.focus();
}) 
	function setConnected(connected) {
// 		btnConnect = document.getElementById('connect');
		btnDisconnect.disabled = !connected;
		btnConnect.disabled = connected;
		document.getElementById('conversationDiv').style.visibility = connected ? 'visible'
				: 'hidden';
		document.getElementById('responseArea').innerHTML = '';
	}


	function showMessageOutput(messageOutput) {
		let line = "";
		console.log(JSON.stringify(messageOutput));
		line += JSON.stringify(messageOutput) + "\n";
        /* 更新聊天訊息顯示區 */
        responseArea.value += "" + line;
		
		
// 		var p = document.createElement('p');
// 		p.style.wordWrap = 'break-word';
// 		p.appendChild(document.createTextNode(messageOutput.from + ": "
// 				+ messageOutput.text + " (" + messageOutput.time + ")"));
// 		response.appendChild(p);
	}
	
</script>
</head>
<body>
<div align='center'>
    <h2>WebSocket Stomp 範例</h2>
    <hr>
	<div>
		<div>
			聊天代號：<input type="text" id="chatId" placeholder="請輸入一個代號：" />
		</div>
       <div style="height: 30px;" id='promptArea'>&nbsp;</div>
		
		
		<div>
			<button id="btnConnect" >加入聊天室</button>
			<button id="btnDisconnect" disabled="disabled" >
				退出聊天室</button>
		</div>
		<br />
		<div id="conversationDiv">
			<input type="text" id="inputMessageArea" placeholder="輸入聊天訊息..." />
			<button id="sendToChatRoom2">傳送</button>
			<hr>
		    <textarea id="responseArea" cols="90" rows="12" readonly></textarea>
		</div>
		
	</div>
<a href="<c:url value='/' />">回前頁</a>
</div>
</body>
</html>