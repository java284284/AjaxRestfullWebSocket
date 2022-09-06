package ch04._03.dao;

import java.util.List;
import java.util.Map;

import ch04._03.model.BookBean;

public interface BookDao {
	Integer getBookId();
	void setBookId(Integer bookId);
	BookBean getBookTextOnly(Integer bookId);
	BookBean getBook(Integer bookId);
	List<BookBean> getAllBooksJSON();
	List<BookBean> getPageBooks(Integer pageNo);
	int getTotalPages();
	public Map<String, Object> getBooksAmountByPublisherId(int publisherId);
	
	List<BookBean> getBooksByPublisherId(int publisherId);
	
}
