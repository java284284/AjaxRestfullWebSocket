package _02.decoders;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import _02.messages.InMessage;

/*
將客戶端送來的JSON資料
 {"no":"test001","name":"林小真","chi":"75.8","eng":"70","mat":"55.0"}
InMessageDecoder將會將其解碼為InMessage類別的物件。
*/
public class InMessageDecoder implements Decoder.Text<InMessage> {
	private Map<String, String> messageMap;

	@Override
	public void init(EndpointConfig ec) {
	}

	@Override
	public void destroy() {
	}

	/* Create a new InMessage object if the message can be decoded */
	@Override
	public InMessage decode(String string) throws DecodeException {
		System.out.println("Route in Server: " + 2);
		messageMap = new HashMap<>();
		JsonParser parser = Json.createParser(new StringReader(string));
		while (parser.hasNext()) {
			if (parser.next() == JsonParser.Event.KEY_NAME) {
				String key = parser.getString();
				parser.next();
				String value = parser.getString();
				messageMap.put(key, value);
			}
		}
		System.out.println(messageMap);
		String no = messageMap.get("no");
		String name = messageMap.get("name");
		Double chi = Double.parseDouble(messageMap.get("chi"));
		Double eng = Double.parseDouble(messageMap.get("eng"));
		Double mat = Double.parseDouble(messageMap.get("mat"));
		InMessage msg = new InMessage(no, name, chi, eng, mat);
		return msg;
	}

	@Override
	public boolean willDecode(String string) {
		System.out.println("Route in Server: " + 1);
		return true;
	}
}
