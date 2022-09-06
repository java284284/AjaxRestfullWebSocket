package _01;

import java.io.IOException;

import javax.websocket.MessageHandler;
import javax.websocket.Session;

import org.apache.log4j.Logger;
public class CustomerMessageHandler implements MessageHandler.Whole<String> {
	private static final Logger LOGGER = Logger.getLogger(ProgrammaticEchoEnpoint.class);
	Session session ;
	
	public CustomerMessageHandler(Session session) {
		this.session = session;
	}

	@Override
	public void onMessage(String message) {
		try {
			LOGGER.info("程式版的ServerEndpoint：收到客戶端送來訊息: " + message);
			session.getBasicRemote().sendText("程式版的ServerEndpoint：收到客戶端送來訊息: " + message);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
