package ch02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Ch02FindViewController {
	
	@GetMapping("/ch02/")
	public String ch02index() {
		return "ch02/index";                            
	}
	
	@GetMapping(value="/ch02/event/focus_blur")
	public String focus_blur() {
		return "ch02/event/focus_blur";                            
	}
	
	@GetMapping(value="/ch02/event/onchange")
	public String onchange() {
		return "ch02/event/onchange";                            
	} 
	
	
	@GetMapping(value="/ch02/event/keypress")
	public String keypress() {
		return "ch02/event/keypress";                            
	}
	
	@GetMapping(value="/ch02/event/keyup")
	public String keyup() {
		return "ch02/event/keyup";                            
	} 
	
	@GetMapping(value="/ch02/js/JavaScriptArray")
	public String javaScriptArray() {
		return "ch02/js/JavaScriptArray";                            
	}
	
	@GetMapping(value="/ch02/js/JavaScriptObject")
	public String javaScriptObject() {
		return "ch02/js/JavaScriptObject";                            
	} 
	
}
