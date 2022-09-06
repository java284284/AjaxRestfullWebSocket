package lab03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ch04._03.model.BookBean;
import ch04._03.service.BookService;

@Controller
public final class ExerciseController {

	BookService bookService;

	@Autowired
	public ExerciseController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/inClassExer02xyz")
	public String exer02() {
		return "eeit47/ex02"; 
		                     
	}
	
	@GetMapping("inClassExer03")
	public String exer03() {
		return "eeit47/ex03";
	}
	@GetMapping("inClassExer04")
	public String exer04() {
		return "eeit47/ex04";
	}
	
	@GetMapping("/findBookById")
	public @ResponseBody BookBean findById(@RequestParam(required = false) Integer id) {
		return bookService.getBook(id);
	}
	
	@GetMapping("/findAllBooks")
	public @ResponseBody List<BookBean> findAllBooks() {
		return bookService.getAllBooksJSON();
	}
}




