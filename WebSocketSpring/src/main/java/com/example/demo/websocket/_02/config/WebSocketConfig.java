package com.example.demo.websocket._02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.example.demo.websocket._02.handler.MacroHandlerSockJS;

@Configuration("WebSocketConfigSockJS")
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// 請求路徑 /macroSockJS 會映射到 MacroHandler 類別
		registry.addHandler(macroHandlerSockJS(), "/macroSockJS").withSockJS(); 
	}
	
	@Bean
	public MacroHandlerSockJS macroHandlerSockJS() {
		return new MacroHandlerSockJS();
	}
}
