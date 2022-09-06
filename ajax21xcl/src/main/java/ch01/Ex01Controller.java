package ch01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("InClassEx01Controller")
public class Ex01Controller {

	@GetMapping("/inClassExer01")
	public String index() {
		return "ch01/Ex01";
	}
	
	@GetMapping(value="/singleString", produces = {"text/plain; charset=UTF-8"})
	public @ResponseBody String method01() {
		String[] persons = {"吳一男-001", "姜曉-067", "張德秀-101", "阿里-199", 
							"韓美女-212", "曹尚佑-218", "成奇勳-456"};
		int num = (int)(Math.random() * persons.length); 
		System.out.println(persons[num]);
		return persons[num];
	}

}
