package crm.controller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import crm.model.Category;
import crm.model.Hobby;
import crm.model.Member;
import crm.service.CategoryService;
import crm.service.HobbyService;
import crm.service.MemberService;
import crm.validators.MemberValidator;

@Controller
@RequestMapping("/crm")
public class MemberInsertAndUpdateController {
	String noImage = "/images/NoImage.png";
	String noImageFemale = "/images/NoImage_Female.jpg";
	String noImageMale = "/images/NoImage_Male.png";

	MemberService memberService;
	
	HobbyService hobbyService;
	
	CategoryService categoryService;
	
	ServletContext context;
	
	MemberValidator validator;
	
	@Autowired
	public MemberInsertAndUpdateController(MemberService memberService, HobbyService hobbyService, CategoryService categoryService,
			ServletContext context, MemberValidator validator) {
		this.memberService = memberService;
		this.hobbyService = hobbyService;
		this.categoryService = categoryService;
		this.context = context;
		this.validator = validator;
	}
	
	@ModelAttribute
	public void getMember(
			@PathVariable(value="id", required = false ) Integer id, Model model) {
		if (id != null) {
			Member member = memberService.get(id);
			model.addAttribute("member", member);
		} else {
			Member member = new Member();
			member.setName("林曉芬");
			member.setEmail("fenglin.1234@post.com");
			member.setBirthday(java.sql.Date.valueOf("1970-5-8"));
			Hobby hobby = new Hobby();
			hobby.setId(4);
			member.setHobby(hobby);
			
			Category cat = new Category();
			cat.setId(101);
			member.setCategory(cat);
			member.setLogin("false");
			model.addAttribute("member", member);
		}
	}
	
	// 本方法於新增時，送出空白的表單讓使用者輸入資料
	@GetMapping(value = "/mem")
	public String showEmptyForm(Model model) {
//		Member member = new Member();
//      下列敘述簡化測試時的資料輸入		
//		member.setAccount("a10225");
//		member.setName("Lisa Lee");
//		member.setEmail("www@gmail.com");
//		member.setWeight(65.5);
//		member.setGender("F");
//		member.setBirthday(java.sql.Date.valueOf("1988-7-5"));
//		member.setName("林曉芳");
//		model.addAttribute("member", member);
		return "crm/insertMember";
	}

	// 當使用者填妥資料按下Submit按鈕後，本方法接收將瀏覽器送來的會員資料，新進行資料的檢查，
	// 若資料有誤，轉向寫入錯誤訊息的網頁，若資料無誤，則呼叫Service元件寫入資料庫
	@PostMapping(value = "/mem")
	// BindingResult 參數必須與@ModelAttribute修飾的參數連續編寫，中間不能夾其他參數
	public String add(
			@ModelAttribute("member") /* @Valid */ Member member, 
			BindingResult result /* , Model model,
			HttpServletRequest request */) {
		//MemberValidator validator = new MemberValidator();
		// 呼叫Validate進行資料檢查
		validator.validate(member, result);
		if (result.hasErrors()) {
//          下列敘述可以理解Spring MVC如何處理錯誤			
//			List<ObjectError> list = result.getAllErrors();
//			for (ObjectError error : list) {
//				System.out.println("有錯誤：" + error);
//			}
			return "crm/insertMember";
		}
		MultipartFile picture = member.getProductImage();
		String originalFilename = picture.getOriginalFilename();
		if (originalFilename.length() > 0 && originalFilename.lastIndexOf(".") > -1) {
			member.setFileName(originalFilename);
		}
		// 建立Blob物件，交由 Hibernate 寫入資料庫
		if (picture != null && !picture.isEmpty()) {
			try {
				byte[] b = picture.getBytes();
				Blob blob = new SerialBlob(b);
				member.setImage(blob);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		}
//		// 必須要找出對應的Hobby物件
		Hobby hobby = hobbyService.getHobby(member.getHobby().getId());
		member.setHobby(hobby);
//		// 必須要找出對應的Category物件
		Category category = categoryService.getCategory(member.getCategory().getId());
		member.setCategory(category);

		Timestamp adminTime = new Timestamp(System.currentTimeMillis());
		member.setAdmissionTime(adminTime);
		
		try {
			memberService.save(member);
		} catch (org.hibernate.exception.ConstraintViolationException e) {
			result.rejectValue("account", "", "帳號已存在，請重新輸入");
			return "crm/insertMember";
		} catch (Exception ex) {
			System.out.println(ex.getClass().getName() + ", ex.getMessage()=" + ex.getMessage());
			result.rejectValue("account", "", "請通知系統人員...");
			return "crm/insertMember";
		}
//		// 將上傳的檔案移到指定的資料夾, 目前註解此功能
//		try {
//			File imageFolder = new File(rootDirectory, "images");
//			if (!imageFolder.exists())
//				imageFolder.mkdirs();
//			File file = new File(imageFolder, "MemberImage_" + member.getId() + ext);
//			productImage.transferTo(file);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
//		}
		return "redirect:/crm/showAllMembers";
	}

	// 當使用者需要修改時，本方法送回含有會員資料的表單，讓使用者進行修改
	// 由這個方法送回修改記錄的表單...
	@GetMapping(value = "/mem/{id}")
	public String showDataForm(@PathVariable("id") Integer id, Model model) {
		Member member = memberService.get(id);
		model.addAttribute(member);
		return "crm/updateMember";
	}
	
	// 當將瀏覽器送來修改過的會員資料時，由本方法負責檢核，若無誤則寫入資料庫
	@PostMapping("/mem/{id}")
	// BindingResult 參數必須與@ModelAttribute修飾的參數連續編寫，中間不能夾其他參數
	// 
	public String modify(
			@ModelAttribute("member") Member member, 
			BindingResult result, 
			Model model,
			@PathVariable Integer id, 
			HttpServletRequest request) {
		MemberValidator validator = new MemberValidator();
		validator.validate(member, result);
		if (result.hasErrors()) {
			System.out.println("result hasErrors(), member=" + member);
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				System.out.println("有錯誤：" + error);
			}
			return "crm/updateMember";
		}

		// 找到對應的Hobby物件
		Hobby hobby = hobbyService.getHobby(member.getHobby().getId());
		member.setHobby(hobby);
		
		// 找到對應的Category物件
		Category category = categoryService.getCategory(member.getCategory().getId());
		member.setCategory(category);
		Timestamp adminTime = new Timestamp(System.currentTimeMillis());
		member.setAdmissionTime(adminTime);

		MultipartFile picture = member.getProductImage();

		if (picture.getSize() == 0) {
			// 表示使用者並未挑選圖片
//			Member original = memberService.get(id);
//			member.setImage(original.getImage());
		} else {
			String originalFilename = picture.getOriginalFilename();
			if (originalFilename.length() > 0 && originalFilename.lastIndexOf(".") > -1) {
				member.setFileName(originalFilename);
			}

			// 建立Blob物件
			if (picture != null && !picture.isEmpty()) {
				try {
					byte[] b = picture.getBytes();
					Blob blob = new SerialBlob(b);
					member.setImage(blob);
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
				}
			}
		}
		memberService.update(member);
		return "redirect:/crm/showAllMembers";
	}

	@ModelAttribute
	public void commonData(Model model) {
		List<Hobby> hobbyList = hobbyService.getAllHobbies();
		List<Category> categoryList = categoryService.getAllCategories();
		Map<String, String> genderMap = new HashMap<>();
		genderMap.put("M", "男生");
		genderMap.put("F", "女生");

		model.addAttribute("genderMap", genderMap);
		model.addAttribute("hobbyList", hobbyList);
		model.addAttribute("categoryList", categoryList);
	}

	// 本方法可對WebDataBinder進行組態設定。除了表單資料外，絕大多數可以傳入控制器方法的
	// 參數都可以傳入以@InitBinder修飾的方法。本方法最常使用的參數為WebDataBinder。
	//
	// org.springframework.web.bind.WebDataBinder
	// 為 org.springframework.validation.DataBinder 的子類別，它將夾帶在請求物件內
	// 的請求參數綁定在JavaBean內。
	// registerCustomEditor(): 可對JavaBean內之特定型態自定該型態的屬性編輯器(PropertyEditor)
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	public byte[] blobToByteArray(Blob blob) {
		byte[] result = null;
		try (InputStream is = blob.getBinaryStream(); ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
			byte[] b = new byte[819200];
			int len = 0;
			while ((len = is.read(b)) != -1) {
				baos.write(b, 0, len);
			}
			result = baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
