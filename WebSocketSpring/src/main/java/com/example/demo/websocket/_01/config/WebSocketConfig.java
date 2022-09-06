package com.example.demo.websocket._01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.example.demo.websocket._01.handler.MacroHandler;

@Configuration("WebSocketConfig1")
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// 請求路徑 /macro 會映射到 MacroHandler 類別
		registry.addHandler(macroHandler(), "/macro"); 
	}
	
	@Bean
	public MacroHandler macroHandler() {
		return new MacroHandler();
	}

}
