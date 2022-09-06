package ch03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Ch03FindViewController {

	@GetMapping({"/ch03/", "/ch03"})
	public String ch03index() {
		return "ch03/index";
	}
	
	@GetMapping("/ch03/_01/ReadyStateChangeEvent")
	public String readyStateChangeEvent() {
		return "ch03/_01/ReadyStateChangeEvent";
	}

	@GetMapping("/ch03/_02/ErrorProneAjax")
	public String errorProneAjax() {
		return "ch03/_02/ErrorProneAjax";
	}

	@GetMapping("/ch03/_03/ShowTime")
	public String showTime() {
		return "ch03/_03/ShowTime";
	}

	@GetMapping("/ch03/_03/mouseover")
	public String mouseover() {
		return "ch03/_03/mouseover";
	}

	@GetMapping("/ch03/_04/longrun")
	public String longrun() {
		return "ch03/_04/longrun";
	}

	@GetMapping("/ch03/_05/citytime")
	public String citytime() {
		return "ch03/_05/citytime";
	}

	@GetMapping("/ch03/_06/ShowPicture")
	public String showPicture() {
		return "ch03/_06/ShowPicture";
	}
}

