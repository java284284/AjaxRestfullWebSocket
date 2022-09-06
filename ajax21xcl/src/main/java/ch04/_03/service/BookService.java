package ch04._03.service;

import java.util.List;
import java.util.Map;

import ch04._03.model.BookBean;

public interface BookService {
	public Integer getBookId();
	public void setBookId(Integer bookId);
	BookBean getBookTextOnly(int bookId);
	BookBean getBook(int bookId);
	public List<BookBean> getAllBooksJSON();
	public List<BookBean> getPageBooks(Integer pageNo);
	
	public int getTotalPages();
	public List<BookBean> getBooksByPublisherId(int publisherId);
	public Map<String, Object> getBooksAmountByPublisherId(int publisherId);
}
