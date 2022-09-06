package _00;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Logger;  

@ServerEndpoint("/echoserver00")
public class EchoServerEndpoint {
	private static final Logger LOGGER = Logger.getLogger(EchoServerEndpoint.class);
	public EchoServerEndpoint() {
		LOGGER.info("註釋版的ServerEndpoint：已新建物件,  hashCode=" + hashCode());
	}
	
	@OnOpen
	public void onOpen(Session session) {
		LOGGER.info("註釋版的ServerEndpoint：連線已開啟, Session Id: " + session.getId());
	}
	
	@OnMessage
	public String onMessage(String message) {
		LOGGER.info("註釋版的ServerEndpoint：收到客戶端送來訊息: " + message);
	    return "Server回應：" + message;
	}
	
	@OnClose
	public void onClose(Session session, CloseReason reason) {
		LOGGER.info("註釋版的ServerEndpoint：連線已關閉,  關閉原因:" + reason.getReasonPhrase());
	}
	
	@OnError
	public void onError(Session session, Throwable thr) {
		LOGGER.info("註釋版的ServerEndpoint：發生錯誤, 例外原因:" + thr.getMessage());
	}
}
