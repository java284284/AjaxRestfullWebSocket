package ch04;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ch03.model.LotteryBean;
import ch03.service.LotteryService;
import ch04._02.model.Member;
import ch04._02.service.EmployeeService;
import ch04._02.service.MemberService;
import ch04._03.model.BookBean;
import ch04._03.model.PublisherBean;
import ch04._03.service.BookService;
import ch04._03.service.PublisherService;

//@Controller
public class Ch04Controller {

	@Autowired
	LotteryService lotteryService;

	@Autowired
	ServletContext ctx;

	@Autowired
	MemberService memberService;
	
	@Autowired
	EmployeeService employeeService;

	@Autowired
	BookService bookService;

	@Autowired
	PublisherService publisherService;

	final static String DATE_FORMAT = "yyyy-MM-dd";

	@PostMapping(value = "/ch04/_01/GetLottery", produces = { "application/json; charset=UTF-8" })
	                      
	public @ResponseBody Map<String, String> getLottery(
			@RequestParam(value = "visitor", defaultValue = "訪客") String name,
			@RequestParam(value = "addr0", defaultValue = "(未輸入)") String addr) {

		lotteryService.setLowerBound(0);
		lotteryService.setUpperBound(9);
		lotteryService.setBallNumber(4);
		LotteryBean bean = lotteryService.getFourStars();
		Map<String, String> map = new HashMap<>();
		map.put("name", name);
		map.put("addrAjax1", addr);
		map.put("number", bean.toString());
		System.out.println("map=" + map);
		return map;
	}
	
	
	@PostMapping(value = "/uploadData", produces = { "application/json; charset=UTF-8" })
	public @ResponseBody Map<String, String> uploadData(
			 @RequestBody Employee employee) {
		int startIndex = "data:".length();
		int endIndex = employee.getFileDataUrl().indexOf(";");
		String mimeType = employee.getFileDataUrl().substring(startIndex, endIndex);
		System.out.println("employee=" + employee);
		System.out.println("mimeType=" + mimeType);
		String base64 = employee.getFileDataUrl().substring(employee.getFileDataUrl().indexOf(",") + 1); 
				
        byte[] a = Base64.getDecoder().decode(base64);
        
        try {
			employee.image = new SerialBlob(a);
		} catch (SerialException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        employee.mimeType = mimeType;
        employeeService.save(employee);
		Map<String, String> map = new HashMap<>();
		map.put("name", employee.getName());
		map.put("birthday", employee.getBirthday().toString());
		map.put("salary", employee.getSalary().toString());
		return map;
	}

	@PostMapping("/ch04/_02/CheckMemberId")
	public @ResponseBody Map<String, String> checkMemberId(@RequestParam(value = "id") String memberId) {
		String id = "";
		Map<String, String> map = new HashMap<>();
		if (memberId != null && memberId.trim().length() != 0) {
			id = memberService.checkMemberId(memberId);
			map.put("id", id);
		}
		return map;
	}

	@PostMapping("/ch04/_02/AddMember.do")
	public @ResponseBody Map<String, String> addMember(@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "balance", required = false) String balanceStr,
			@RequestParam(value = "birthday", required = false) String birthdayStr) {

		Map<String, String> messageMap = new HashMap<>();
		Double balance = 0.0;

		if (balanceStr == null || balanceStr.trim().length() == 0) {
			messageMap.put("balanceError", "請輸入餘額");
		} else {
			try {
				balance = Double.parseDouble(balanceStr);
			} catch (NumberFormatException e) {
				messageMap.put("balanceError", "餘額欄必須是數值");
			}
		}
		// 3. 檢查輸入資料
		if (id == null || id.trim().length() == 0) {
			messageMap.put("idError", "請輸入帳號");
		}
		if (name == null || name.trim().length() == 0) {
			messageMap.put("nameError", "請輸入姓名");
		}
		Date birthday = null;

		if (birthdayStr == null || birthdayStr.trim().length() == 0) {
			messageMap.put("birthdayError", "請輸入生日");
		} else if (!isValidDate(birthdayStr)) {
			messageMap.put("birthdayError", "生日欄格式錯誤");
		} else {
			try {
				birthday = Date.valueOf(birthdayStr);
			} catch (Exception e) {
				messageMap.put("birthdayError", "生日欄格式錯誤");
			}
		}
		// 3-1. 如果輸入資料有錯誤，送回前端，請使用者修正
		if (!messageMap.isEmpty()) {
			return messageMap;
		}

		Member member = new Member(null, id, name, balance, birthday);
		try {

			int n = memberService.saveMember(member);
			if (n == -1) {
				Map<String, String> map = new HashMap<>();
				messageMap.put("fail", "帳號已經存在，請更換帳號");

			} else if (n == -2) {
				Map<String, String> map = new HashMap<>();
				messageMap.put("fail", "資料庫異常，請檢查資料庫");
			}
		} catch (Exception ex) {
			messageMap.put("fail", ex.getMessage());

		}
		// 5. 依照企業邏輯運算的結果送回適當的訊息
		messageMap.put("success", "新增成功");
		return messageMap;
	}

	public static boolean isValidDate(String date) {
		try {
			DateFormat df = new SimpleDateFormat(DATE_FORMAT);
			df.setLenient(false);
			df.parse(date);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	@GetMapping(value = "/ch04/_03/singleBook.json", produces = { "application/json; charset=UTF-8" })
	public @ResponseBody BookBean getBook(
			@RequestParam("bookId") Integer bookId) {
		BookBean bean = bookService.getBook(bookId);
//		String mimeType = ctx.getMimeType(bean.getFileName());
//		String dataUri = getDataUri(bean.getCoverImage(), mimeType);
//		bean.setDataUri(dataUri);
		return bean;
	}

//	private String getDataUri(Blob coverImage, String mimeType) {
//		StringBuffer sb = new StringBuffer();
//		try {
//			InputStream is = coverImage.getBinaryStream();
//			ByteArrayOutputStream baos = new ByteArrayOutputStream();
//			int len = 0 ;
//			byte[] b = new byte[819200];
//			while ((len = is.read(b))!= -1) {
//				baos.write(b, 0, len);
//			}
//			byte[] data = baos.toByteArray();
//			Base64.Encoder be = Base64.getEncoder();
//			String sdata = new String(be.encode(data));
//			sb.append("data:");
//			sb.append(mimeType);
//			sb.append(";base64,");
//			sb.append(sdata);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return sb.toString();
//	}


	@GetMapping(value = "/ch04/_03/allPublishers.json", produces = { "application/json; charset=UTF-8" })
	public @ResponseBody List<PublisherBean> getAllPublishers() {
		List<PublisherBean> publishers = publisherService.getAllPublisher();
		
		return publishers;
	}

	@GetMapping(value = "/ch04/_03/allBooks.json", produces = { "application/json; charset=UTF-8" })
	public @ResponseBody List<BookBean> getAllBooks() {
		List<BookBean> books = bookService.getAllBooksJSON();
		System.out.println("books=" + books);
		return books;
	}

	@GetMapping("/ch04/_03/getBookImage")
	public ResponseEntity<byte[]> getBookImage(@RequestParam("no") Integer no) {
		ResponseEntity<byte[]> re = null;
		BookBean bean = bookService.getBook(no);
		String filename = bean.getFileName();
		Blob blob = bean.getCoverImage();
		String mimeType = ctx.getMimeType(filename);
		MediaType mediaType = MediaType.valueOf(mimeType);
		HttpHeaders headers = new HttpHeaders();
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			InputStream is = blob.getBinaryStream();
			byte[] b = new byte[81920];
			int len = 0;
			while ((len = is.read(b)) != -1) {
				baos.write(b, 0, len);
			}
			headers.setContentType(mediaType);
			headers.setCacheControl(CacheControl.noCache().getHeaderValue());
			re = new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	@GetMapping("/ch04/_05/getBooksByPubllisher.json")
	public @ResponseBody Map<String, Object> getBooksByPubllisher(@RequestParam("publisherId") Integer publisherId) {
		Map<String, Object> mapData = new HashMap<>();
		List<BookBean> list = bookService.getBooksByPublisherId(publisherId);
		mapData.put("bookBeanList", list);

		Map<String, Object> map = bookService.getBooksAmountByPublisherId(publisherId);
		Set<String> set = map.keySet();
		for (String key : set) {
			mapData.put(key, map.get(key));
		}
		return mapData;
	}

	@GetMapping(value = "/ch04/_07/pagingBookData.json", produces = { "application/json; charset=UTF-8" })
	public @ResponseBody Map<String, Object> getPageBook(
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(value = "totalPage", required = false) Integer totalPage) {

		if (totalPage == null) {
			totalPage = bookService.getTotalPages();
		}

		Map<String, Object> map = new HashMap<>();

		List<BookBean> list = bookService.getPageBooks(pageNo);
		map.put("list", list);
		map.put("totalPage", totalPage);
		map.put("currPage", pageNo);

		return map;
	}
}
