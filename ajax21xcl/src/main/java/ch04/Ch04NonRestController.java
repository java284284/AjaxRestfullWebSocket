package ch04;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch04._03.model.BookBean;
import ch04._03.service.BookService;

@Controller
public class Ch04NonRestController {

	@Autowired
	ServletContext ctx;

	@Autowired
	BookService bookService;
	
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

}
