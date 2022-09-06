package ch03;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ch03.model.LotteryBean;
import ch03.service.LotteryService;

@Controller
public class Ch03Controller {
	int previousIndex = 0;
	
	@Autowired
	ServletContext ctx;
	
	@GetMapping(value="/ch03/_02/withError")
	public String withError() {
		try {
			Connection con = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/jspdb", "sa", "1234");
//			("jdbc:sqlserver://localhost:1433;databaseName=JSPDB", "sa", "1234");
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 
		return "/";                            
	}
	
	@GetMapping(value="/ch03/_03/showLocalTime", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String showLocalTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		return "現在時刻 台北時間：" + sdf.format(date);                           
	}
	
	@GetMapping(value="/ch03/_04/LongRunController", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String longRun() {
		String responseMsg = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date start = new Date();
		String msg1 = sdf.format(start);
		try {
		   Thread.sleep(5000);
		} catch(InterruptedException ex){
			System.out.println("發生例外: " + ex.getMessage());
		}
		Date end = new Date();
		String msg2 = sdf.format(end);
		responseMsg = "<font color='red'>開始時間: " + msg1 + "</font><br>";
		responseMsg += "<font color='blue'>結束時間: " + msg2 + "</font><br>";
		return responseMsg;
	}

	@GetMapping(value="/ch03/_05/ShowCityTime", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String cityTime(
			@RequestParam("city") String city,	
			@RequestParam("cityName") String cityName	
		) {
		String responseMsg = "";
		TimeZone tz = TimeZone.getTimeZone(city);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setTimeZone(tz);
		Date date = new Date();
		responseMsg = cityName + "現在時間：" + sdf.format(date);
		return responseMsg;
	}
	
	@GetMapping(value="/ch03/_06/getPicture.do", produces = "text/plain")
	public @ResponseBody String getPicture() {
		
		List<String> list = Arrays.asList("fs.jpg", "m001.jpg", "m12.jpg", 
						          		"m46.jpg", "m536.jpg", "v06.jpg");
		int index = (int)(Math.random() * list.size());
		StringBuffer responseMsg = new StringBuffer();
		
		String filename = list.get(index);
		String mimeType = ctx.getMimeType(filename);
		try (
				InputStream is = ctx.getResourceAsStream("/images/" + filename);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
			){
				byte[] b = new byte[819200];
				int len = 0;
				while ((len= is.read(b)) != -1) {
					baos.write(b, 0, len);
				}
				byte[] bytes = baos.toByteArray();
				String prefix = "data:" + mimeType + ";base64,";
				// 由於java.io.OutputStream類別無法寫出字串，因此將字串轉為位元組陣列寫出
				responseMsg.append(prefix);
				Base64.Encoder be = Base64.getEncoder();	
				responseMsg.append(new String(be.encode(bytes)));
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		return responseMsg.toString();
	}
	
	@GetMapping("/ch03/_03/Lottery")
	public @ResponseBody LotteryBean getLottery	(
		@RequestParam String type
	    ){
		LotteryBean bean = null;
		LotteryService service = new LotteryService(); // LotteryService負責程式的邏輯運算
		if (type.equalsIgnoreCase("4")) {
			service.setLowerBound(0);
			service.setUpperBound(9);
			service.setBallNumber(4);
			bean = service.getFourStars();

		} else if (type.equalsIgnoreCase("6")) {
			service.setLowerBound(1);
			service.setUpperBound(49);
			service.setBallNumber(6);
			bean = service.getLuckyNumbers();
		}
		return bean;
	}
}
