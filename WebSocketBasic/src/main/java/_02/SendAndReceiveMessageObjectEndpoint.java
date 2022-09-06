package _02;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import _02.decoders.InMessageDecoder;
import _02.encoders.OutMessageEncoder;
import _02.messages.InMessage;
import _02.messages.OutMessage;

@ServerEndpoint(value = "/chatserver02", 
				decoders = { InMessageDecoder.class }, 
				encoders = { OutMessageEncoder.class })

public class SendAndReceiveMessageObjectEndpoint {
	private static final Logger logger = Logger.getLogger("BotEndpoint");

	public SendAndReceiveMessageObjectEndpoint() {
	}

	@OnOpen
	public void openConnection(Session session) {

	}

	@OnMessage
	public void message(final Session session, InMessage inMessage) throws IOException, EncodeException {
		System.out.println("Route in Server: " + 3);
		
		String no = inMessage.getNo();
		String name = inMessage.getName();
		Double chi = inMessage.getChi();
		Double eng = inMessage.getEng();
		Double mat = inMessage.getMat();
		Double sum = chi + eng + mat;
		Double max = Math.max(Math.max(chi, eng), mat);
		Double min = Math.min(Math.min(chi, eng), mat);
		OutMessage outMessage = new OutMessage(no, name, sum, max, min);
		session.getBasicRemote().sendObject(outMessage);
	}

	@OnClose
	public void closedConnection(Session session) {

	}

	@OnError
	public void error(Session session, Throwable t) {

	}

	public synchronized void sendAll(Session session, Object msg) {
		try {
			for (Session s : session.getOpenSessions()) {
				if (s.isOpen()) {
					s.getBasicRemote().sendObject(msg);
					logger.log(Level.INFO, "Sent: {0}", msg.toString());
				}
			}
		} catch (IOException | EncodeException e) {
			logger.log(Level.INFO, e.toString());
		}
	}

	/* Returns the list of users from the properties of all open sessions */
	public List<String> getUserList(Session session) {
		List<String> users = new ArrayList<>();
		users.add("Duke");
		for (Session s : session.getOpenSessions()) {
			if (s.isOpen() && (boolean) s.getUserProperties().get("active"))
				users.add(s.getUserProperties().get("name").toString());
		}
		return users;
	}
}
