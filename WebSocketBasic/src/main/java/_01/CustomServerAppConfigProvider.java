//package _01;
//
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.websocket.Endpoint;
//import javax.websocket.server.ServerApplicationConfig;
//import javax.websocket.server.ServerEndpointConfig;
//
//public class CustomServerAppConfigProvider implements ServerApplicationConfig {
//
//	// 本方法必須由系統中所有的程式型端點挑選出合格的程式型端點, 經由
//	// ServerEndpointConfig.Builder.create  
//	// 將其與伺服器端的路徑一起封裝在ServerEndpointConfig物件中，然後將此物件加入
//	// Set<ServerEndpointConfig>物件中作為本方法的傳回值。
//	@Override
//	public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> endpointClasses) {
//        Set<ServerEndpointConfig> result = new HashSet<>();
//        for (Class<?> epClass : endpointClasses) {
//             if (epClass.equals(ProgrammaticEchoEnpoint.class)) {
//                ServerEndpointConfig sec = ServerEndpointConfig.Builder.create(epClass, "/echoserver01").build();
//                result.add(sec);
//            }
//        }
//        return result;
//	}
//
//	@Override
//	public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scanned) {
//		return Collections.emptySet();
//	}
//
//}
