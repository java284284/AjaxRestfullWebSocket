package _01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AjaxBaseController {
	
	@GetMapping({"/index", "/"})
	public String index() {
		return "index";
	}

	@GetMapping("/_03/showMembersAjax")
	public String showMembersAjax() {
		return "_03/showMembersAjax";
	}

	// 轉送出能夠進行修改的網頁
	@GetMapping("/_03/memberEdit/{key}")
	public String showEditMemberForm(@PathVariable Integer key, Model model) {
		model.addAttribute("pk", key);
		return "_03/editMember";
	}

}
