package ex01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExerciseFindViewController {

	@GetMapping("/ex01")
	public String ex01() {
		return "ex01/ex01";
	}

	@GetMapping("/ex02")
	public String play() {
		return "ex02/ex02";
	}
	
}
