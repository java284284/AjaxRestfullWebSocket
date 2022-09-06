package _01;

import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;

import org.apache.log4j.Logger;

public class ProgrammaticEchoEnpoint  extends Endpoint {

	private static final Logger LOGGER = Logger.getLogger(ProgrammaticEchoEnpoint.class);

	public ProgrammaticEchoEnpoint() {
		LOGGER.info("程式版的ServerEndpoint：已新建物件,  hashCode=" + hashCode());
	}

	@Override
	public void onOpen(Session session, EndpointConfig config) {
		LOGGER.info("程式版的ServerEndpoint：連線已開啟, Session Id: " + session.getId());
		CustomerMessageHandler cmh = new CustomerMessageHandler(session);
        session.addMessageHandler(cmh);
	}
	@Override
	public void onClose(Session session, CloseReason reason) {
		LOGGER.info("程式版的ServerEndpoint：連線已關閉,  關閉原因:" + reason.getReasonPhrase());
	}

	@Override
	public void onError(Session session, Throwable thr) {
		LOGGER.info("程式版的ServerEndpoint：發生錯誤, 例外原因:" + thr.getMessage());
	}
	
}