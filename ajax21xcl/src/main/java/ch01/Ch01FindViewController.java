package ch01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Ch01FindViewController {
	
	@GetMapping("/ch01/")
	public String ch01index() {
		return "ch01/index";                            
	}
	
	@GetMapping("/ch01/_01/HelloAjax")
	public String helloAjax() {
		return "ch01/_01/HelloAjax";                            
	}
	
	@GetMapping("/ch01/_02/WholeWebPage")
	public String wholeWebPage() {
		return "ch01/_02/WholeWebPage";                            
	} 
	
	@GetMapping("/ch01/_03/Synchronous")
	public String synchronous() {
		return "ch01/_03/Synchronous";                            
	}
	
	@GetMapping("/ch01/_04/EventDriven")
	public String eventDriven() {
		return "ch01/_04/EventHandler";                            
	} 
}

