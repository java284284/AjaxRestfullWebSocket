package _01.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import _01.model.Member;
import _01.service.MemberService;
import _01.service.MemberServiceForUpdate;

@Controller
public class AjaxMemberController {
	@Autowired
	MemberService service;

	@Autowired
	MemberServiceForUpdate serviceUpdate;

	public AjaxMemberController() {
	}

	// 查詢所有會員資料
	@GetMapping({"/ch03/member/getAllMembers", "/members"})
	public @ResponseBody List<Member> queryAllMembers(Model model) {
		List<Member> members = service.findAllMembers();
		return members;
	}

	// 送出新增會員資料的空白表單
	@GetMapping("/insertMemberForm")
	public String registerFindView() {
		return "_02/register";
	}

	// 讀取瀏覽器送出Ajax請求， 呼叫 service.saveMember(member) 新增會員資料
	@PostMapping(value="/members", consumes = "application/json")
	public @ResponseBody Map<String, String> save(@RequestBody Member member) {
		Map<String, String> map = new HashMap<>();
		int n = 0;
		try {
			n = service.saveMember(member);
			if (n == 1) {
				map.put("success", "新增成功");
			} else if (n == -1) {
				map.put("fail", "帳號重複");
			}
		} catch (Exception e) {
			map.put("fail", e.getMessage());
		}
		return map;
	}

	// 當新增會員資料時, 檢查帳號是否可用
	@PostMapping(value = "/_02/CheckMemberId", produces = { "application/json" })
	public @ResponseBody Map<String, String> checkMemberId(@RequestParam("id") String memberId) {
		Map<String, String> map = new HashMap<>();
		String id = service.checkMemberId(memberId);
		map.put("id", id);
		return map;
	}

	// 修改單筆會員資料
	@PutMapping(value = "/members/{key}", consumes = { "application/json" }, produces = { "application/json" })
	public @ResponseBody Map<String, String> updateMember(
			@RequestBody Member member,
			@PathVariable Integer key) {
		Member member0 = null;
		if (key != null) {
			member0 = serviceUpdate.findByPrimaryKey(key);
			if (member0 == null) {
				throw new RuntimeException("鍵值不存在, key=" + key);
			}
			serviceUpdate.evictMember(member0);
		} else {
			throw new RuntimeException("鍵值不存在, key=" + key);
		}
		copyUnupdateField(member0, member);

		Map<String, String> map = new HashMap<>();
		try {
			service.updateMember(member);
			map.put("success", "更新成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("fail", "更新失敗");
		}
		return map;
	}

	private void copyUnupdateField(Member member0, Member member) {
		member.setExtra(member0.getExtra());
		member.setRegisterTime(member0.getRegisterTime());
	}

	// 傳回能夠編輯單筆會員資料之視圖的邏輯名稱
	@GetMapping(value = "/membersEdit/{key}", produces = { "application/json" })
	public String editMemberFindView(@PathVariable Integer key, Model model) {
		model.addAttribute("pk", key);
		return "_03/editMember";
	}

	// 讀取並傳回單筆會員資料
	@GetMapping("/members/{key}")
	public @ResponseBody Member showEditMember(@PathVariable Integer key) {
		Member member = service.findByPrimaryKey(key);
		return member;
	}

	// 依照鍵值刪除單筆會員資料
	@DeleteMapping("/members/{key}")
	public @ResponseBody Map<String, String> deleteMember(@PathVariable(required = true) Integer key) {
		Map<String, String> map = new HashMap<>();
		try {
			service.deleteMemberByPrimaryKey(key);
			map.put("success", "刪除成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("fail", "刪除失敗");
			System.out.println("刪除失敗");
		}
		return map;
	}

	// 送出顯示所有Member紀錄的表單
	@GetMapping({ "/showAllMembersAjax" })
	public String showAllMembersFindView() {
		return "_03/showAllMembersAjax";
	}
	
//	@ModelAttribute("member")
//	public Member findMember(@PathVariable(value="pk", required=false) Integer pk) {
//		Member member = null;
//        if (pk != null) {
//        	member = service.findByPrimaryKey(pk);
//        } else {
//        	member = new Member();
//        }
//        System.out.println("member=" + member);
//		return member;
//	}
	
}
