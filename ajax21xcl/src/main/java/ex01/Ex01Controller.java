package ex01;

import org.springframework.stereotype.Controller;

@Controller
public class Ex01Controller {

	public Ex01Controller() {
	   System.out.println("=====>IoC容器正在建立本類別(Ex01Controller)的物件");
	}

	
}
