package ex02;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Ex02Controller {

	public Ex02Controller() {
		   System.out.println("=====>IoC容器正在建立本類別(Ex02Controller)的物件");
	}
	
	public @ResponseBody String timeNow() {
		return "";
	}
	
	@GetMapping("/variousData")
	public @ResponseBody Map<String, Object> variousData() {
		return null;
	}
	
	
}
