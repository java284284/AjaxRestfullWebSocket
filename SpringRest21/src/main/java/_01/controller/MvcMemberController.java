package _01.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import _01.model.Member;
import _01.service.MemberService;

//@Controller
//@RequestMapping("/_03/mvc")
public class MvcMemberController {
	public MvcMemberController() { }

	MemberService service;

	@Autowired
	public void setService(MemberService service) {
		this.service = service;
	}
	
	
	// 輸入會員資料，檢查帳號是否可用
	@PostMapping(value = "/_02/CheckMemberIdServlet", produces = { "application/json" })
	public ResponseEntity<Map<String, String>> checkMemberId(@RequestParam("id") String memberId) {
		Map<String, String> map = new HashMap<>();
		String id = service.checkMemberId(memberId);
		System.out.println("id=" + id + "***");
		map.put("id", id);
		ResponseEntity<Map<String, String>> re = new ResponseEntity<>(map, HttpStatus.OK);
		return re;
	}
	// 輸入會員資料，新增會員資料
	@PostMapping("/_02/members")
	public ResponseEntity<Map<String, String>> save(Member member) {
		Map<String, String> map = new HashMap<>();
		ResponseEntity<Map<String, String>> re = null;
		int n = 0;
		try {
			n = service.saveMember(member);
			if (n == 1) {
				map.put("success", "新增成功");
				re = new ResponseEntity<>(map, HttpStatus.CREATED); 
			} else if (n == -1) {
				map.put("fail", "帳號重複");
				re = new ResponseEntity<>(map, HttpStatus.OK); 
			}
			
		} catch(Exception e) {
			map.put("fail", e.getMessage());
		}
		return re;
	}

	// 查詢所有Member紀錄
	@GetMapping(value = {"/_03/members", "/members"})
	public String queryAllMembersJSP(Model model) {
		List<Member> members = service.findAllMembers();
		model.addAttribute("allMembers", members);
		return "_03/_02/showMembers";
	}
	
	
	

	@GetMapping("/_02/register")
	public String register() {
		return "_03/_02/register";
	}

//	@GetMapping("/_02/CheckMemberIdServlet")
//	public String checkMemberId() {
//		return "_03/_02/register";
//	}

//	@GetMapping("/_03/singleMember.json")
//	public void singleMember(@RequestParam("key") Integer key, HttpServletResponse response)  {
//
//	    response.setContentType("application/json; charset=utf-8");
//		try(
//			PrintWriter out = response.getWriter();
//		) {
////			Member member = service.findByPrimaryKey(key);
////			String singleMemberJson = gson.toJson(member); 
////            out.write(singleMemberJson);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@GetMapping("/_03/allMembers.json")
//	public void allMembers(HttpServletResponse response)  {
//
//	    response.setContentType("application/json; charset=utf-8");
//		try(
//			PrintWriter out = response.getWriter();
//		) {
//			List<Member> members = service.findAllMembers();
////			String membersJson = gson.toJson(members); 
////            out.write(membersJson);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	// 
//	@GetMapping("/_03/showAllMembers")
//	public String showAllMembers()  {
//		return "_03/ShowAllMembersAjax";
//	}

	
}
