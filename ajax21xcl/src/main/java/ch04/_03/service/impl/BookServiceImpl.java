package ch04._03.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch04._03.dao.BookDao;
import ch04._03.model.BookBean;
import ch04._03.service.BookService;

@Service
@Transactional
public class BookServiceImpl implements BookService {
	
	BookDao dao;
	
	ServletContext ctx;

	@Autowired
	public BookServiceImpl(BookDao dao, ServletContext ctx) {
		this.dao = dao;
		this.ctx = ctx;
	}
	
	@Override
	public Integer getBookId() {
		return dao.getBookId();
	}

	@Override
	public void setBookId(Integer bookId) {
		dao.setBookId(bookId);
	}

	@Override
	public BookBean getBookTextOnly(int bookId) {
		return dao.getBookTextOnly(bookId);
	}

	@Override
	public List<BookBean> getAllBooksJSON() {
		List<BookBean> books = dao.getAllBooksJSON();
		for(BookBean book : books) {
			String mimeType = ctx.getMimeType(book.getFileName());
			String dataUri = getDataUri(book.getCoverImage(), mimeType);
			book.setDataUri(dataUri);
		}
		
		return books;
	}

	@Override
	public List<BookBean> getPageBooks(Integer pageNo) {
		return dao.getPageBooks(pageNo);
	}

	@Override
	public int getTotalPages() {
		return dao.getTotalPages();
	}

	@Override
	public List<BookBean> getBooksByPublisherId(int publisherId) {
		return dao.getBooksByPublisherId(publisherId);
	}

	@Override
	public Map<String, Object> getBooksAmountByPublisherId(int publisherId) {
		return dao.getBooksAmountByPublisherId(publisherId);
	}

	
	
	public BookBean findById(int bookId) {
		
		
		return getBook(bookId);
	}
	
	@Override
	public BookBean getBook(int bookId) {
		BookBean book = dao.getBook(bookId);
		String mimeType = ctx.getMimeType(book.getFileName());
		String dataUri = getDataUri(book.getCoverImage(), mimeType);
		book.setDataUri(dataUri);
		
		return dao.getBook(bookId);
	}
	private String getDataUri(Blob coverImage, String mimeType) {
		StringBuffer sb = new StringBuffer();
		try {
			InputStream is = coverImage.getBinaryStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int len = 0 ;
			byte[] b = new byte[819200];
			while ((len = is.read(b))!= -1) {
				baos.write(b, 0, len);
			}
			byte[] data = baos.toByteArray();
			Base64.Encoder be = Base64.getEncoder();
			String sdata = new String(be.encode(data));
			sb.append("data:");
			sb.append(mimeType);
			sb.append(";base64,");
			sb.append(sdata);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
