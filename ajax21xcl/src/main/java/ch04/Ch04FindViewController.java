package ch04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Ch04FindViewController {
	@GetMapping("/ch04/")
	public String ch04index() {
		return "ch04/index";                            
	}
	@GetMapping("/ch04/_01/queryLottery")
	public String queryLottery() {
		return "ch04/_01/queryLottery";                            
	}
	
	@GetMapping("/ch04/_02/register")
	public String register() {
		return "ch04/_02/register";                            
	}
	
	@GetMapping("/ch04/_07/FileUpload")
	public String FileUpload() {
		System.out.println(112233);
		return "/ch04/_07/FileUpload";                            
	}
	@GetMapping("/ch04/_04/ShowAllBooksAjax")
	public String showAllBooksAjax() {
		return "/ch04/_04/ShowAllBooksAjax";                            
	}
	@GetMapping("/ch04/_05/QueryBooksByPublisher")
	public String queryBooksByPublisher() {
		return "/ch04/_05/QueryBooksByPublisher";                            
	}
	@GetMapping("/ch04/_06/QuerySingleBookAjax")
	public String querySingleBookAjax() {
		return "/ch04/_06/QuerySingleBookAjax";                            
	}
	@GetMapping("/ch04/_07/ShowBooksByPageAjax")
	public String showBooksByPageAjax() {
		return "//ch04/_07/ShowBooksByPageAjax";                            
	}
}
