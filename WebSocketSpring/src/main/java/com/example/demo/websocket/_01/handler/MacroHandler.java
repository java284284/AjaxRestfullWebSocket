package com.example.demo.websocket._01.handler;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

public class MacroHandler extends AbstractWebSocketHandler {
	
    Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	// 當客戶端以WebSocket通訊協定送來文字訊息時，本方法會被呼叫。
	// 參數 TextMessage的getPayload()可得到送來的文字訊息。
	protected void handleTextMessage(WebSocketSession session, 
				TextMessage message) throws Exception {
		logger.info("收到訊息=" + message.getPayload() + ", From=" + session.getId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		session.sendMessage(new TextMessage( "現在時間: " + sdf.format(new Date())));
	}
	
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    	logger.info("建立新連線: id=" + session.getId() 
    			  + ", getRemoteAddress()=" + session.getRemoteAddress());
    	
    	HttpHeaders headers = session.getHandshakeHeaders();
    	Set<String> set =  headers.keySet();
    	for(String key : set) {
    		Object o = headers.get(key);
    		logger.info(" 請求標頭: " + key + "==>" + o);
    	}
    	logger.info("==========================" );
    	URI uri = session.getUri();
    	logger.info("session.	uri.toString()=" + uri.toString());
    	logger.info("session.	session.getAttributes().size()=" + session.getAttributes().size());
    	logger.info("session.	getAcceptedProtocol()=" + session.getAcceptedProtocol() );
    }
    
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) 
    					throws Exception {
    	logger.info("關閉連線: id=" + session.getId() 
    	          + ", getRemoteAddress()=" + session.getRemoteAddress());
    }
    
}
