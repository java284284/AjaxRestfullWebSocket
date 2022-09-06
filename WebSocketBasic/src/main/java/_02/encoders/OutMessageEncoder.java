package _02.encoders;

import java.io.StringWriter;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

import _02.messages.OutMessage;

// 本編碼器可將OutMessage物件編碼為JSON格式的字串
public class OutMessageEncoder implements Encoder.Text<OutMessage> {
    
    @Override
    public void init(EndpointConfig ec) { }
    
    @Override
    public void destroy() { }
    
    @Override
    public String encode(OutMessage outMessage) throws EncodeException {
    	System.out.println("Route in Server: " + 4);
        StringWriter swriter = new StringWriter();
        try (JsonGenerator jsonGen = Json.createGenerator(swriter)) {
            jsonGen.writeStartObject() 
                .write("no", outMessage.getNo())
                .write("name", outMessage.getName())
                .write("sum", outMessage.getSum())
                .write("max", outMessage.getMax())
                .write("min", outMessage.getMin())
            .writeEnd();
        }
        System.out.println("swriter.toString()=" + swriter.toString());
        Gson gson = new Gson();
        String strGson = gson.toJson(outMessage);
        System.out.println("gson.toJson(outMessage)" + strGson);
        return swriter.toString();
    }
}
