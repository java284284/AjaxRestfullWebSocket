package ch01;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ch04.Employee;

@Controller
@RequestMapping("/ch01")
public class Ch01Controller {
	
	@GetMapping(value="/_01/HelloAjaxOO",  
			produces = "text/plain; charset=UTF-8")
	public @ResponseBody String helloAjaxOO() {
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = sdf.format(new Date());
		System.out.println("now=" + now);
		return "現在時刻：" + now;                            
	}
	
	@GetMapping(value="/_03/DelayedResponse", produces = "application/json; charset=UTF-8")
	                   
//	public  @ResponseBody String delay() {
		public @ResponseBody Employee[] delay() {
		try {
			Thread.sleep(5000);
		} catch(InterruptedException e){
			e.printStackTrace();
		}
		Employee employee = new Employee(2570L, "林傑克", java.sql.Date.valueOf("1985-5-7"), 47800.0, "NoImage", null, "image/jpeg");
		return new Employee[] {employee, employee};      
//        SimpleDateFormat  sdf  = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
//        Date now = new Date();
//        String responseMsg = sdf.format(now);
//        return responseMsg;
	} 
}


